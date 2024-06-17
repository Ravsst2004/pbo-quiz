import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Class.*;
import Write.Write;

public class App {
    private static ArrayList<Question> questions = new ArrayList<Question>();
    private static Scanner userInput = new Scanner(System.in);
    private final static String MCQ_FILE_PATH = "file/mcq/";
    private final static String TF_FILE_PATH = "file/tf/";

    public static void main(String[] args) throws FileNotFoundException {
        boolean running = true;
        while (running) {
            System.out.println("\nQuiz System");
            System.out.println("1. Multiple Choice Quiz");
            System.out.println("2. True/False Quiz");
            System.out.println("3. Tulis Soal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = userInput.nextLine().trim();
            try {
                int option = Integer.parseInt(input);

                switch (option) {
                    case 1:
                        chooseFile(MCQ_FILE_PATH);
                        break;
                    case 2:
                        chooseFile(TF_FILE_PATH);
                        break;
                    case 3:
                        writeCsvFile();
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        userInput.close();
    }

    public static void chooseFile(String filepath) throws FileNotFoundException {
        String[] files = getFileFromFolder(filepath);
        if (files == null) {
            System.out.println("No files found in " + filepath);
            return;
        }

        if (files.length > 0 && files != null) {
            int number = 1;
            for (String file : files) {
                System.out.println(number + ". " + file);
                number++;
            }

            try {
                System.out.println("Choose a file: ");
                int choice = userInput.nextInt();
                userInput.nextLine();

                if (choice > 0 && choice <= files.length) {
                    String filePath = files[choice - 1];
                    System.out.println(filePath);
                    readCsvFile(filePath);
                    runQuiz();
                } else {
                    System.out.println("Invalid number");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("No files found in " + filepath);
            return;
        }

    }

    public static String[] getFileFromFolder(String filepath) {
        File file = new File(filepath);
        File[] files = file.listFiles();
        if (files == null) {
            System.out.println("No files found in " + filepath);
            return null;
        }
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getPath();
        }
        return fileNames;
    }

    public static void runQuiz() {
        if (questions.isEmpty()) {
            System.out.println("Quiz is empty!");
            return;
        }

        int score = 0;
        for (Question question : questions) {
            do {
                question.getQuestion();
                System.out.print("Answer: ");
                String answer = userInput.nextLine().toUpperCase().trim();

                if (question instanceof MultipleQuestion) {
                    if (!answer.matches("[ABCD]")) {
                        System.out.println("Invalid answer. Please enter A, B, C, or D.");
                    } else {
                        if (question.checkAnswer(answer)) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Wrong!");
                        }
                        break;
                    }
                } else if (question instanceof TrueFalseQuestion) {
                    if (!answer.matches("[AB]")) {
                        System.out.println("Invalid answer. Please enter A or B.");
                    } else {
                        if (question.checkAnswer(answer)) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Wrong!");
                        }
                        break;
                    }
                }
            } while (true);
        }
        System.out.println("Your score: " + score);
        questions.clear();
    }

    public static void readCsvFile(String filepath) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));

        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datas = line.split(",");
                if (datas[0].equalsIgnoreCase("MCQ")) {
                    ArrayList<String> options = new ArrayList<String>();
                    options.add(datas[2]);
                    options.add(datas[3]);
                    options.add(datas[4]);
                    options.add(datas[5]);
                    questions.add(new MultipleQuestion(datas[1], options, datas[6]));
                } else if (datas[0].equalsIgnoreCase("TF")) {
                    boolean correctAnswer = Boolean.parseBoolean(datas[2].trim());
                    questions.add(new TrueFalseQuestion(datas[1], correctAnswer));
                }
            }
            System.out.println("Quiz loaded successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void writeCsvFile() {
        Write write = new Write();
        write.tulisSoal();
        write.writeCSV();
    }
}

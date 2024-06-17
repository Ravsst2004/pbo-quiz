import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import Class.*;
import Write.Write;
  
public class App {
    private static final ArrayList <Question> questions = new ArrayList<>();
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
     while (true) {
            System.out.println("\nQuiz System");
            System.out.println("1. Multiple Choice Quiz");
            System.out.println("2. True/False Quiz");
            System.out.println("3. Tulis Soal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

                int option = userInput.nextInt();
                userInput.nextLine();
                
                switch (option) {
                    case 1:
                        readCsvFile("file/MCQ/css.csv");
                        runQuiz();
                        break;
                    case 2:
                        readCsvFile("file/tf/css.csv");
                        runQuiz();
                        break;
                    case 3:
                        writeCsvFile();
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        userInput.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
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

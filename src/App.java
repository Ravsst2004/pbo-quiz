import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.Quiz.Quiz;
import Class.ReadFile.ReadCSV;
import Class.Student.Student;

public class App {
    // Scanner for user input
    static Scanner userInput = new Scanner(System.in);
    static Quiz quiz = new Quiz();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.print("Input your name : ");
        String name = userInput.nextLine();
        System.out.println("Welcome " + name);

        while (true) {
            try {
                System.out.println("1. Start Quiz");
                System.out.println("2. View Score");
                System.out.println("3. Exit");
                System.out.println("Input options : ");
                int option = userInput.nextInt();
                userInput.nextLine();
                switch (option) {
                    case 1:
                        quiz.startQuiz();
                        break;
                    case 2:
                        System.out.println("View Score");
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("There is no such option");
                        break;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.ReadFile.ReadCSV;
import Class.Student.Student;

public class App {
    // Scanner for user input
    static Scanner inputUser = new Scanner(System.in);
    // Array of students (for save data students)
    static Student[] students = new Student[4];
    static List<String[]> dataList = new ArrayList<>();

    public static void main(String[] args) {
        dataList = ReadCSV.readFile("CsvFile/question.csv");
        for (String[] row : dataList) {
            for (String item : row) {
                System.out.println(item + " ");
            }
            System.out.println();
        }
    }
}

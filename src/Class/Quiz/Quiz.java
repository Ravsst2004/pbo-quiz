package Class.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.ReadFile.ReadCSV;
import Class.Student.Student;

public class Quiz {
  private List<Student> students;
  private List<String[]> questionList;

  public Quiz() {
    students = new ArrayList<>();
    questionList = ReadCSV.readFile("CsvFile/question.csv");
  }

  public void startQuiz() {
    Scanner userInput = new Scanner(System.in);

  }

}

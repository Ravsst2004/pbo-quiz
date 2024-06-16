package Class;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Class.Question;

public class MultipleQuestion extends Question {
  private ArrayList<String> options;
  private String correctAnswer;

  public MultipleQuestion(String question, ArrayList<String> options, String correctAnswer) {
    super(question);
    this.options = options;
    this.correctAnswer = correctAnswer;
  }

  @Override
  public boolean checkAnswer(String answer) {
    answer = answer.toUpperCase();
    int answerIndex = answer.charAt(0) - 'A';
    return answerIndex == options.indexOf(correctAnswer);
  }

  @Override
  public void getQuestion() {
    super.getQuestion();
    for (int i = 0; i < options.size(); i++) {
      System.out.println((char) ('A' + i) + ". " + options.get(i));
    }
  }
}

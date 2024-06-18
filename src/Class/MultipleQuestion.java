package Class;

import java.util.ArrayList;

public class MultipleQuestion extends Question {
  private ArrayList<String> options;
  private String correctAnswer;

  public MultipleQuestion(String question, ArrayList<String> options, String correctAnswer) {
    super(question);
    this.options = options;
    this.correctAnswer = correctAnswer.toLowerCase();
  }

  @Override
  public boolean checkAnswer(String answer) {
    answer = answer.toLowerCase();
    return answer.equals(correctAnswer);
  }

  @Override
  public void getQuestion() {
    super.getQuestion();
    for (int i = 0; i < options.size(); i++) {
      System.out.println((char) ('A' + i) + ". " + options.get(i));
    }
  }
}

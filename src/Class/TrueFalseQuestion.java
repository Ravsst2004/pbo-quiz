package Class;

import Class.Question;

public class TrueFalseQuestion extends Question {
  private boolean correctAnswer;

  public TrueFalseQuestion(String question, boolean correctAnswer) {
    super(question);
    this.correctAnswer = correctAnswer;
  }

  @Override
  public boolean checkAnswer(String answer) {
    return (answer.equalsIgnoreCase("A") && correctAnswer) || (answer.equalsIgnoreCase("B") && !correctAnswer);
  }

  @Override
  public void getQuestion() {
    super.getQuestion();
    System.out.println("A. True");
    System.out.println("B. False");
  }
}

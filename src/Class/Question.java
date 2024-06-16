package Class;

public class Question {
  protected String question;

  public Question(String question) {
    this.question = question;
  }

  public boolean checkAnswer(String answer) {
    return false;
  }

  public void getQuestion() {
    System.out.println(question);
  }
}

package Write;

public class Soal {
    private String pertanyaan;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String jawabanBenar;
    
    public Soal(String pertanyaan, String optionA, String optionB, String optionC, String optionD, String jawabanBenar) {
        this.pertanyaan = pertanyaan;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.jawabanBenar = jawabanBenar;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }
}

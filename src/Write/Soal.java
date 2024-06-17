package Write;

import java.util.ArrayList;
import java.util.List;

class Soal {
    private String tipeSoal;
    private String soal;
    private List<String> options;
    private String jawabanBenar;
    private boolean isTrueFalse;

    public Soal(String tipeSoal, String soal, List<String> options, String jawabanBenar) {
        this.tipeSoal = tipeSoal;
        this.soal = soal;
        this.options = options;
        this.jawabanBenar = jawabanBenar;
        this.isTrueFalse = false;
    }

    public Soal(String tipeSoal, String soal, boolean isTrueFalse) {
        this.tipeSoal = tipeSoal;
        this.soal = soal;
        this.options = new ArrayList<>();
        this.jawabanBenar = isTrueFalse ? "TRUE" : "FALSE";
        this.isTrueFalse = isTrueFalse;
    }

    public String getTipeSoal() {
        return tipeSoal;
    }

    public String getSoal() {
        return soal;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }

    public boolean isTrueFalse() {
        return isTrueFalse;
    }
}

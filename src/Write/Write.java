package Write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Write {

    private List<Soal> soalList;
    private String namaSoal;
    private String tipeSoal;
    private int tSoal = 5;
    private Scanner kInput;

    public Write() {
        soalList = new ArrayList<>();
        kInput = new Scanner(System.in);
    }

    public void tulisSoal() {
        System.out.println("Tulis Nama Soal Anda Dibawah Ini: ");
        this.namaSoal = kInput.nextLine();
        System.out.println("Pilih tipe soal (MCQ Atau TF): ");

        while (true) {
            this.tipeSoal = kInput.nextLine().toUpperCase();
            if (tipeSoal.equals("MCQ") || tipeSoal.equals("TF")) {
                break;
            } else {
                System.out.println("Tipe soal tidak valid. Silakan masukkan MCQ atau TF.");
            }
        }
        if (tipeSoal.equals("MCQ")) {
            tulisSoalMCQ();
        } else {
            tulisSoalTrueFalse();
        }
    }

    public void tulisSoalMCQ() {
        for (int i = 0; i < this.tSoal; i++) {
            System.out.printf("Soal Nomor %d: %n", i + 1);
            System.out.print("Soal: ");
            String soal = kInput.nextLine();
            List<String> options = new ArrayList<>();
            char optionLabel = 'A';
            for (int j = 0; j < 4; j++) {
                System.out.printf("Option %c: ", optionLabel);
                options.add(kInput.nextLine());
                optionLabel++;
            }
            System.out.print("Jawaban yang benar (A, B, C, atau D): ");
            String jawabanBenar = kInput.nextLine().toUpperCase();
            while (!jawabanBenar.matches("[ABCD]")) {
                System.out.println("Jawaban tidak valid. Masukan A, B, C, or D.");
                jawabanBenar = kInput.nextLine().toUpperCase();
            }
            Soal s = new Soal("MCQ", soal, options, jawabanBenar);
            soalList.add(s);
        }
        writeCSV(); // Call writeCSV after collecting all questions
    }

    private void tulisSoalTrueFalse() {
        for (int i = 0; i < this.tSoal; i++) {
            System.out.printf("Soal Nomor %d: %n", i + 1);
            System.out.print("Soal: ");
            String soal = kInput.nextLine();
            String jawabanBenar;
            while (true) {
                System.out.print("Jawaban yang benar (True / False): ");
                jawabanBenar = kInput.nextLine().toUpperCase();
                if (jawabanBenar.equals("TRUE") || jawabanBenar.equals("FALSE")) {
                    break;
                } else {
                    System.out.println("Jawaban tidak valid. Silakan masukkan True atau False.");
                }
            }
            Soal s = new Soal("TF", soal, jawabanBenar.equals("TRUE"));
            soalList.add(s);
        }
        writeCSV(); // Call writeCSV after collecting all questions
    }

    public void writeCSV() {
        String directoryPath = "./file/";
        String fullPath = directoryPath +this.tipeSoal+"/"+ this.namaSoal + ".csv";

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fullPath))) {
            for (Soal s : soalList) {
                fileWriter.write(s.getTipeSoal() + ",");
                fileWriter.write(s.getSoal() + ",");
                if (s.isTrueFalse()) {
                    fileWriter.write(s.getJawabanBenar());
                } else {
                    List<String> options = s.getOptions();
                    for (int i = 0; i < options.size(); i++) {
                        fileWriter.write(options.get(i));
                        if (i < options.size() - 1) {
                            fileWriter.write(",");
                        }
                    }
                    fileWriter.write("," + s.getJawabanBenar());
                }
                fileWriter.newLine();
            }
            System.out.println("Data has been written to " + fullPath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

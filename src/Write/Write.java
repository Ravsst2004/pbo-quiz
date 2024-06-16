package Write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Write {

    private List<Soal> soalList;
    private String namaSoal;

    public Write() {
        soalList = new ArrayList<>();
    }

    public void tulisSoal() {
        try (Scanner kInput = new Scanner(System.in)) {
            int tSoal = 1;
            System.out.println("Tulis Nama Soal Anda Dibawah Ini: ");
            this.namaSoal = kInput.nextLine(); // Read the name of the quiz

            // Loop to get each question and its options
            for (int i = 0; i < tSoal; i++) {
                System.out.printf("Soal Nomor %d: %n", i + 1);

                System.out.println("Pilih tipe soal (MCQ / True or False): ");
                String tipeSoal;
                while (true) {
                    tipeSoal = kInput.nextLine().toUpperCase();
                    if (tipeSoal.equals("MCQ") || tipeSoal.equals("TRUE OR FALSE")) {
                        break;
                    } else {
                        System.out.println("Tipe soal tidak valid. Silakan masukkan MCQ atau True or False.");
                    }
                }

                if (tipeSoal.equals("MCQ")) {
                    tulisSoalMCQ();
                } else {

                }
            }
        }
    }

    public void tulisSoalMCQ() {
        try (Scanner kInput = new Scanner(System.in)) {
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
            if (!jawabanBenar.matches("[ABCD]")) {
                System.out.println("Jawaban tidak valid. Masukan A, B, C, or D.");
            }
            Soal s = new Soal(soal, options, jawabanBenar);
            soalList.add(s);
        }
    }

    public void writeCSV() {

        String directoryPath = "./file/mcq/";
        String fullPath = directoryPath + this.namaSoal + ".csv";

        try (FileWriter fileWriter = new FileWriter(fullPath)) {
            for (Soal s : soalList) {
                fileWriter.append(s.getPertanyaan()).append(",");
                fileWriter.append(s.getOptionA()).append(",");
                fileWriter.append(s.getOptionB()).append(",");
                fileWriter.append(s.getOptionC()).append(",");
                fileWriter.append(s.getOptionD()).append(",");
                fileWriter.append(s.getJawabanBenar()).append("\n");
            }
            System.out.println("Data has been written to " + fullPath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
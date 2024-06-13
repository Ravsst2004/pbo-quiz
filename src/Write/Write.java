package Write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Write {

    private List<Soal> soalList;

    public Write() {
        soalList = new ArrayList<>();
    }

    public void tulisSoal() {
        try (Scanner kInput = new Scanner(System.in)) {
            int tSoal = 10;
            System.out.println("Tulis Soal Anda Dibawah Ini: ");   
            for (int i = 0; i < tSoal; i++) {
                System.out.print("Soal Nomer " + (i + 1) + ": ");
                String soal = kInput.nextLine();
                System.out.print("Option A: ");
                String A = kInput.nextLine();
                System.out.print("Option B: ");
                String B = kInput.nextLine();
                System.out.print("Option C: ");
                String C = kInput.nextLine();
                System.out.print("Option D: ");
                String D = kInput.nextLine();
                System.out.print("Jawaban yang benar (A, B, C, atau D): ");
                String jawabanBenar = kInput.nextLine().toUpperCase();

                Soal s = new Soal(soal, A, B, C, D, jawabanBenar);
                soalList.add(s);
            }
        }
    }

    public void writeCSV(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write header
            fileWriter.append("Pertanyaan,Option A,Option B,Option C,Option D,Jawaban Benar\n");

            // Write data
            for (Soal s : soalList) {
                fileWriter.append(s.getPertanyaan()).append(",");
                fileWriter.append(s.getOptionA()).append(",");
                fileWriter.append(s.getOptionB()).append(",");
                fileWriter.append(s.getOptionC()).append(",");
                fileWriter.append(s.getOptionD()).append(",");
                fileWriter.append(s.getJawabanBenar()).append("\n");
            }
            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

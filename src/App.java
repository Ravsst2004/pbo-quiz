import java.util.List;

import Read.CSVReader;
import Write.Write;

public class App {
    public static void main(String[] args) {
        // Write write = new Write();
        // write.tulisSoal();
        // write.writeCSV("CsvFile/quiz_data.csv");

        CSVReader CSVreader = new CSVReader();
        List<String[]> data = CSVreader.readCSV("CsvFile/question.csv");
        int questionNumber = 1;
        char optionLetter = 'A';

        for (String[] questionData : data) {
            System.out.println(questionNumber + ". " + questionData[0]);
            for (int i = 1; i < questionData.length - 1; i++) {
                System.out.println("    " + optionLetter + ". " + questionData[i]);
                optionLetter++;
            }
            optionLetter = 'A';
            questionNumber++;
        }

    }
}

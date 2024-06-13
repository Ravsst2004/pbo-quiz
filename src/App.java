import java.util.ArrayList;
import java.util.List;

import ReadFile.CSVreader;
import Write.Write;

public class App {
    static List<String[]> dataList = new ArrayList<>();

    public static void main(String[] args) {
        // Write write = new Write();
        // write.tulisSoal();
        // write.writeCSV("CsvFile/quiz_data.csv");

        dataList = CSVreader.readFile("CsvFile/question.csv");
        for (String[] datas : dataList) {
            for (String data : datas) {
                System.out.println(data);
            }
        }
    }
}

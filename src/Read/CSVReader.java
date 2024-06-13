package Read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

  private String filePath;
  private String delimiter;

  public CSVReader(String filePath, String delimiter) {
    this.filePath = filePath;
    this.delimiter = delimiter;
  }

  public List<String[]> read() {
    List<String[]> data = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(delimiter);
        data.add(values);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }

  public static void main(String[] args) {
    CSVReader reader = new CSVReader("path/to/your/csvfile.csv", ",");
    List<String[]> data = reader.read();
    for (String[] row : data) {
      for (String value : row) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }
}

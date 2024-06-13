package Read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
  public List<String[]> readCSV(String filePath) {
    List<String[]> lines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        lines.add(data);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return lines;
  }
}

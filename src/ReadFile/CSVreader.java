package ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {
  public static List<String[]> readFile(String filePath) {
    BufferedReader reader = null;
    List<String[]> dataList = new ArrayList<>();

    try {
      reader = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] datas = line.split(",");
        dataList.add(datas);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return dataList;
  }
}

import Write.Write;

public class App {
    public static void main(String[] args) {
        Write write = new Write();
        write.tulisSoal();
        write.writeCSV("quiz_data.csv");
    }
}

//Alperen Bugay Taşkıran
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/infix.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                double result = InfixEvaluator.evaluate(line);
                if (Double.isFinite(result)) {
                    System.out.println(result);
                } else {
                    System.out.println("ERROR");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
        }
    }
}

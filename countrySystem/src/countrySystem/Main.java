package countrySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Country> countries = new ArrayList<>();

        // read of input.txt and create countries
        try {
            File inputFile = new File("src/input.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                long population = Long.parseLong(parts[1].replace(".", ""));
                String capitalCity = parts[2];
                String largestCity = parts[3];
                String language = parts[4];
                String currency = parts[5];
                countries.add(new Country(name, population, capitalCity, largestCity, language, currency));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("input.txt dosyası bulunamadı.");
            e.printStackTrace();
        }

        // read of query.txt and write.
        try {
            File queryFile = new File("src/query.txt");
            Scanner scanner = new Scanner(queryFile);
            QueryProcessor queryProcessor = new QueryProcessor(countries);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                queryProcessor.processQuery(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("query.txt dosyası bulunamadı.");
            e.printStackTrace();
        }
    }
}

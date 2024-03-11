package countrySystem;
import java.util.ArrayList;

public class QueryProcessor {
    private ArrayList<Country> countries;

    public QueryProcessor(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public void processQuery(String query) {
        String[] parts = query.split(" ");
        String queryType = parts[0];
        
        switch (queryType) {
            case "Query":
                handleQuery(parts);
                break;
            case "Add":
                handleAdd(parts);
                break;
            case "Delete":
                handleDelete(parts);
                break;
            default:
                System.out.println("Invalid Query : " + query);
        }
    }

    private void handleQuery(String[] parts) {
        if (parts.length < 3) {
            System.out.println("Incorrect query format : " + String.join(" ", parts));
            return;
        }
        String queryField = parts[1];
        String queryOperator = parts[2];
        String queryValue = parts[3];

        switch (queryOperator) {
            case ">":
                for (Country country : countries) {
                    if (queryField.equals("population") && country.getPopulation() > Long.parseLong(queryValue.replace(".", ""))) {
                        System.out.println(country.getName());
                    }
                }
                break;
            case "<":
                for (Country country : countries) {
                    if (queryField.equals("capital_city") && country.getCapitalCity().compareTo(queryValue) < 0) {
                        System.out.println(country.getName());
                    }
                }
                break;
            case "=":
                if (queryField.equals("largest_city")) {
                    for (Country country : countries) {
                        if (country.getLargestCity().equals(queryValue)) {
                            System.out.println(country.getName());
                        }
                    }
                } else if (queryField.equals("country")) {
                    for (Country country : countries) {
                        if (country.getName().equals(queryValue)) {
                            System.out.println(country.getName());
                        }
                    }
                }
                break;
            case "<=":
                for (Country country : countries) {
                    if (queryField.equals("population") && country.getPopulation() <= Long.parseLong(queryValue.replace(".", ""))) {
                        System.out.println(country.getName());
                    }
                }
                break;
            case ">=":
                for (Country country : countries) {
                    if (queryField.equals("population") && country.getPopulation() >= Long.parseLong(queryValue.replace(".", ""))) {
                        System.out.println(country.getName());
                    }
                }
                break;
            default:
                System.out.println("Invalid query operator: " + queryOperator);
        }
    }

    private void handleAdd(String[] parts) {
        if (parts.length != 7) {
            System.out.println("Incorrect Add query format: " + String.join(" ", parts));
            return;
        }
        String name = parts[1];
        long population = Long.parseLong(parts[2].replace(".", ""));
        String capitalCity = parts[3];
        String largestCity = parts[4];
        String language = parts[5];
        String currency = parts[6];
        countries.add(new Country(name, population, capitalCity, largestCity, language, currency));
    }

    private void handleDelete(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Incorrect Delete query format: " + String.join(" ", parts));
            return;
        }
        String name = parts[1];
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getName().equals(name)) {
                countries.remove(i);
                System.out.println("The country of " + name + " was deleted.");
                return;
            }
        }
        System.out.println(name + " country not found..");
    }
}

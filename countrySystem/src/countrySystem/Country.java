package countrySystem;

public class Country {
    private String name;
    private long population;
    private String capitalCity;
    private String largestCity;
    private String language;
    private String currency;

    public Country(String name, long population, String capitalCity, String largestCity, String language, String currency) {
        this.name = name;
        this.population = population;
        this.capitalCity = capitalCity;
        this.largestCity = largestCity;
        this.language = language;
        this.currency = currency;
    }

   

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }
}


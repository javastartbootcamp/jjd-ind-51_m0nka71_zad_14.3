import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        String fileName = "countries.csv";
        try {
            Map<String, HashSet<Country>> countriesMap = readFile(fileName);
            System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
            String userCountryCode = scanner.nextLine();
            printCountryStats(countriesMap, userCountryCode);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku countries.csv.");
        }
    }

    static Map<String, HashSet<Country>> readFile(String fileName) throws FileNotFoundException {
        Map<String, HashSet<Country>> countries = new HashMap<>();
        File file = new File(fileName);
        boolean fileExists = file.exists();
        try (Scanner scan = new Scanner(new File(fileName))) {
            if (fileExists) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] split = line.split(";");
                    String code = split[0];
                    BigInteger population = (new BigInteger(split[2]));
                    Country country = new Country(split[0], split[1], population);

                    HashSet<Country> codeSet = new HashSet<>();
                    codeSet.add(country);
                    countries.put(code, codeSet);
                }
            }
            return countries;
        }
    }

    private void printCountryStats(Map<String, HashSet<Country>> countries, String userCountryCode) {
        HashSet<Country> countriesSet = countries.get(userCountryCode);
        if (countriesSet == null) {
            System.out.println("Kod kraju " + userCountryCode + " nie został znaleziony.");
        } else {
            printAll(countriesSet);
        }
    }

    private void printAll(HashSet<Country> codes) {
        for (Country country : codes) {
            System.out.println(country);
        }
    }
}

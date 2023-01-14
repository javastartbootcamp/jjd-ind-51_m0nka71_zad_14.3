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
        Map<String, HashSet<Country>> countriesMap = readFile();
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        String userCountryCode = scanner.nextLine();
        printCountryStats(countriesMap, userCountryCode);
    }

    static Map<String, HashSet<Country>> readFile() {
        String fileName = "countries.csv";
        Map<String, HashSet<Country>> countries = new HashMap<>();
        try {
            Scanner scan = new Scanner(new File(fileName));
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
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku countries.csv.");
        }
        return countries;
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

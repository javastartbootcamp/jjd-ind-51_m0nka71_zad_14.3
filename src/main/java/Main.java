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
        Map<String, HashSet<Country>> countriesMap = CountryApp.readFile();
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        String userCountryCode = scanner.nextLine();
        printCountryStats(countriesMap, userCountryCode);
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

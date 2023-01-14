import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class CountryApp {

    private static String fileName = "countries.csv";

    static Map<String, HashSet<Country>> readFile() {
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
}

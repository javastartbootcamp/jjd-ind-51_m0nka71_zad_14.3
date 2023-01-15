import java.math.BigInteger;

public class Country {

    private String code;
    private String name;
    private BigInteger population;

    public Country(String code, String name, BigInteger population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return name + " (" + code + ")" + " ma " + population + " ludności.";
    }
}

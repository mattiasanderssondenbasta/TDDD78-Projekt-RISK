package RISK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Continent
{
    private String continentName;

    private ContinentTerritory[] territorys;

    private Map<String, ContinentTerritory[]> continents;

    public ContinentTerritory[] getTerritorys() {
        return territorys;
    }

    public Map<String, ContinentTerritory[]> getContinents() {
        return continents;
    }

    public String getContinentName() {
        return continentName;
    }

    public Continent(String continentName, ContinentTerritory[] territorys) {
        this.continentName = continentName;
        this.territorys = territorys;
        Map<String, ContinentTerritory[]> test = new HashMap<>();
        test.put(this.continentName, this.territorys);
        this.continents = test;
    }


    @Override public String toString() {
        return "Continent{" +
               "continentName='" + continentName + '\'' +
               ", territorys=" + Arrays.toString(territorys) +
               '}';
    }

}

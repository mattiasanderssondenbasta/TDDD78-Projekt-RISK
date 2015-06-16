package RISK;

import java.util.HashMap;
import java.util.Map;

public class Player
{
    private String name;

    private int availableArmies;

    private Map<ContinentTerritory, Integer> garrisons = new HashMap<ContinentTerritory, Integer>() {
    };

    public Map<ContinentTerritory, Integer> getGarrisons() {
        return garrisons;
    }

    public String getName() {
        return name;
    }

    public int getAvailableArmies() {
        return availableArmies;
    }

    public void setAvailableArmies(int availableArmies) {
        this.availableArmies = availableArmies;
    }

    //Konstruktor
    public Player(String name) {
        this.name = name;

        /*Map<ContinentTerritory, Integer> toBeGarrisons = new HashMap<>();
        toBeGarrisons.put(ownedContinentTerritory, garrison);
        this.garrisons = toBeGarrisons;*/
    }

    @Override public String toString() {
        return "Player{" +
               "name='" + name + '\'' +
               ", garrisons=" + garrisons +
               '}';
    }

    public boolean isOwner(ContinentTerritory territory) {
        boolean res = false;
        for (ContinentTerritory continentTerritory : garrisons.keySet()) {
            if (continentTerritory != null && continentTerritory.equals(territory)) {
                res = true;
            }
        }
        return res;
    }

    public void assignContinentTerritory(ContinentTerritory territory) {
        garrisons.put(territory, 1);
    }

}

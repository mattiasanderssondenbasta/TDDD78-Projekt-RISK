package RISK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.*;

public class ContinentTerritory
{
    private int startXCoordinate, startYCoordinate = 0;

    private int endXCoordinate, endYCoordinate = 0;

    private String continentTerritoryName;

    private String[] neighbours;
    
    // Map with a ContinentTerritory connected to its neighbours
    private Map<String, String[]> continentTerritory;


    public int getEndYCoordinate() {
        return endYCoordinate;
    }

    public int getEndXCoordinate() {
        return endXCoordinate;
    }

    public int getStartYCoordinate() {
        return startYCoordinate;
    }

    public int getStartXCoordinate() {
        return startXCoordinate;
    }

    public String getContinentTerritoryName() {
        return continentTerritoryName;
    }

    public String[] getNeighbours() {
        return neighbours;
    }

    public void setStartXCoordinate(final int startXCoordinate) {
        this.startXCoordinate = startXCoordinate;
    }

    public void setStartYCoordinate(final int startYCoordinate) {
        this.startYCoordinate = startYCoordinate;
    }

    public void setEndXCoordinate(final int endXCoordinate) {
        this.endXCoordinate = endXCoordinate;
    }

    public void setEndYCoordinate(final int endYCoordinate) {
        this.endYCoordinate = endYCoordinate;
    }

    public ContinentTerritory(String continentTerritoryName, String[] neighbours) {
        this.continentTerritoryName = continentTerritoryName;
        this.neighbours = neighbours;
        Map<String, String[]> test = new HashMap<>();
        test.put(this.continentTerritoryName, this.neighbours);
        this.continentTerritory = test;
    }

    @Override public String toString() {
        return "ContinentTerritory{" +
               "continentTerritoryName='" + continentTerritoryName + '\'' +
               ", neighbours=" + Arrays.toString(neighbours) + '}';
    }

    public boolean isNeighbour(String territoryName) {
        boolean res = false;
        for (String neighbour : this.neighbours) {
            if (territoryName.equals(neighbour)) {
                res = true;
                break;
            }
        }
        return res;
    }



}

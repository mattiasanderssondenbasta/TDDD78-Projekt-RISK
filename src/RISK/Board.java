package RISK;

import javax.swing.*;

public class Board
{
    private static Continent[] world;

    private static ContinentTerritory[][] board;

    public static void main(String[] args) {

        World.initializeWorld();
        world = World.getWorld();

        JFrame frame = new RiskFrame(world);
        
    }

    public static void initBoard() {
        int height = 6;
        int width = 11;
        board = new ContinentTerritory[width][height];
        for (int i = 0; i < 6; i++) {
            ContinentTerritory[] currentContinentTerritorys = world[i].getTerritorys();
            for (int j = 0; j < currentContinentTerritorys.length; j++) {
                board[j][i] = currentContinentTerritorys[j];
            }
        }
    }

    public static ContinentTerritory[][] getBoard() {
        return board;
    }

}

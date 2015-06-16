package RISK;

import javax.swing.*;
import java.util.Random;

public class GameEngine
{
    private Phase currentPhase;

    private Player currentPlayer;

    private Player[] landOwners;

    private Continent[] world = new Continent[1];

    public Player[] getLandOwners() {
		return landOwners;
    }

    public Continent[] getWorld() {
		return world;
    }

    public GameEngine() {
		String inputPlayer1 =
	    	 JOptionPane.showInputDialog("Please input name of player1");
		String inputPlayer2 =
	  	   JOptionPane.showInputDialog("Please input name of player2");
		Player player1 = new Player(inputPlayer1);
		Player player2 = new Player(inputPlayer2);
		landOwners = new Player[2];
		landOwners[0] = player1;
		landOwners[1] = player2;
		currentPlayer = landOwners[0];
		player1.setAvailableArmies(1);
		// Player 2 starts with 1 territory less but gets 3 more armies at the start
		player2.setAvailableArmies(1);
		currentPhase = Phase.START;

		ContinentTerritory[][] board = Board.getBoard();
		int z = 0;
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if ((z%2) == 1) {
					player2.assignContinentTerritory(board[j][i]);
				} else {
					player1.assignContinentTerritory(board[j][i]);
				}
				z++;
			}
		}

    }

	public Phase getCurrentPhase() {
		return currentPhase;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPhase(Phase currentPhase) {
		this.currentPhase = currentPhase;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

    public void addArmy(ContinentTerritory territory) {
	for (Player landOwner : landOwners) {
	    if (landOwner.isOwner(territory)) {
		int x = landOwner.getGarrisons().get(territory);
		x++;
		landOwner.getGarrisons().put(territory, x);
	    }
	}
    }

    public void removeArmy(ContinentTerritory territory) {
	for (Player landOwner : landOwners) {
	    if (landOwner.isOwner(territory)) {
		int x = landOwner.getGarrisons().get(territory);
		x--;
		landOwner.getGarrisons().put(territory, x);
	    }
	}
    }

    public void resolveAttack(ContinentTerritory attacker, ContinentTerritory defender) {
	Player attackingPlayer = new Player("Attacker");
	Player defendingPlayer = new Player("Defender");

	int[] attackerThrows = attackerThrows(attacker);
	int[] defenderThrows = defenderThrows(defender);
	for (Player landOwner : landOwners) {
	    if (landOwner.isOwner(attacker)) {
		attackingPlayer = landOwner;
	    } else if (landOwner.isOwner(defender)) {
		defendingPlayer = landOwner;
	    }
	}
	if (attackerThrows[0] <= defenderThrows[0]) {
	    System.out.println("Winner is Defender!");
	    attackingPlayer.getGarrisons().put(attacker, attackingPlayer.getGarrisons().get(attacker)-1);
	} else if (attackerThrows[0] > defenderThrows[0]) {
	    System.out.println("Winner is Attacker!");
	    defendingPlayer.getGarrisons().put(defender, defendingPlayer.getGarrisons().get(defender)-1);
	} else if (attackerThrows[1] <= defenderThrows[1]) {
	    System.out.println("Winner is Defender!");
	    attackingPlayer.getGarrisons().put(attacker, attackingPlayer.getGarrisons().get(attacker)-1);
	} else if (attackerThrows[1] > defenderThrows[1]) {
	    defendingPlayer.getGarrisons().put(defender, defendingPlayer.getGarrisons().get(defender)-1);
	    System.out.println("Winner is Attacker!");
	}
    }

    public int[] defenderThrows(ContinentTerritory defender) {
	int[] defenderThrows = new int[2];
	for (Player landOwner : landOwners) {
	    if (landOwner.isOwner(defender)) {
		int attackingArmies = landOwner.getGarrisons().get(defender)-1;
		if (attackingArmies == 1) {
		    int firstDefend = diceThrow();
		    defenderThrows[0] = firstDefend;
		} else if (2 <= attackingArmies) {
		    int firstDefend = diceThrow();
		    int secondDefend = diceThrow();
		    defenderThrows[0] = firstDefend;
		    defenderThrows[1] = secondDefend;
		    defenderThrows = highestDiceThrows(firstDefend, secondDefend, 0);
		}
	    }
	}
	return defenderThrows;
    }

    public int[] attackerThrows(ContinentTerritory attacker) {
	int[] attackerThrows = new int[2];
	for (Player landOwner : landOwners) {
	    if (landOwner.isOwner(attacker)) {
		int attackingArmies = landOwner.getGarrisons().get(attacker)-1;
		if (attackingArmies == 1) {
		    int firstAttack = diceThrow();
		    attackerThrows[0] = firstAttack;
		} else if (attackingArmies == 2) {
		    int firstAttack = diceThrow();
		    int secondAttack = diceThrow();
		    attackerThrows[0] = firstAttack;
		    attackerThrows[1] = secondAttack;
		    attackerThrows = highestDiceThrows(firstAttack, secondAttack, 0);
		} else if (3 <= attackingArmies) {
		    int firstAttack = diceThrow();
		    int secondAttack = diceThrow();
		    int thirdAttack = diceThrow();
		    attackerThrows = highestDiceThrows(firstAttack, secondAttack, thirdAttack);
		}
	    }
	}
	return attackerThrows;
    }

    public int diceThrow() {
	Random rnd = new Random();
	int diceNumber = rnd.nextInt(5)+1;
	return diceNumber;
    }

    public int[] highestDiceThrows(int x, int y, int z) {
	int[] diceThrows = new int[2];
	int i = 0;
	while (diceThrows[1] == 0) {
	    if (x >= y || x >= z) {
		diceThrows[i] = x;
		i++;
	    } else if (y >= x | y >= z) {
		diceThrows[i] = y;
		i++;
	    } else if (z >= x | z >= y) {
		diceThrows[i] = z;
		i++;
	    }
	}
	if (diceThrows[1] > diceThrows[0]) {
	    int j = diceThrows[1];
	    diceThrows[1] = diceThrows[0];
	    diceThrows[0] = j;
	}
	return diceThrows;
    }


    public boolean checkIfOwner(ContinentTerritory territory, Player currentPlayer) {
		if (currentPlayer.getGarrisons() != null && currentPlayer.getGarrisons().containsKey(territory)) {
			return true;
 		} else {
			return false;
		}
    }

	public void nextPLayer() {
		for (Player landOwner : landOwners) {
			if (!(landOwner.equals(currentPlayer))) {
				currentPlayer = landOwner;
				break;
			}
		}
	}

}

package RISK;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.List;

public class RiskComponent extends JComponent implements MouseListener
{
    private JTextArea textArea;

    private GameEngine riskEngine;

    private Continent[] world;

    private Map<String, Color> continentColors;

    private ContinentTerritory[][] board;

    private Continent temp = null;

    private List<MouseListener> mouseListeners = new ArrayList<>();

    private ContinentTerritory firstSelectedContinentTerritory;

    private ContinentTerritory secondSelectedContinentTerritory;

    public RiskComponent(Continent[] worldToBe) {
	this.world = worldToBe;
        this.board = Board.getBoard();

        this.continentColors = new HashMap<>();
        this.continentColors.put("Africa", Color.RED);
        this.continentColors.put("Asia", Color.GREEN);
        this.continentColors.put("Oceania", Color.BLUE);
        this.continentColors.put("Europe", Color.ORANGE);
        this.continentColors.put("North America", Color.PINK);
        this.continentColors.put("South America", Color.MAGENTA);

        this.riskEngine = new GameEngine();

        textArea = new JTextArea("Commands:", 10, 25);
       	textArea.setEditable(false);
        //textArea.setLayout(new BorderLayout());
       	//textArea.setPreferredSize(textArea.getPreferredSize());

        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public GameEngine getRiskEngine() {
        return riskEngine;
    }

    @Override public Dimension getPreferredSize() {
            super.getPreferredSize();
            int width = 12*80;
            int height = 7*80;
            return new Dimension(width, height);
    }


    @Override public void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;


        for (int k = 0; k < board.length; k++) {
            for (int j = 0; j < board[0].length; j++) {
                    if (containsTerritory(board[k][j])) {
                        Color color = continentColors.get(temp.getContinentName());
                        g2d.setColor(color);
                        g2d.fillRect(k * 80 + 50, j * 80 + 50, 75, 50);
                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
                        g2d.drawString(board[k][j].getContinentTerritoryName(), k * 80 + 50, j * 80 + 50);

                        g2d.drawString("" + riskEngine.getCurrentPhase() + " PHASE", 450, 20);
                        g2d.drawString("" + riskEngine.getCurrentPlayer().getName() + "'s turn", 650, 20);

                        for (Player player: riskEngine.getLandOwners()) {
                            if (riskEngine.checkIfOwner(board[k][j], player)) {
                                g2d.drawString(player.getName(), k * 80 + 50, j * 80 + 65);
                                g2d.drawString("" + player.getGarrisons().get(board[k][j]), k * 80 + 50, j * 80 + 75);
                            }
                        }



                        board[k][j].setStartXCoordinate(k * 80);
                        board[k][j].setStartYCoordinate(j * 80);
                        board[k][j].setEndXCoordinate(k * 80);
                        board[k][j].setEndYCoordinate(j * 80);

                    }
                }
            }
        }


    public boolean containsTerritory(ContinentTerritory territory) {
        boolean res = false;
        for (int i = 0; i < world.length; i++) {
            ContinentTerritory[] test = world[i].getTerritorys();
            for (ContinentTerritory continentTerritory : test) {
                if (continentTerritory.equals(territory)) {
                    res = true;
                    this.temp = world[i];
                    break;
                }
            }
        }
        return res;
    }

    public void addMouseListener(MouseListener ml) {
        mouseListeners.add(ml);
    }

    public void processMouseEvent(MouseEvent event) {

        for (MouseListener mouseListener : mouseListeners) {
            if (event.getID() == MouseEvent.MOUSE_PRESSED) {
                mouseListener.mousePressed(event);
            } else if (event.getID() == MouseEvent.MOUSE_CLICKED) {
                mouseListener.mouseClicked(event);
            } else if (event.getID() == MouseEvent.MOUSE_RELEASED) {
                mouseListener.mouseReleased(event);
            } else if (event.getID() == MouseEvent.MOUSE_ENTERED) {
                mouseListener.mouseEntered(event);
            } else if (event.getID() == MouseEvent.MOUSE_EXITED) {
                mouseListener.mouseExited(event);
            }
        }
    }

    public void chooseFirstContinentTerritory(int x, int y) {
        outerloop:
        for (final ContinentTerritory[] aBoard : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (aBoard[j] != null && aBoard[j].getStartXCoordinate() + 59 <= x && x <= aBoard[j].getEndXCoordinate() + 109 &&
                    aBoard[j].getStartYCoordinate() + 82 <= y && y <= aBoard[j].getEndYCoordinate() + 132) {
                    firstSelectedContinentTerritory = aBoard[j];
                    break outerloop;
                }
            }
        }
    }

    public void chooseSecondContinentTerritory(int x, int y) {
        outerloop:
        for (final ContinentTerritory[] aBoard : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (aBoard[j] != null && aBoard[j].getStartXCoordinate() + 59 <= x && x <= aBoard[j].getEndXCoordinate() + 109 &&
                        aBoard[j].getStartYCoordinate() + 82 <= y && y <= aBoard[j].getEndYCoordinate() + 132) {
                    secondSelectedContinentTerritory = aBoard[j];
                    break outerloop;
                }
            }
        }
    }

    public void setupClick(int x, int y) {
        if (firstSelectedContinentTerritory == null) {
            chooseFirstContinentTerritory(x, y);
            if (firstSelectedContinentTerritory != null && riskEngine.getCurrentPlayer().isOwner(firstSelectedContinentTerritory)
                    && 0 < riskEngine.getCurrentPlayer().getAvailableArmies()) {
                int z = riskEngine.getCurrentPlayer().getAvailableArmies();
                riskEngine.getCurrentPlayer().setAvailableArmies(z-1);
                int k = riskEngine.getCurrentPlayer().getGarrisons().get(firstSelectedContinentTerritory);
                riskEngine.getCurrentPlayer().getGarrisons().put(firstSelectedContinentTerritory, k+1);
                textArea.append("\n" + "You added a army to " + firstSelectedContinentTerritory.getContinentTerritoryName());
            } else if (riskEngine.getCurrentPlayer().getAvailableArmies() == 0) {
                textArea.append("\n" + "You have no armies left to place, time for the next turn!");
            }
        }
        firstSelectedContinentTerritory = null;
        repaint();
    }


    public void attackClick(int x, int y) {
        if (firstSelectedContinentTerritory == null) {
            chooseFirstContinentTerritory(x, y);
            System.out.println("" + firstSelectedContinentTerritory);
            if (firstSelectedContinentTerritory != null && riskEngine.getCurrentPlayer().isOwner(firstSelectedContinentTerritory)) {
                textArea.append("\n" + "You selected " + firstSelectedContinentTerritory.getContinentTerritoryName());
            }
        } else if (secondSelectedContinentTerritory == null) {
            chooseSecondContinentTerritory(x, y);
            System.out.println("" + secondSelectedContinentTerritory);
            if (firstSelectedContinentTerritory.equals(secondSelectedContinentTerritory)) {
                textArea.append("\n" + "You can't attack the same territory");
                secondSelectedContinentTerritory = null;
                firstSelectedContinentTerritory = null;
                return;
            } else if (secondSelectedContinentTerritory != null && firstSelectedContinentTerritory.isNeighbour(
                    secondSelectedContinentTerritory.getContinentTerritoryName()) &&
                    !(riskEngine.getCurrentPlayer().isOwner(secondSelectedContinentTerritory)) &&
                    1 < riskEngine.getCurrentPlayer().getGarrisons().get(firstSelectedContinentTerritory)) {
                riskEngine.resolveAttack(firstSelectedContinentTerritory, secondSelectedContinentTerritory);
                textArea.append("\n" + "You attacked " + secondSelectedContinentTerritory.getContinentTerritoryName());
                firstSelectedContinentTerritory = null;
                secondSelectedContinentTerritory = null;
                return;
            } else {
                textArea.append("\n" + "You must attack a neighbouring territory which you don't control");
                secondSelectedContinentTerritory = null;
                return;
            }
        } else  {
            secondSelectedContinentTerritory = null;
        }
        repaint();
    }

    public void defenseClick(int x, int y) {
        if (firstSelectedContinentTerritory == null) {
            chooseFirstContinentTerritory(x, y);
        } else if (secondSelectedContinentTerritory == null) {
            chooseSecondContinentTerritory(x, y);
            if (firstSelectedContinentTerritory.equals(secondSelectedContinentTerritory)) {
                textArea.append("\n" + "You must select a different territory to move a army to");
                secondSelectedContinentTerritory = null;
            } else if (secondSelectedContinentTerritory != null && firstSelectedContinentTerritory.isNeighbour(
                       secondSelectedContinentTerritory.getContinentTerritoryName()) &&
                       riskEngine.getCurrentPlayer().isOwner(secondSelectedContinentTerritory) &&
                       1 < riskEngine.getCurrentPlayer().getGarrisons().get(firstSelectedContinentTerritory)) {
                textArea.append("\n" + "You moved a army from " + firstSelectedContinentTerritory.getContinentTerritoryName() + " to "
                                + secondSelectedContinentTerritory.getContinentTerritoryName());
                riskEngine.removeArmy(firstSelectedContinentTerritory);
                riskEngine.addArmy(secondSelectedContinentTerritory);
                firstSelectedContinentTerritory = null;
                secondSelectedContinentTerritory = null;
            } else {
                textArea.append("\n" + "You must select a neighbouring territory which you control");
                secondSelectedContinentTerritory = null;
            }
        }
        repaint();
    }

    @Override public void mouseClicked(final MouseEvent e) {
    }

    @Override public void mousePressed(final MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (riskEngine.getCurrentPhase().equals(Phase.SETUP)) {
            setupClick(x, y);
        } else if (riskEngine.getCurrentPhase().equals(Phase.ATTACK)) {
            attackClick(x, y);
        } else if (riskEngine.getCurrentPhase().equals(Phase.DEFENSE)) {
            defenseClick(x, y);
        } else if (riskEngine.getCurrentPhase().equals(Phase.START)) {
            setupClick(x, y);
        }
    }

    @Override public void mouseReleased(final MouseEvent e) {
    }

    @Override public void mouseEntered(final MouseEvent e) {
    }

    @Override public void mouseExited(final MouseEvent e) {
    }
}

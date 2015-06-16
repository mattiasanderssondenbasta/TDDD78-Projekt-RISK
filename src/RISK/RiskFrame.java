package RISK;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;

public class RiskFrame extends JFrame
{
    private Continent[] world;

    //private RiskComponent comp;

    public RiskFrame(Continent[] worldToBe) {
	super("RISK");
	Board.initBoard();
	this.world = worldToBe;
	this.setLayout(new BorderLayout());
	final RiskComponent comp = new RiskComponent(worldToBe);
	comp.setPreferredSize(comp.getPreferredSize());
	comp.setOpaque(true);

	final JButton nextPhaseButton = new JButton("Next turn");
	Action nextPhase = new AbstractAction() {
	    public void actionPerformed(ActionEvent e){
		nextPhaseOption(comp);
	    }
	};

		//JLabel phaseLabel = new JLabel("" + comp.getRiskEngine().getCurrentPhase());


	JPanel gamePanel = new JPanel();
	gamePanel.add(comp);

	JMenuBar buttonMenu = new JMenuBar();
	buttonMenu.add(nextPhaseButton);

	JTextArea textArea = comp.getTextArea();

	//textArea.setEditable(false);
	DefaultCaret caret = (DefaultCaret)textArea.getCaret();
	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

	JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	//scrollPane.setPreferredSize(new Dimension(250, 250));
		//scrollPane.setViewportView(textArea);
	/*for (Continent continent : world) {
	    for (ContinentTerritory continentTerritory : continent.getTerritorys()) {
		continentTerritory.addMouseListener(new TerritoryListener());
	    }
	}*/
	addMouseListener(comp);

		nextPhaseButton.addActionListener(nextPhase);

	this.setJMenuBar(buttonMenu);
	this.setContentPane(gamePanel);
	this.getContentPane().add(scrollPane);
	this.setResizable(false);
	this.pack();
	this.setVisible(true);

    }

	public void nextPhaseOption(RiskComponent comp) {
	    int currentPlayersArmies = comp.getRiskEngine().getCurrentPlayer().getAvailableArmies();
	    Object[] options = {"Yes", "No"};
	    int answer = JOptionPane.showOptionDialog(null, "Are you sure you want to go to the next turn?", "Warning",
						      JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						      null, options, options[0]);
	    if (answer == 0) {
		if (comp.getRiskEngine().getCurrentPhase().equals(Phase.SETUP)) {
		    if (currentPlayersArmies != 0) {
			comp.getTextArea().append("\n" + "You must place all of your available armies! (" + currentPlayersArmies + ")");
		    } else {
			comp.getRiskEngine().setCurrentPhase(Phase.ATTACK);
		    }
		} else if (comp.getRiskEngine().getCurrentPhase().equals(Phase.ATTACK)) {
		    comp.getRiskEngine().setCurrentPhase(Phase.DEFENSE);
		} else if (comp.getRiskEngine().getCurrentPhase().equals(Phase.START)) {
		    boolean startGame = true;
		    if (currentPlayersArmies != 0) {
			comp.getTextArea().append("\n" + "You must place all of your available armies! (" + currentPlayersArmies + ")");
		    } else {
			comp.getRiskEngine().nextPLayer();
		    }
		    for (Player player : comp.getRiskEngine().getLandOwners()) {
			if (player.getAvailableArmies() != 0) {
			    startGame = false;
			}
		    }
		    if (startGame) {
			comp.getRiskEngine().setCurrentPhase(Phase.SETUP);
			int ownedTerritorys = comp.getRiskEngine().getCurrentPlayer().getGarrisons().entrySet().size();
			if (ownedTerritorys < 13) {
			    comp.getRiskEngine().getCurrentPlayer().setAvailableArmies(4);
			} else if (13 <= ownedTerritorys && ownedTerritorys < 16) {
			    comp.getRiskEngine().getCurrentPlayer().setAvailableArmies(5);
			} else if (16 <= ownedTerritorys) {
			    comp.getRiskEngine().getCurrentPlayer().setAvailableArmies(6);
			}
		    }
		} else if (comp.getRiskEngine().getCurrentPhase().equals(Phase.DEFENSE)) {
		    comp.getRiskEngine().setCurrentPhase(Phase.SETUP);
		    comp.getRiskEngine().nextPLayer();
		    int ownedTerritorys = comp.getRiskEngine().getCurrentPlayer().getGarrisons().entrySet().size() - 1;
		    /*if (ownedTerritorys < 13) {
			comp.getRiskEngine().getCurrentPlayer().setAvailableArmies(4);
		    } else if (13 <= ownedTerritorys && ownedTerritorys < 16) {
			comp.getRiskEngine().getCurrentPlayer().setAvailableArmies(5);
		    } else if (16 <= ownedTerritorys) {
			comp.getRiskEngine().getCurrentPlayer().setAvailableArmies(6);
		    }*/
		}
		repaint();
	    }
	}





}

package RISK;

import java.awt.event.*;
// not used at the moment.
public class TerritoryListener implements MouseListener
{
    @Override public void mouseClicked(final MouseEvent e) {
	System.out.println("Hej 1");
    }

    @Override public void mousePressed(final MouseEvent e) {
	System.out.println("Hej 2");
    }

    @Override public void mouseReleased(final MouseEvent e) {
	System.out.println("Hej 3");
    }

    @Override public void mouseEntered(final MouseEvent e) {
	System.out.println("Hej 4");
    }

    @Override public void mouseExited(final MouseEvent e) {
	System.out.println("Hej 5");
    }
}

package codetest.hangman.entity;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

// class to draw gallows
public class BasicComponent extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
    public void paintComponent(final Graphics g) {
    	g.drawLine(0, 0, 200, 0);
    	g.drawLine(0, 0, 0, 300);
    	g.drawLine(0, 300, 200, 300);
    	g.drawLine(100, 0, 100, 40);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}

package codetest.hangman.entity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

// class to draw line and circle
public class ElementComponent extends JPanel {

	private static final long serialVersionUID = 1L;

	private int x1, y1, x2, y2;
	private String type;
	public ElementComponent(int x1, int y1, int x2, int y2, String type) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.type = type;
		this.setOpaque(false);
	}

	@Override
    public void paintComponent(final Graphics g) {
		switch(this.type) {
		case "line":
			g.drawLine(this.x1, this.y1, this.x2, this.y2);
			break;
		case "circle":
	        g.setColor(Color.white);
	        g.fillOval(this.x1, this.y1, this.x2, this.y2);
	        g.setColor(Color.BLACK);
	        g.drawOval(this.x1, this.y1, this.x2, this.y2);
	        break;
		}
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}

package codetest.hangman.service;

import javax.swing.JPanel;

import codetest.hangman.entity.GameStatus;
import codetest.hangman.entity.LayoutComponent;

public class LayoutService {

	private LayoutComponent layoutComponent;

	// draw initial UI components
	public void drawLayoutComponent(JPanel gamePanel, GameStatus gameStatus) {
		layoutComponent = new LayoutComponent();

		layoutComponent.setTextField();
		layoutComponent.setMessageLabel("");
		layoutComponent.setGuessLabel(gameStatus.getCurrentGuess().replace("", " ").trim());
		layoutComponent.setInstructionLabel();
		layoutComponent.setBasicComponent();
		layoutComponent.setRestartButton();

	    	gamePanel.add(layoutComponent.getTextField());
	    	gamePanel.add(layoutComponent.getGuessLabel());
	    	gamePanel.add(layoutComponent.getMessageLabel());
	    	gamePanel.add(layoutComponent.getInstructionLabel());
    		gamePanel.add(layoutComponent.getBasicComponent());
    		gamePanel.add(layoutComponent.getRestartButton());
    		gamePanel.repaint();
	}

	public LayoutComponent getLayoutComponent() {
		return this.layoutComponent;
	}
}

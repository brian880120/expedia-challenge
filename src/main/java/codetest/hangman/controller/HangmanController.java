package codetest.hangman.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import codetest.hangman.entity.GameStatus;
import codetest.hangman.entity.LayoutComponent;
import codetest.hangman.service.HangmanService;
import codetest.hangman.service.LayoutService;
import codetest.hangman.service.RandomWordService;
import codetest.hangman.service.WordGuessService;

public class HangmanController {

	private GameStatus gameStatus;
	private JPanel gamePanel;
	private LayoutComponent layoutComponent;

    // initialize game status with secret word, empty guess field, step count etc ...
	public void initializeGameStatus() {
    	RandomWordService randomWordService = new RandomWordService();
    	WordGuessService wordGuessService = new WordGuessService();
    	String secretWord = randomWordService.getWord();
    	String initGuess = wordGuessService.initGuessField(secretWord.length());
    	gameStatus = new GameStatus(secretWord, initGuess);
	}

	// initialize game layout with initial UI components and listeners
	public void initializeLayout() {
		JFrame mainFrame = new JFrame("Hangman Game");
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setOpaque(false);
		mainFrame.add(gamePanel, BorderLayout.CENTER);
		mainFrame.setSize(800, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.setVisible(true);
		LayoutService layoutService = new LayoutService();
		// draw initial UI components
		layoutService.drawLayoutComponent(gamePanel, gameStatus);
		layoutComponent = layoutService.getLayoutComponent();
		// register text field and restart button listeners
		layoutComponent.getTextField().addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		HangmanService hangmanService = new HangmanService();
	    		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
	    	}
	    });
		layoutComponent.getRestartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		    	mainFrame.dispose();
		    	initializeGameStatus();
		    	initializeLayout();
			}
		});
	}

	public GameStatus getGameStatus() {
		return this.gameStatus;
	}

	public JPanel getGamePanel() {
		return this.gamePanel;
	}

	public LayoutComponent getLayoutComponent() {
		return this.layoutComponent;
	}
}

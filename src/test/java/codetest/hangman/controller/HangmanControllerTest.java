package codetest.hangman.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codetest.hangman.entity.GameStatus;
import codetest.hangman.entity.LayoutComponent;

public class HangmanControllerTest {

	private HangmanController hangmanController;
	private GameStatus gameStatus;
	private JPanel gamePanel;
	private LayoutComponent layoutComponent;

	@Before
	public void initialize() {
		hangmanController = new HangmanController();
	}

	@After
	public void reset() {
		hangmanController = null;
	}

	@Test
	public void shouldInitializeGameStatus() {
		hangmanController.initializeGameStatus();
		gameStatus = hangmanController.getGameStatus();
		String secretWord = gameStatus.getSecretWord(); 
		assertNotNull(secretWord);
		assertEquals(1, gameStatus.getStepCount());
		assertEquals(gameStatus.getCurrentGuess().length(), gameStatus.getSecretWord().length());
	}

	@Test
	public void shouldInitializeLayout() {
		hangmanController.initializeGameStatus();
		hangmanController.initializeLayout();
		layoutComponent = hangmanController.getLayoutComponent();
		gamePanel = hangmanController.getGamePanel();
		assertNotNull(layoutComponent.getBasicComponent());
		assertNotNull(layoutComponent.getGuessLabel());
		assertNotNull(layoutComponent.getMessageLabel());
		assertNotNull(layoutComponent.getRestartButton());
		assertNotNull(layoutComponent.getTextField());
		assertNotNull(layoutComponent.getInstructionLabel());
		assertEquals(6, gamePanel.getComponentCount());
	}
}

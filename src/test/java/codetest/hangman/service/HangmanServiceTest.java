package codetest.hangman.service;

import static org.junit.Assert.assertEquals;

import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codetest.hangman.entity.GameStatus;
import codetest.hangman.entity.LayoutComponent;

public class HangmanServiceTest {

	private HangmanService hangmanService;
	private LayoutComponent layoutComponent;
	private JPanel gamePanel;
	private GameStatus gameStatus;

	@Before
	public void initialize() {
		hangmanService = new HangmanService();
		gamePanel = new JPanel();
		layoutComponent = new LayoutComponent();
		layoutComponent.setBasicComponent();
		layoutComponent.setGuessLabel("");
		layoutComponent.setMessageLabel("");;
		layoutComponent.setTextField();
		gamePanel.add(layoutComponent.getBasicComponent());
		gamePanel.add(layoutComponent.getGuessLabel());
		gamePanel.add(layoutComponent.getTextField());
		gamePanel.add(layoutComponent.getMessageLabel());
	}

	@After
	public void reset() {
		hangmanService = null;
		layoutComponent = null;
		gamePanel = null;
		gameStatus = null;
	}

	@Test
	public void shouldUpdateGuessFieldWithCorrectGuess() {
		gameStatus = new GameStatus("testguess", "____g____");
		layoutComponent.getTextField().setText("t");
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess());
		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
		assertEquals(gameStatus.getCurrentGuess(), "t__tg____");
	}

	@Test
	public void shouldNotUpdateGuessFieldWithIncorrectGuess() {
		gameStatus = new GameStatus("testguess", "____g____");
		layoutComponent.getTextField().setText("a");
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess());
		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
		assertEquals(gameStatus.getCurrentGuess(), "____g____");
	}

	@Test
	public void shouldNotUpdateHangmanWithCorrectGuess() {
		gameStatus = new GameStatus("test", "____");
		layoutComponent.getTextField().setText("t");
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess());
		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
		assertEquals(4, gamePanel.getComponentCount());
	}

	@Test
	public void shouldUpdateHangmanWithIncorrectGuess() {
		gameStatus = new GameStatus("test", "____");
		layoutComponent.getTextField().setText("a");
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess());
		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
		assertEquals(5, gamePanel.getComponentCount());
	}

	@Test
	public void shouldShowSucessMessage() {
		gameStatus = new GameStatus("abc", "__");
		layoutComponent.getTextField().setText("abc");
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess());
		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
		assertEquals("You win ! Press restart to continue", layoutComponent.getMessageLabel().getText());
	}

	@Test
	public void shouldShowFailMessage() {
		gameStatus = new GameStatus("abc", "___");
		for (int i=1; i<10; i++) {
			hangmanService.updateHangman(gamePanel, i);
			gameStatus.increaseStepCount();
		}
		layoutComponent.getTextField().setText("d");
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess());
		hangmanService.updateGameStatus(layoutComponent, gamePanel, gameStatus);
		assertEquals("You lost. The correct word is abc! Press restart to continue", layoutComponent.getMessageLabel().getText());
	}

	@Test
	public void shouldUpdateHangmanWithStepCount() {
		hangmanService.updateHangman(gamePanel, 1);
		hangmanService.updateHangman(gamePanel, 2);
		hangmanService.updateHangman(gamePanel, 3);
		hangmanService.updateHangman(gamePanel, 4);
		hangmanService.updateHangman(gamePanel, 5);
		hangmanService.updateHangman(gamePanel, 6);
		hangmanService.updateHangman(gamePanel, 7);
		hangmanService.updateHangman(gamePanel, 8);
		hangmanService.updateHangman(gamePanel, 9);
		hangmanService.updateHangman(gamePanel, 10);
		assertEquals(110, gamePanel.getComponents()[0].getX());
		assertEquals(75, gamePanel.getComponents()[1].getX());
		assertEquals(110, gamePanel.getComponents()[2].getX());
		assertEquals(75, gamePanel.getComponents()[3].getX());
		assertEquals(90, gamePanel.getComponents()[4].getX());
		assertEquals(107, gamePanel.getComponents()[5].getX());
		assertEquals(107, gamePanel.getComponents()[6].getX());
		assertEquals(113, gamePanel.getComponents()[7].getX());
		assertEquals(97, gamePanel.getComponents()[8].getX());
		assertEquals(85, gamePanel.getComponents()[9].getX());
	}
}

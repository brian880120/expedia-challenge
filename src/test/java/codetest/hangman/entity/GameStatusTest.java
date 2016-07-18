package codetest.hangman.entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameStatusTest {
	private GameStatus gameStatus;

	@Before
	public void initialize() {
		gameStatus = new GameStatus("testWord", "________");
	}

	@After
	public void reset() {
		gameStatus = null;
	}

	@Test
	public void shouldConstructGameStatus() {
		assertEquals(gameStatus.getStepCount(), 1);
		assertEquals(gameStatus.getSecretWord(), "testWord");
		assertEquals(gameStatus.getCurrentGuess(), "________");
		assertEquals(gameStatus.getGuessedLetters().size(), 0);
	}

	@Test
	public void shouldSetGuessedLetters() {
		gameStatus.getGuessedLetters().put('a', 0);
		assertEquals(gameStatus.getGuessedLetters().size(), 1);
		gameStatus.getGuessedLetters().put('a', gameStatus.getGuessedLetters().get('a') + 1);
		int count = gameStatus.getGuessedLetters().get('a');
		assertEquals(count, 1);
	}

	@Test
	public void shouldIncreaseStepCount() {
		gameStatus.increaseStepCount();
		assertEquals(gameStatus.getStepCount(), 2);
	}
}

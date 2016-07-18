package codetest.hangman.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import codetest.hangman.entity.GameStatus;

public class WordGuessServiceTest {

	private WordGuessService wordGuessService;

	@Before
	public void initialize() {
		wordGuessService = new WordGuessService();
	}

	@Test
	public void shouldInitGuessField() {
		String initGuess = wordGuessService.initGuessField(4);
		assertEquals("____", initGuess);
	}

	@Test
	public void correctGuessLetter() {
		GameStatus gameStatus = new GameStatus("abcd", "____");
		gameStatus.setGuessString("a");
		wordGuessService.updateGuessField(gameStatus);
		assertEquals("a___", gameStatus.getCurrentGuess());
	}

	@Test
	public void incorrectGuessLetter() {
		GameStatus gameStatus = new GameStatus("abcd", "____");
		gameStatus.setGuessString("e");
		wordGuessService.updateGuessField(gameStatus);
		assertEquals("____", gameStatus.getCurrentGuess());
	}

	@Test
	public void correctGuessString() {
		GameStatus gameStatus = new GameStatus("abcd", "____");
		gameStatus.setGuessString("abcd");
		wordGuessService.updateGuessField(gameStatus);
		assertEquals("abcd", gameStatus.getCurrentGuess());
	}

	@Test
	public void incorrectGuessString() {
		GameStatus gameStatus = new GameStatus("abcd", "____");
		gameStatus.setGuessString("abc");
		wordGuessService.updateGuessField(gameStatus);
		assertEquals("____", gameStatus.getCurrentGuess());
	}

	@Test
	public void duplicateEnterFirstTime() {
		GameStatus gameStatus = new GameStatus("abcd", "____");
		for (int i=0; i<2; i++) {
			gameStatus.setGuessString("a");
			wordGuessService.updateGuessField(gameStatus);	
		}
		assertEquals(false, gameStatus.isContinueOnDuplicate());
		assertEquals(true, gameStatus.isShowDuplicateWarning());
	}

	@Test
	public void duplicateEnterSecondTime() {
		GameStatus gameStatus = new GameStatus("abcd", "____");
		for (int i=0; i<3; i++) {
			gameStatus.setGuessString("a");
			wordGuessService.updateGuessField(gameStatus);	
		}
		assertEquals(true, gameStatus.isContinueOnDuplicate());
		assertEquals(false, gameStatus.isShowDuplicateWarning());
	}
}

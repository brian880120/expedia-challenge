package codetest.hangman.service;

import java.util.Arrays;

import codetest.hangman.entity.GameStatus;

public class WordGuessService {

	// initialize string of underscore with length of secret word
	public String initGuessField(int count) {
		char[] guessField = new char[count];
		Arrays.fill(guessField, '_');
		return new String(guessField);
	}

	// update guess field whenever user enter new guess letter or word
	public void updateGuessField(GameStatus gameStatus) {
		String guessString = gameStatus.getGuessString();
		// case when user enter a letter
		if (guessString.length() == 1) {
			char guess = guessString.charAt(0);
			guessLetter(guess, gameStatus);
		} else {
			// case when user enter a word
			guessWord(guessString, gameStatus);
		}
	}

	// if user enter correct guess letter, replace underscore with guess letter
	// update current guess field
	public void guessLetter(char guess, GameStatus gameStatus) {
		checkDuplicateGuess(guess, gameStatus);
		char[] currentGuessArray = gameStatus.getCurrentGuess().toCharArray();
		for (int i=0; i<gameStatus.getSecretWord().length(); i++) {
			if (currentGuessArray[i] != '_') {
				continue;
			}
			if (guess == gameStatus.getSecretWord().charAt(i)) {
				currentGuessArray[i] = guess;
			}
		}
		gameStatus.setCurrentGuess(new String(currentGuessArray));
	}

	// if user enter correct secret word, update current guess field
	public void guessWord(String guess, GameStatus gameStatus) {
		gameStatus.setContinueOnDuplicate(true);
		if (guess.equalsIgnoreCase(gameStatus.getSecretWord())) {
			gameStatus.setCurrentGuess(gameStatus.getSecretWord());
		}
	}

	// check if user enter a letter which is already entered before 
	public void checkDuplicateGuess(char guess, GameStatus gameStatus) {
		gameStatus.setContinueOnDuplicate(false);
		gameStatus.setShowDuplicateWarning(false);
		if (!gameStatus.getGuessedLetters().containsKey(guess)) {
			gameStatus.getGuessedLetters().put(guess, 0);
		} else {
			gameStatus.getGuessedLetters().put(guess, gameStatus.getGuessedLetters().get(guess) + 1);
		}
		// case when user enter duplicate letter more then one time
		if (gameStatus.getGuessedLetters().get(guess) != 1) {
			gameStatus.setContinueOnDuplicate(true);
		} else {
			// case when user enter duplicate letter first time
			gameStatus.setShowDuplicateWarning(true);
		}
	}
}

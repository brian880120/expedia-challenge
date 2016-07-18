package codetest.hangman.entity;

import java.util.HashMap;

// class to hold game status properties
public class GameStatus {

	private String secretWord;
	private String currentGuess;
	private int stepCount;
	private String guessString;
	private boolean sucess;
	private boolean fail;
	private boolean showDuplicateWarning;
	private boolean continueOnDuplicate;
	private HashMap<Character, Integer> guessedLetters;

	public GameStatus(String secretWord, String currentGuess) {
		this.secretWord = secretWord;
		this.currentGuess = currentGuess;
		this.stepCount = 1;
		this.guessedLetters = new HashMap<Character, Integer>();
	}

	public String getSecretWord() {
		return secretWord;
	}
	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}
	public String getCurrentGuess() {
		return currentGuess;
	}
	public void setCurrentGuess(String currentGuess) {
		this.currentGuess = currentGuess;
	}
	public int getStepCount() {
		return stepCount;
	}
	public void increaseStepCount() {
		this.stepCount++;
	}
	public String getGuessString() {
		return guessString;
	}
	public void setGuessString(String guessString) {
		this.guessString = guessString;
	}

	public HashMap<Character, Integer> getGuessedLetters() {
		return guessedLetters;
	}

	public void setGuessedLetters(HashMap<Character, Integer> guessedLetters) {
		this.guessedLetters = guessedLetters;
	}

	public boolean isShowDuplicateWarning() {
		return showDuplicateWarning;
	}

	public void setShowDuplicateWarning(boolean showDuplicateWarning) {
		this.showDuplicateWarning = showDuplicateWarning;
	}

	public boolean isContinueOnDuplicate() {
		return continueOnDuplicate;
	}

	public void setContinueOnDuplicate(boolean continueOnDuplicate) {
		this.continueOnDuplicate = continueOnDuplicate;
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public boolean isFail() {
		return fail;
	}

	public void setFail(boolean fail) {
		this.fail = fail;
	}
}

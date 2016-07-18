package codetest.hangman.service;

import javax.swing.JPanel;

import codetest.hangman.entity.ElementComponent;
import codetest.hangman.entity.GameStatus;
import codetest.hangman.entity.HangmanComponent;
import codetest.hangman.entity.LayoutComponent;

public class HangmanService {

	// update game status whenever user enter letter or word
	public void updateGameStatus(LayoutComponent layoutComponent, JPanel gamePanel, GameStatus gameStatus) {
		// exit function if game is done
		if (gameStatus.isFail() || gameStatus.isSucess()) {
			return;
		}
		String oldGuess = layoutComponent.getGuessLabel().getText().replace(" ", "");
		// update guess field
		updateGuessField(layoutComponent, gameStatus);

		// update hangman body based on guess field string comparison before and after guess field update
		if (oldGuess.equalsIgnoreCase(gameStatus.getCurrentGuess()) && gameStatus.isContinueOnDuplicate()) {
			updateHangman(gamePanel, gameStatus.getStepCount());
			gameStatus.increaseStepCount();
		}

		// display warning if user enter duplicate letter first time
		if (gameStatus.isShowDuplicateWarning()) {
			layoutComponent.getMessageLabel().setText("Warning! You enter a letter already guessed.");
		}

		// display success message if user complete secret word before hangman is completed
		if (gameStatus.getCurrentGuess().equalsIgnoreCase(gameStatus.getSecretWord()) && gameStatus.getStepCount() < 10) {
			gameStatus.setSucess(true);
			layoutComponent.getMessageLabel().setText("You win ! Press restart to continue");
		}

		// display fail message if hangman is completed before user finish secret word
		if (gameStatus.getStepCount() > 10) {
			gameStatus.setFail(true);
			layoutComponent.getMessageLabel().setText("You lost. The correct word is " + gameStatus.getSecretWord() + "! Press restart to continue");
		}
		layoutComponent.getTextField().setText("");
	}

	// update hangman body according to step count
	public void updateHangman(JPanel panel, int step) {
		HangmanComponent hangmanComponent = new HangmanComponent();
		switch (step) {
		case 1:
			hangmanComponent.setHead();
			drawPart(panel, hangmanComponent.getHead());
			break;
		case 2:
			hangmanComponent.setLeftEye();
			drawPart(panel, hangmanComponent.getLeftEye());
			break;
		case 3:
			hangmanComponent.setRightEye();
			drawPart(panel, hangmanComponent.getRightEye());
			break;
		case 4:
			hangmanComponent.setNose();;
			drawPart(panel, hangmanComponent.getNose());
			break;
		case 5:
			hangmanComponent.setMouth();
			drawPart(panel, hangmanComponent.getMouth());
			break;
		case 6:
			hangmanComponent.setBody();
			drawPart(panel, hangmanComponent.getBody());
			break;
		case 7:
			hangmanComponent.setLeftArm();
			drawPart(panel, hangmanComponent.getLeftArm());
			break;
		case 8:
			hangmanComponent.setRightArm();
			drawPart(panel, hangmanComponent.getRightArm());
			break;
		case 9:
			hangmanComponent.setLeftLeg();
			drawPart(panel, hangmanComponent.getLeftLeg());
			break;
		case 10:
			hangmanComponent.setRightLeg();
			drawPart(panel, hangmanComponent.getRightLeg());
		}
	}

	private void drawPart(JPanel panel, ElementComponent elem) {
		panel.add(elem);
		panel.setComponentZOrder(elem, 0);
		panel.repaint();
	}

	private void updateGuessField(LayoutComponent layoutComponent, GameStatus gameStatus) {
		WordGuessService wordGuessService = new WordGuessService();
		layoutComponent.getMessageLabel().setText("");
		String oldGuess = layoutComponent.getGuessLabel().getText().replace(" ", "");
		gameStatus.setCurrentGuess(oldGuess);
		gameStatus.setGuessString(layoutComponent.getTextField().getText());
		wordGuessService.updateGuessField(gameStatus);
		layoutComponent.getGuessLabel().setText(gameStatus.getCurrentGuess().replace("",  " ").trim());
	}
}

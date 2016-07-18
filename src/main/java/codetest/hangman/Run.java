package codetest.hangman;

import codetest.hangman.controller.HangmanController;

public class Run {
    public static void main(String[] args) {
    	HangmanController gameController = new HangmanController();
    	gameController.initializeGameStatus();
    	gameController.initializeLayout();
    }
}

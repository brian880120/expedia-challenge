package codetest.hangman.service;

import java.util.Random;

import codetest.hangman.entity.Data;

public class RandomWordService {

	private String[] words;
	private Random rand = new Random();

	public RandomWordService() {
		this.words = Data.getWords();
	}

	public String getWord() {
		if (this.words.length == 0) {
			this.words = Data.getWords();
		}
		int randNum = rand.nextInt(this.words.length);
		return this.words[randNum];
	}
}

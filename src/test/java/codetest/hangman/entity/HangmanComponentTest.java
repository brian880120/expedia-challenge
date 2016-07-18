package codetest.hangman.entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HangmanComponentTest {

	private HangmanComponent hangmanComponent;

	@Before
	public void initialize() {
		hangmanComponent = new HangmanComponent();
	}

	@After
	public void reset() {
		hangmanComponent = null;
	}

	@Test
	public void shouldGetHangmanHead() {
		hangmanComponent.setHead();
		assertEquals(85, hangmanComponent.getHead().getX());
		assertEquals(50, hangmanComponent.getHead().getY());
	}

	@Test
	public void shouldGetHangmanLeftEye() {
		hangmanComponent.setLeftEye();
		assertEquals(97, hangmanComponent.getLeftEye().getX());
		assertEquals(62, hangmanComponent.getLeftEye().getY());
	}

	@Test
	public void shouldGetHangmanRightEye() {
		hangmanComponent.setRightEye();
		assertEquals(113, hangmanComponent.getRightEye().getX());
		assertEquals(62, hangmanComponent.getRightEye().getY());
	}

	@Test
	public void shouldGetHangmanNose() {
		hangmanComponent.setNose();
		assertEquals(107, hangmanComponent.getNose().getX());
		assertEquals(75, hangmanComponent.getNose().getY());
	}

	@Test
	public void shouldGetHangmanBody() {
		hangmanComponent.setBody();
		assertEquals(90, hangmanComponent.getBody().getX());
		assertEquals(90, hangmanComponent.getBody().getY());
	}

	@Test
	public void shouldGetHangmanLeftArm() {
		hangmanComponent.setLeftArm();
		assertEquals(75, hangmanComponent.getLeftArm().getX());
		assertEquals(90, hangmanComponent.getLeftArm().getY());
	}

	@Test
	public void shouldGetHangmanLeftLeg() {
		hangmanComponent.setLeftLeg();
		assertEquals(75, hangmanComponent.getLeftLeg().getX());
		assertEquals(150, hangmanComponent.getLeftLeg().getY());
	}
}

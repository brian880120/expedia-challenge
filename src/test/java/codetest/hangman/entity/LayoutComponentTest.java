package codetest.hangman.entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LayoutComponentTest {

	private LayoutComponent layoutComponent;

	@Before
	public void initialize() {
		layoutComponent = new LayoutComponent();
	}

	@After
	public void reset() {
		layoutComponent = null;
	}

	@Test
	public void shouldSetTextField() {
		layoutComponent.setTextField();
		assertEquals(295, layoutComponent.getTextField().getX());
		assertEquals(150, layoutComponent.getTextField().getY());
		assertEquals(200, layoutComponent.getTextField().getSize().width);
		assertEquals(25, layoutComponent.getTextField().getSize().height);
	}

	@Test
	public void shouldSetGuessLabel() {
		layoutComponent.setGuessLabel("guessField");
		assertEquals(300, layoutComponent.getGuessLabel().getX());
		assertEquals(50, layoutComponent.getGuessLabel().getY());
		assertEquals(300, layoutComponent.getGuessLabel().getSize().width);
		assertEquals(100, layoutComponent.getGuessLabel().getSize().height);
	}

	@Test
	public void shouldSetMessageLabel() {
		layoutComponent.setMessageLabel("messageLabel");
		assertEquals(100, layoutComponent.getMessageLabel().getX());
		assertEquals(300, layoutComponent.getMessageLabel().getY());
		assertEquals(600, layoutComponent.getMessageLabel().getSize().width);
		assertEquals(100, layoutComponent.getMessageLabel().getSize().height);
	}

	@Test
	public void shouldSetBasicComponent() {
		layoutComponent.setBasicComponent();
		assertEquals(10, layoutComponent.getBasicComponent().getX());
		assertEquals(10, layoutComponent.getBasicComponent().getY());
		assertEquals(400, layoutComponent.getBasicComponent().getSize().width);
		assertEquals(400, layoutComponent.getBasicComponent().getSize().height);	
	}

	@Test
	public void shouldRestartButton() {
		layoutComponent.setRestartButton();
		assertEquals(300, layoutComponent.getRestartButton().getX());
		assertEquals(250, layoutComponent.getRestartButton().getY());
		assertEquals(50, layoutComponent.getRestartButton().getSize().width);
		assertEquals(20, layoutComponent.getRestartButton().getSize().height);
	}
}

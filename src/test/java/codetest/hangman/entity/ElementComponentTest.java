package codetest.hangman.entity;

import static org.junit.Assert.assertEquals;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElementComponentTest {

	private JFrame testFrame;

	@Before
	public void initialize() {
		testFrame = new JFrame();
		testFrame.setVisible(true);
	}

	@After
	public void reset() {
		testFrame.dispose();
		testFrame = null;
	}

	@Test
	public void shouldDrawCircleElement() {
		ElementComponent circle = new ElementComponent(0, 0, 50, 50, "circle");
		circle.setLocation(10, 10);
		circle.setSize(circle.getPreferredSize());
		assertEquals(10, circle.getX());
		assertEquals(10, circle.getY());
		testFrame.getContentPane().add(circle);
		assertEquals(testFrame.getComponentCount(), 1);
	}

	@Test
	public void shouldDrawLineElement() {
		ElementComponent line = new ElementComponent(0, 5, 5, 5, "line");
		line.setLocation(10, 10);
		line.setSize(line.getPreferredSize());
		assertEquals(10, line.getX());
		assertEquals(10, line.getY());
		testFrame.getContentPane().add(line);
		assertEquals(testFrame.getComponentCount(), 1);
	}
}

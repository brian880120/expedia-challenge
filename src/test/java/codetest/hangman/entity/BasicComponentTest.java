package codetest.hangman.entity;

import static org.junit.Assert.assertEquals;

import javax.swing.JFrame;

import org.junit.Test;


public class BasicComponentTest {
	private JFrame testFrame;

	@Test
	public void shouldRegisterBasicComponent() {
		testFrame = new JFrame("Test Frame");
		BasicComponent basicComponent = new BasicComponent();
		basicComponent.setLocation(10, 10);
		basicComponent.setSize(basicComponent.getPreferredSize());
		testFrame.add(basicComponent);
		int componentsSize = testFrame.getComponentCount();
		assertEquals(componentsSize, 1);
	}
}

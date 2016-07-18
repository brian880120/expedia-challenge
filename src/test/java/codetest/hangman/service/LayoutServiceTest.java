package codetest.hangman.service;

import static org.junit.Assert.assertEquals;

import javax.swing.JPanel;

import org.junit.Test;

import codetest.hangman.entity.GameStatus;

public class LayoutServiceTest {

	@Test
	public void shouldDrawGameInitComponent() {
		JPanel gamePanel = new JPanel();
		GameStatus gameStatus = new GameStatus("test", "____");
		LayoutService layoutService = new LayoutService();
		layoutService.drawLayoutComponent(gamePanel, gameStatus);
		assertEquals(6, gamePanel.getComponentCount());
	}
}

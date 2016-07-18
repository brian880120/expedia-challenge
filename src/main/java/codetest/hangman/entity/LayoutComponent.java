package codetest.hangman.entity;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

// class to hold initial UI components
public class LayoutComponent {
	private JTextField textField;
	private JLabel guessLabel;
	private JLabel messageLabel;
	private BasicComponent basicComponent;
	private JButton restartButton;

	public JTextField getTextField() {
		return this.textField;
	}

	public void setTextField() {
	    textField = new JTextField(20);
	    textField.setLocation(295, 150);
	    textField.setSize(200, 25);
	}

	public JLabel getGuessLabel() {
		return this.guessLabel;
	}

	public void setGuessLabel(String name) {
	    guessLabel = new JLabel(name);
	    guessLabel.setLocation(300, 50);
	    guessLabel.setFont(new Font("", Font.PLAIN, 20));
	    guessLabel.setSize(300, 100);
	}

	public JLabel getMessageLabel() {
		return this.messageLabel;
	}

	public void setMessageLabel(String name) {
	    messageLabel = new JLabel(name);
	    messageLabel.setLocation(100, 300);
	    messageLabel.setForeground(Color.RED);
	    messageLabel.setFont(new Font("", Font.PLAIN, 20));
	    messageLabel.setSize(600, 100);
	}

	public BasicComponent getBasicComponent() {
		return this.basicComponent;
	}

	public void setBasicComponent() {
		basicComponent = new BasicComponent();
		basicComponent.setLocation(10, 10);
		basicComponent.setSize(basicComponent.getPreferredSize());
	}

	public JButton getRestartButton() {
		return restartButton;
	}

	public void setRestartButton() {
		restartButton = new JButton("restart");
		restartButton.setLocation(300, 250);
		restartButton.setSize(50, 20);
	}
	
}

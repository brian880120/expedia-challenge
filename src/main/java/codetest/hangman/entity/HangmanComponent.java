package codetest.hangman.entity;

// class to hold hangman body properties
public class HangmanComponent {

	private ElementComponent head;
	private ElementComponent leftEye;
	private ElementComponent rightEye;
	private ElementComponent nose;
	private ElementComponent mouth;
	private ElementComponent body;
	private ElementComponent leftArm;
	private ElementComponent rightArm;
	private ElementComponent leftLeg;
	private ElementComponent rightLeg;

	public ElementComponent getHead() {
		return head;
	}
	public void setHead() {
		head = new ElementComponent(0, 0, 50, 50, "circle");
		head.setLocation(85, 50);
		head.setSize(head.getPreferredSize());
	}
	public ElementComponent getLeftEye() {
		return leftEye;
	}
	public void setLeftEye() {
		leftEye = new ElementComponent(0, 0, 10, 10, "circle");
		leftEye.setLocation(97, 62);
		leftEye.setSize(leftEye.getPreferredSize());
	}
	public ElementComponent getRightEye() {
		return rightEye;
	}
	public void setRightEye() {
		rightEye = new ElementComponent(0, 0, 10, 10, "circle");
		rightEye.setLocation(113, 62);
		rightEye.setSize(rightEye.getPreferredSize());
	}
	public ElementComponent getNose() {
		return nose;
	}
	public void setNose() {
		nose = new ElementComponent(0, 0, 5, 5, "circle");
		nose.setLocation(107,75);
		nose.setSize(nose.getPreferredSize());
	}
	public ElementComponent getMouth() {
		return mouth;
	}
	public void setMouth() {
		mouth = new ElementComponent(0, 5, 5, 5, "line");
		mouth.setLocation(107,83);
		mouth.setSize(mouth.getPreferredSize());
	}
	public ElementComponent getBody() {
		return body;
	}
	public void setBody() {
		body = new ElementComponent(20, 10, 20, 60, "line");
		body.setLocation(90, 90);
		body.setSize(body.getPreferredSize());
	}
	public ElementComponent getLeftArm() {
		return leftArm;
	}
	public void setLeftArm() {
		leftArm = new ElementComponent(0, 0, 35, 35, "line");
		leftArm.setLocation(75, 90);
		leftArm.setSize(leftArm.getPreferredSize());
	}
	public ElementComponent getRightArm() {
		return rightArm;
	}
	public void setRightArm() {
		rightArm = new ElementComponent(0, 35, 35, 0, "line");
		rightArm.setLocation(110, 90);
		rightArm.setSize(rightArm.getPreferredSize());
	}
	public ElementComponent getLeftLeg() {
		return leftLeg;
	}
	public void setLeftLeg() {
		leftLeg = new ElementComponent(0, 35, 35, 0, "line");
		leftLeg.setLocation(75, 150);
		leftLeg.setSize(leftLeg.getPreferredSize());
	}
	public ElementComponent getRightLeg() {
		return rightLeg;
	}
	public void setRightLeg() {
		rightLeg = new ElementComponent(0, 0, 35, 35, "line");
		rightLeg.setLocation(110,150);
		rightLeg.setSize(rightLeg.getPreferredSize());
	}
}

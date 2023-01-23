package com.example;

import javax.swing.JFrame;

class FrameWindow extends JFrame {
	
	public FrameWindow(String title) {
		super(title);
		setSize(640, 480);
	}
}

public class SwingTest {

	public static void main(String[] args) {
		FrameWindow fm = new FrameWindow("Hello");
		fm.setVisible(true);

	}

}

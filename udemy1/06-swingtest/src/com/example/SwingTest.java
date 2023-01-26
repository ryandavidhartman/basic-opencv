package com.example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class FrameWindow extends JFrame {
	
	JLabel labelMessage;
	JTextField textField;
	JButton button;
	JPanel p1,p2,p3;
	
	public FrameWindow(String title) {
		super(title);
		setSize(320, 240);
		setLayout(new GridLayout(3, 1, 5, 5));
		
		labelMessage = new JLabel("Hello World");
		textField = new JTextField(20);
		button = new JButton("Click me");
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		p1.add(labelMessage);
		p2.add(textField);
		p3.add(button);
		
		add(p1);
		add(p2);
		add(p3);
		
		button.addActionListener(new ButtonHandler());
	}
	
	class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) {
				JOptionPane.showMessageDialog(null,"Hello " + textField.getText());
				labelMessage.setText("Hello " + textField.getText());
			}
			
		}
		
	}
}

public class SwingTest {

	public static void main(String[] args) {
		FrameWindow fm = new FrameWindow("Hello");
		fm.setVisible(true);

	}

}

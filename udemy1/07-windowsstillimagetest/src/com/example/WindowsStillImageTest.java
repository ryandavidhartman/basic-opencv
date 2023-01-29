package com.example;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;

class FrameWindow extends JFrame{
	
	JLabel labelImage;
	
	private BufferedImage Mat2BufferedImage(Mat matrix) {
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if(matrix.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		
		int bufferSize = matrix.channels()* matrix.rows() * matrix.cols();
		byte[] buffer = new byte[bufferSize];
		matrix.get(0,0,buffer);  // get all the pixels
		BufferedImage image = new BufferedImage(matrix.cols(),  matrix.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
		
		return image;
	}
		
	
	public FrameWindow(String title) {
		super(title);
		labelImage = new JLabel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(labelImage);
		setVisible(true);
	}
	
	public void setImage(Mat matImage) {
		Image image = Mat2BufferedImage(matImage);
	}
}

public class WindowsStillImageTest {

	public static void main(String[] args) {
		FrameWindow frameWindow = new FrameWindow("Still Image");
	}

}

package com.example;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class ProcessingImage extends PApplet  {
	
	private static final String FILE_PATH = "resources/cat.jpg";
	PImage pimg;
	
	
	public void settings() {
		Mat img = Imgcodecs.imread(FILE_PATH);
		pimg = MatToPImage(img);
		size(800, 600);
	}
	
	public void draw() {
		image(pimg,0,0,800,600);
	}

	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		PApplet.main(ProcessingImage.class.getName());
	}
	
	private static PImage MatToPImage(Mat mat) {
		if (mat != null && !mat.empty()) {
			MatOfByte matOfByte = new MatOfByte();
			Imgcodecs.imencode(".jpg", mat, matOfByte); // for OpenCV 4.5.1
			byte[] byteArray = matOfByte.toArray();
			try {
				InputStream in = new ByteArrayInputStream(byteArray);
				BufferedImage bimg = ImageIO.read(in);
				PImage img = new PImage(bimg.getWidth(), bimg.getHeight(), PConstants.ARGB);
				bimg.getRGB(0, 0, img.width, img.height, img.pixels, 0, img.width);
				img.updatePixels();
				bimg = null;
				return img;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}

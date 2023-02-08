package com.example;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class ProcessingWebCam extends PApplet  {
	
	private static final String FILE_PATH = "resources/cat.jpg";
	
	Mat matWebCam;
	PImage pImageWebCam;
	VideoCapture capture;
	
	PImage pImageCat;
	
	
	public void settings() {
		size(800, 600);
		
		
		capture = new VideoCapture(0);
		if(capture.isOpened() == false) {
			System.out.println("Unable to open camera");
			capture.release();
			System.exit(0);
		}
		
		matWebCam = new Mat();
		
		Mat matCatImg = Imgcodecs.imread(FILE_PATH);
		pImageCat = MatToPImage(matCatImg);
	}
	
	public void draw() {
		if(capture.read(matWebCam)) {
			pImageWebCam = MatToPImage(matWebCam);
			image(pImageWebCam,400,0,400,300);
		}
		
		image(pImageCat, 0, 0, 400, 300);
	}

	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		PApplet.main(ProcessingWebCam.class.getName());
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

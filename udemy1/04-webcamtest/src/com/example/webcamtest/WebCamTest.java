package com.example.webcamtest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class WebCamTest {
	
	private static final String WINDOW_NAME = "web cam";
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture capture = new VideoCapture(0);
		
		HighGui.namedWindow(WINDOW_NAME);
		Mat frame = new Mat();
		
		while(true) {
			capture.read(frame);
			HighGui.imshow(WINDOW_NAME, frame);
			if(HighGui.waitKey(10) == 27)  // break on the escape key
				break;
		}
		
		System.exit(0);
	}

}

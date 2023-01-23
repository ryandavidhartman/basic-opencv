package com.example.displaytest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class DisplayTest {
	
	private static final String FILE_PATH = "resources/cat.jpg";
	private static final String WINDOW_NAME = "original image";

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat originalImage = Imgcodecs.imread(FILE_PATH);
		if(originalImage.dataAddr()==0){
			System.out.println("Couldn't open file " + FILE_PATH);
		} else {
			HighGui.namedWindow(WINDOW_NAME);
			HighGui.imshow(WINDOW_NAME, originalImage);
			HighGui.waitKey();
		}
	}

}

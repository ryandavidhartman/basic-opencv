package com.example.webcamtest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class WebCamTest2 {
	
	private static final String WINDOW_WEBCAM = "webcam";
	private static final String WINDOW_IMAGE = "original image";
	
	private static final String IMAGE_FILE_PATH = "resources/cat.jpg";
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		
		
		Mat originalImage = Imgcodecs.imread(IMAGE_FILE_PATH);
		if(originalImage.dataAddr()==0){
			System.out.println("Couldn't open file: " + IMAGE_FILE_PATH);
			System.exit(-1);
		} else {
			HighGui.namedWindow(WINDOW_IMAGE);
		}
		
		
		VideoCapture capture = new VideoCapture(0);
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 640);
		capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 480);
		
		if(capture.isOpened() == false) {
			System.out.println("Unable to open camera");
			capture.release();
			System.exit(0);
		}
		
		HighGui.namedWindow(WINDOW_WEBCAM);
		Mat frame = new Mat();
		
		while(true) {
			capture.read(frame);
			if(frame.empty()) {
				System.out.println("empty frame");
				break;
			}
			HighGui.imshow(WINDOW_WEBCAM, frame);
			HighGui.imshow(WINDOW_IMAGE, originalImage);
			if(HighGui.waitKey(10) == 27)  // break on the escape key
				break;
		}
		
		
		HighGui.destroyAllWindows();
		capture.release();
		System.exit(0);
	}

}

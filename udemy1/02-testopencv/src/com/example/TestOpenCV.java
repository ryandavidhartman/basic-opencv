package com.example;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class TestOpenCV {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat matrix = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("matrix = " + matrix.dump());
		
	}

}

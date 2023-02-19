package com.example;

import java.util.LinkedList;
import java.util.Queue;

import org.opencv.core.Core;

import processing.core.PApplet;

public class BreathDetect extends PApplet {
	
	public Queue<Double> periods;
	public static int currentDirection = 0;
	public static boolean toShutdown = false;
	public static double currentPointY = 300.0f;
	
	public void setup() {
		
		periods = new LinkedList<>();
		initQueue();
	}
	
	private void initQueue() {
		for(int i = 0; i<5; i++) {
			periods.add(8.0);
		}
	}
	
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		PApplet.main(BreathDetect.class.getName());
	}

}

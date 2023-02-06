package com.example;

import processing.core.*;


public class ProcessingHello extends PApplet {
	
	public void settings() {
		size(800, 600);
	}
	
	public void draw() {
		if(mousePressed) {
		    fill(0);
		 } else {
		    fill(255);
		 }
		  ellipse(mouseX, mouseY, 80, 80);
	}

	public static void main(String[] args) {
		PApplet.main(ProcessingHello.class.getName());
	}

}


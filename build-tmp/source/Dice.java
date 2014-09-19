import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die ding;
Die dong;

public void setup() {
	size(400,400);
	noLoop();
}

public void draw() {
	background(random(10,200),random(10,200), random(10,200));
	ding = new Die(200, 200);
	dong = new Die(75, 200);
	ding.roll();
	ding.show();
	dong.roll();
	dong.show();

	text(sumDots, 350,350);
}

public void mousePressed() {
	redraw();
}

class Die {
	int thingX, thingY, numDots, sumDots;
	Die(int x, int y) {
		thingX = x;
		thingY = y;
	}

	public void roll() {
		numDots = (int) ((Math.random()*6)+1);
		sumDots = ding.numDots + dong.numDots;
}

public void show() {
	fill(255);
	rectMode(CENTER);
	rect(thingX,thingY, 100,100, 10);

	fill(0);
	if (numDots == 1) {
		ellipse(thingX,thingY, 20,20);
	} else if (numDots == 2) {
		ellipse(thingX - 25,thingY - 25, 20,20);
		ellipse(thingX + 25,thingY + 25, 20,20);
	} else if (numDots == 3) {
		ellipse(thingX - 25,thingY - 25, 20,20);
		ellipse(thingX,thingY, 20,20);
		ellipse(thingX + 25,thingY + 25, 20,20);
	} else if (numDots == 4) {
		ellipse(thingX - 25,thingY - 25, 20,20);
		ellipse(thingX + 25,thingY - 25, 20,20);
		ellipse(thingX - 25,thingY + 25, 20,20);
		ellipse(thingX + 25,thingY + 25, 20,20);
	} else if (numDots == 5) {
		ellipse(thingX - 25,thingY - 25, 20,20);
		ellipse(thingX + 25,thingY - 25, 20,20);
		ellipse(thingX,thingY,20,20);
		ellipse(thingX - 25,thingY + 25, 20,20);
		ellipse(thingX + 25,thingY + 25, 20,20);
	} else {
		ellipse(thingX - 25,thingY - 25, 20,20);
		ellipse(thingX - 25,thingY + 25, 20,20);
		ellipse(thingX - 25,thingY, 20,20);
		ellipse(thingX + 25,thingY - 25, 20,20);
		ellipse(thingX + 25,thingY,20,20);
		ellipse(thingX + 25,thingY + 25, 20,20);
	}

	textAlign(CENTER);
	textSize(50);
	text(numDots, thingX,350);
}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

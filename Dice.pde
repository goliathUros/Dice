Die ding;
Die dong;
Die dang;

void setup() {
  size(400,400);
  noLoop();
}

void draw() {
  background(random(10,200),random(10,200), random(10,200));
  ding = new Die(200, 200);
  dong = new Die(75, 200);
  dang = new Die(325, 200);
  ding.roll();
  ding.show();
  dong.roll();
  dong.show();
  dang.roll();
  dang.show();
  
  textAlign(CENTER);
  textSize(20);
  text("Sum: " + (ding.numDots + dong.numDots + dang.numDots), 200, 100);
}

void mousePressed() {
  redraw();
}

class Die {
  int thingX, thingY, numDots;
  Die(int x, int y) {
    thingX = x;
    thingY = y;
  }

  void roll() {
    numDots = (int) ((Math.random()*6)+1);
  }  

void show() {
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
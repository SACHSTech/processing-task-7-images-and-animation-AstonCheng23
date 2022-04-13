import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  int x = 512;
  int y = 384;
  
  double xSpeed = 5;
  double ySpeed = 5;
	
  
  PImage img;
  PImage background_room;
  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1024, 768);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0, 0, 0);
    
    img = loadImage("evil_eric_fabroa.jpg");
    background_room = loadImage("Hyperspace-star-streaks-effect.jpg");  
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(background_room);    
    image(img, x -50, y - 25);   

    if ((x > width) || (x < 0)) {
      xSpeed = xSpeed * -1.1;
    }
    if ((y > height) || (y < 0)) {
      ySpeed = ySpeed * -1.1;
    }
  

    x = (int) (x + (int) xSpeed);
    y = (int) (y + (int) ySpeed);

    println(x + " " + y);


  }
  
  // define other methods down here.
}
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	int width = 1024;
  int height = 640;

  int x = 512;
  int y = 320;
  
  double xSpeed = 0;
  double ySpeed = 0;

  double xStep = 5;

  int xProjectile = 512;
  int yProjectile = 320;

  double xProjectileSpeed = 5;
  double yProjectileSpeed = 5;
  
  PImage img;
  PImage backgroundRoom;
  PImage starProjectile;
  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(width, height);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0, 0, 0);
    
    img = loadImage("evil_eric_fabroa.jpg");
    backgroundRoom = loadImage("space.jpg");  
    starProjectile = loadImage("april fools.jpg");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(backgroundRoom);    
    image(img, x -50, y - 25);   
    
    if (frameCount == 120){
      frameCount = 0;
    }

    if ((x > width) || (x < 0)) {
      xSpeed = xSpeed * -1.1;
      x = 0;
    }
    if ((y > height) || (y < 0)) {
      ySpeed = ySpeed * -1.1;
    }

    x = (int) (x + (int) xSpeed);
    y = (int) (y + (int) ySpeed);

    println(x + " " + y + " " + frameCount + " " + xProjectile + " " + yProjectile);

    y = (int) (-0.002 * (x - 0)*(x - width));
    x += 5;
     
    projectileEight(x, y);


  }
  
  // define other methods down here.

  /**
   * Makes the second projectile. xProjectileLast and yProjectileLast remember the last x and y positions of the fabroa, and changes every 60 seconds.
   * @param xProjectileLast
   * @param yProjectileLast
   */
  public void projectileEight(int xProjectileLast, int yProjectileLast){ 

    if (frameCount == 60){
      xProjectile = xProjectileLast;
      yProjectile = yProjectileLast;   
    }


    image(starProjectile, xProjectile - 20, yProjectile - 19);


    if ((xProjectile > width) || (xProjectile < 0)) {
      xProjectileSpeed = (int) (xProjectileSpeed * -1.1);
    }
    if ((yProjectile > height) || (yProjectile < 0)) {
      yProjectileSpeed = (int) (yProjectileSpeed * -1.1);
    }

    xProjectile = (int) (xProjectile + (int) xProjectileSpeed);
    yProjectile = (int) (yProjectile + (int) yProjectileSpeed);

      
  }

}
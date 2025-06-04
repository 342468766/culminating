/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processing;

/**
 *
 * @author 342468766
 */
import processing.core.PApplet;

public class MySketch extends PApplet {
  private Animal person1;
  private Animal person2;
  private boolean showInfo = false;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255);
    person1 = new Animal(this, 0, 0, "Mr. Lu", 16, "images/person.png");
    person2 = new Animal(this, 100, 100, "Mr. Loo", 88, "images/person.png");
  }
  
  public void draw() {
    background(255);
    person1.draw();

    if (keyPressed) {
      if (keyCode == LEFT) {
          person2.move(-2, 0);
        } else if (keyCode == RIGHT) {
          person2.move(2, 0);
        } else if (keyCode == UP) {
          person2.move(0, 2);
        } else if (keyCode == DOWN) {
          person2.move(0, -2);
      }
    }
    person2.draw();
    drawCollisions();
  }
    
    public void drawCollisions() {
        if (person1.isCollidingWith(person2)) {
          fill(255, 0, 0);
          this.text("oouch", person2.x, person2.y);
        }
    }
}

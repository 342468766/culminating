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
  private Animal animal;
  private boolean showInfo = false;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    fill(255);
    animal = new Animal(this, 0, 0);
  }
  
  public void draw() {
    background(255);
    animal.draw();
  }
}
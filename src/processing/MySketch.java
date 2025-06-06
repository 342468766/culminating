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
  // Initalize variables and arrays
  private Animal[] animals = new Animal[12];
  
  private Animal background1;

  int stage = 0;
  
  // Settings
  public void settings() {
    size(400, 400);
  }

  // Setup
  public void setup() {
    background(255);
    textSize(20);
       
    // Add animals to array
    animals[0] = new Animal(this, 0, 0, "images/rat.png");
    animals[1] = new Animal(this, 100, 0, "images/ox.png");
    animals[2] = new Animal(this, 200, 0, "images/tiger.png");
    animals[3] = new Animal(this, 300, 0, "images/rabbit.png");
    animals[4] = new Animal(this, 0, 150, "images/dragon.png");
    animals[5] = new Animal(this, 100, 150, "images/snake.png");
    animals[6] = new Animal(this, 200, 150, "images/horse.png");
    animals[7] = new Animal(this, 300, 150, "images/sheep.png");
    animals[8] = new Animal(this, 0, 300, "images/monkey.png");
    animals[9] = new Animal(this, 100, 300, "images/rooster.png");
    animals[10] = new Animal(this, 200, 300, "images/dog.png");
    animals[11] = new Animal(this, 300, 300, "images/pig.png");
    
    // Create backgrounds
    background1 = new Animal(this, -100, 0, "images/background1.png");
  }
  
  // Draw
  public void draw() {
    if(stage == 0) {
      background1.draw();
      fill(0);
      text("Long ago, there was a Great Race with 12", 30 , 175);
      text("animals competing for a Chinese Zodiac spot", 10, 200);
      text("Now it's your turn to race. (Press Enter)", 35, 225);
    } else if (stage == 1) {
        background1.draw();
        fill(0);
        for (int i = 0; i < animals.length; i++) {
            animals[i].draw();
        }
    } else if (stage == 2) {
        background(255);
    } else if (stage == 3) {
        background(255);
    } else if (stage == 4) {
        background(255);
    } else if (stage == 5) {
        background(255);
    } else if (stage == 6) {
        background(255);
    } else if (stage == 7) {
        background(255);
    } else if (stage == 8) {
        background(255);
    } else if (stage == 9) {
        background(255);
    } else if (stage == 10) {
        background(255);
    } else if (stage == 11) {
        background(255);
    }
  }
 
  public void keyPressed() {
      if(stage == 0) {
          if(keyCode == ENTER) {
              stage = 1;
          }
      }
  }
  
  public void mousePressed() {
      for (int i = 0; i < animals.length; i++) {
          if(animals[i].isClicked(mouseX, mouseY)) {
              stage = i + 2;
              break;
          }
      }
  }
}
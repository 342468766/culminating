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
  private Animal rat;
  private Animal ox;
  private Animal tiger;
  private Animal rabbit;
  private Animal dragon;
  private Animal snake;
  private Animal horse;
  private Animal sheep;
  private Animal monkey;
  private Animal rooster;
  private Animal dog;
  private Animal pig;
  
  private Animal background1;

  int stage = 0;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255);
    
    String animals[] = new String[12];
    
    rat = new Animal(this, 0, 0, "images/rat.png");
    ox = new Animal(this, 100, 0, "images/ox.png");
    tiger = new Animal(this, 200, 0, "images/tiger.png");
    rabbit = new Animal(this, 300, 0, "images/rabbit.png");
    dragon = new Animal(this, 0, 100, "images/dragon.png");
    snake = new Animal(this, 100, 100, "images/snake.png");
    horse = new Animal(this, 200, 100, "images/horse.png");
    sheep = new Animal(this, 300, 100, "images/sheep.png");
    monkey = new Animal(this, 0, 200, "images/monkey.png");
    rooster = new Animal(this, 100, 200, "images/rooster.png");
    dog = new Animal(this, 200, 200, "images/dog.png");
    pig = new Animal(this, 300, 200, "images/pig.png");
    background1 = new Animal(this, -100, 0, "images/background1.png");
  }
  
  public void draw() {
    background1.draw();
    
    if (stage == 1) {
        fill(0);
        rat.draw();
        ox.draw();
        tiger.draw();
        rabbit.draw();
        dragon.draw();
        snake.draw();
        horse.draw();
        sheep.draw();
        monkey.draw();
        rooster.draw();
        dog.draw();
        pig.draw();
    }
  }
 
  public void mousePrssed() {
      if(stage == 0) {
          if(background1.isClicked(mouseX, mouseY)) {
              stage = 1;
          }
      }
  }
}
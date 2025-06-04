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

  int stage = 0;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255);
    rat = new Animal(this, 75, 100, "images/rat.png");
    ox = new Animal(this, 150, 100, "images/ox.png");
    tiger = new Animal(this, 225, 100, "images/tiger.png");
    rabbit = new Animal(this, 300, 100, "images/rabbit.png");
    dragon = new Animal(this, 75, 200, "images/dragon.png");
    snake = new Animal(this, 150, 200, "images/snake.png");
    horse = new Animal(this, 225, 200, "images/horse.png");
    sheep = new Animal(this, 300, 200, "images/sheep.png");
    monkey = new Animal(this, 75, 300, "images/monkey.png");
    rooster = new Animal(this, 150, 300, "images/rooster.png");
    dog = new Animal(this, 0, 225, "images/dog.png");
    pig = new Animal(this, 0, 300, "images/pig.png");

  }
  
  public void draw() {
    background(255);
    
    if (stage == 0) {
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
}
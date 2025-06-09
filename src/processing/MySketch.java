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
  private Animal background2;
  private Animal background3;
  
  private Animal log;
  private Animal eyes;

  int stage = 0;
  int horseMovement = 0;
  int eyeMovement = 0;
  
  // Settings
  public void settings() {
    size(400, 400);
  }

  // Setup
  public void setup() {
    background(255);
    textSize(20);
       
    // Add animals to array and create animal sprites
    animals[0] = new Animal(this, 0, 0, "images/rat.png");
    animals[1] = new Animal(this, 100, 0, "images/ox.png");
    animals[2] = new Animal(this, 215, 25, "images/tiger.png");
    animals[3] = new Animal(this, 325, 25, "images/rabbit.png");
    animals[4] = new MoveAnimals(this, 0, 150, "images/dragon.png", 2);
    animals[5] = new MoveAnimals(this, 125, 175, "images/snake.png", 2);
    animals[6] = new MoveAnimals(this, 200, 150, "images/horse.png", -5);
    animals[7] = new Animal(this, 300, 150, "images/sheep.png");
    animals[8] = new Animal(this, 0, 300, "images/monkey.png");
    animals[9] = new Animal(this, 100, 300, "images/rooster.png");
    animals[10] = new Animal(this, 200, 300, "images/dog.png");
    animals[11] = new Animal(this, 300, 300, "images/pig.png");
    
    // Create background sprites
    background1 = new Animal(this, -100, 0, "images/background1.png");
    background2 = new Animal(this, -100, 0, "images/background2.png");
    background3 = new Animal(this, -100, -100, "images/background3.png");

    // Create other sprites
    log = new Animal(this, 225, 225, "images/log.png");
    eyes = new MoveAnimals(this, 200, 300, "images/eyes.png", -5);

  }
  
  // Draw
  public void draw() {
    // Introduction
    if(stage == 0) {
        background1.draw();
        fill(0);
        text("Long ago, there was a Great Race with 12", 30 , 175);
        text("animals competing for a Chinese Zodiac spot", 10, 200);
        text("Now it's your turn to race.", 100, 225);
        text("(Press ENTER)", 140, 330);
    // Animal select
    } else if (stage == 1) {
        background1.draw();
        fill(0);
        for (int i = 0; i < animals.length; i++) {
            animals[i].draw();
            animals[i].setPosition(animals[i].x, animals[i].y);
        }
       
    // Animal games
    // Rat and Ox game
    } else if (stage == 2 || stage == 3) {
        background2.draw();
    // Tiger game
    } else if (stage == 4) {
        background2.draw();
    // Rabbit and Dragon game
    } else if (stage == 5 || stage == 6) {
        background2.draw();

        // Game explanation
        text("Help the rabbit across!" , 105 , 40);
        text("Hover your cursor on the dragon" , 65, 60);
        
        // Move rabbit object to the right
        if (animals[3].x + 50 < 400 && log.x + 50 < 400) {
            animals[3].move(1, 0);
            log.move(1, 0);
        }
        
        // Move dragon object back and forth
        MoveAnimals dragon = (MoveAnimals) animals[4];
        dragon.move(dragon.getSpeed(), 0);
        
        if (dragon.x < 0 || dragon.x > width - 100) {
            dragon.setSpeed(dragon.getSpeed() * - 1);
        }

        // Blow rabbit object to the left
        if (animals[4].isClicked(mouseX, mouseY)) {
            animals[3].move(-3, 0);
             log.move(-3, 0);
        }

        // Game win
        if (animals[3].x + 50 < 0 && log.x  + 50 < 0) {
            stage = 14;
        }
        
        // Draw sprites
        animals[3].draw();
        log.draw();
        animals[4].draw();

    // Snake and Horse game
    } else if (stage == 7 || stage == 8) {
        background3.draw();
        
        fill(255);
        
        // Game explanation
        text("Catch the horse and avoid the eyes!" , 50 , 40);
        text("Use arrow keys to move" , 100, 60);
        
        // Keyboard controls
        MoveAnimals snake = (MoveAnimals) animals[5];
        if (keyPressed) {
            if(keyCode == LEFT) {
                snake.move(-snake.getSpeed(), 0);
            } else if (keyCode == RIGHT) {
                snake.move(snake.getSpeed(), 0);
            } else if (keyCode == UP) {
                snake.move(0, -snake.getSpeed());
            } else if (keyCode == DOWN) {
                snake.move(0, snake.getSpeed());
            }
        }
        
        // Horse movement
        MoveAnimals horse = (MoveAnimals) animals[6];
        horse.move(0, horse.getSpeed());
        
        if (horseMovement == 0) {
            if (horse.y < 0 || horse.y > height - 100) {
                horse.setSpeed(horse.getSpeed() * - 1);
                horse.setPosition(200, 0);
                horseMovement = 1;
            }
        } else if (horseMovement == 1) {
            if (horse.y < 0 || horse.y > height - 100) {
                horse.setSpeed(horse.getSpeed() * - 1);
                horse.setPosition(300, 300);
                horseMovement = 2;
            }    
        } else if (horseMovement == 2) {
            if (horse.y < 0 || horse.y > height - 100) {
                horse.setSpeed(horse.getSpeed() * - 1);
                horse.setPosition(0, 0);
                horseMovement = 3;
            }
        } else if (horseMovement == 3) {
            if (horse.y < 0 || horse.y > height - 100) {
                horse.setSpeed(horse.getSpeed() * - 1);
                horse.setPosition(100, 300);
                horseMovement = 0;
            }
        }
        
        // Horse eye movement
        MoveAnimals eye = (MoveAnimals) eyes;
        eyes.move(0, eye.getSpeed());
        
        if (eyeMovement == 0) {
            if (eye.y < 0 || eye.y > height - 100) {
                eye.setSpeed(eye.getSpeed() * - 1);
                eye.setPosition(300, 0);
                eyeMovement = 1;
            }
        } else if (eyeMovement == 1) {
            if (eye.y < 0 || eye.y > height - 100) {
                eye.setSpeed(eye.getSpeed() * - 1);
                eyes.setPosition(0, 300);
                eyeMovement = 2;
            }    
        } else if (eyeMovement == 2) {
            if (eye.y < 0 || eye.y > height - 100) {
                eye.setSpeed(eye.getSpeed() * - 1);
                eye.setPosition(100, 0);
                eyeMovement = 3;
            }
        } else if (eyeMovement == 3) {
            if (eyes.y < 0 || eye.y > height - 100) {
                eye.setSpeed(eye.getSpeed() * - 1);
                eye.setPosition(200, 300);
                eyeMovement = 0;
            }
        }
        
        // Call draw collsions method
        drawCollisions();
        
        // Draw sprites
        animals[6].draw();
        animals[5].draw();
        eyes.draw();
        
    // Sheep, Monkey and Rooster game
    } else if (stage == 9 || stage == 10|| stage == 11) {
        background2.draw();
    // Dog game
    } else if (stage == 12) {
        background2.draw();
    // Pig game
    } else if (stage == 13) {
        background2.draw();
    // Win screen
    } else if (stage == 14) {
        background(255);
        fill(0);
        text("You Win!!!", 150, 200);
        text("(Press ENTER for back to menu)", 70, 330);
        text("(Press SHIFT for play history)", 80, 360);    
    // Fail screen
    } else if (stage == 15) {
        background(255);
        fill(0);
        text("Try Again", 155, 200);
        text("(Press ENTER for back to menu)", 70, 330);
        text("(Press SHIFT for play history)", 80, 360);    
    // Play history
    } else if (stage == 16) {
        background(255);
    }
  }
 
  public void keyPressed() {
      // Move to animal selection
      if(stage == 0) {
          if(keyCode == ENTER) {
              stage = 1;
          }
      // Move to menu or play history
      } else if (stage == 14 || stage == 15) {
          if(keyCode == ENTER) {
              stage = 1;
          } else if(keyCode == SHIFT) {
              stage = 16;
          }
      }
  }
  
  
  public void mousePressed() {
      for (int i = 0; i < animals.length; i++) {
          if(animals[i].isClicked(mouseX, mouseY)) {
              stage = i + 2;
          
          if (stage == 5 || stage == 6) {
            // Set animal positions
             animals[3].setPosition(250, 200); 
             animals[4].setPosition(300, 75);
          } else if (stage == 7 || stage == 8) {
             animals[5].setPosition(0, 200); 
             animals[6].setPosition(100, 300);
          }
          
          break;
          }
      }
  }
  
  public void drawCollisions() {
      // Snake and Horse game collision detected
      if (animals[5].isCollidingWith(animals[6])) {
          stage = 14;
      } else if (animals[5].isCollidingWith(eyes)) {
          stage = 15;
      }
  }
  
}
  

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
  
  private Animal wind;
  private Animal log;
  private Animal eyes;
  private Animal ball;
  private Animal potato;

  int stage = 0;
  
  private int oxMovement = 0;  
  private int windMovement = 0;  
  private int horseMovement = 0;
  private int eyeMovement = 0;  
  private static int count = 0;
  
  // Settings
  public void settings() {
    size(400, 400);
  }

  // Setup
  public void setup() {
    background(255);
    textSize(20);
       
    // Add animals to array and create animal sprites
    animals[0] = new MoveAnimals(this, 25, 25, "images/rat.png", 2);
    animals[1] = new MoveAnimals(this, 100, 0, "images/ox.png", 4);
    animals[2] = new ClickAnimals(this, 215, 25, "images/tiger.png", 20);
    animals[3] = new Animal(this, 325, 25, "images/rabbit.png");
    animals[4] = new MoveAnimals(this, 0, 150, "images/dragon.png", 2);
    animals[5] = new MoveAnimals(this, 125, 175, "images/snake.png", 2);
    animals[6] = new MoveAnimals(this, 200, 150, "images/horse.png", -5);
    animals[7] = new Animal(this, 300, 150, "images/sheep.png");
    animals[8] = new Animal(this, 0, 300, "images/monkey.png");
    animals[9] = new Animal(this, 100, 300, "images/rooster.png");
    animals[10] = new MoveAnimals(this, 210, 310, "images/dog.png", 3);
    animals[11] = new MoveAnimals(this, 310, 310, "images/pig.png", 3);
    
    // Create background sprites
    background1 = new Animal(this, -100, 0, "images/background1.png");
    background2 = new Animal(this, -100, 0, "images/background2.png");
    background3 = new Animal(this, -100, -100, "images/background3.png");

    // Create other sprites
    wind = new MoveAnimals(this, 50, 200, "images/wind.png", 5);
    log = new Animal(this, 225, 225, "images/log.png");
    eyes = new MoveAnimals(this, 200, 300, "images/eyes.png", -5);
    ball = new Animal(this, 225, 225, "images/ball.png");
    potato = new Animal(this, 225, 225, "images/potato.png");

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
        
        // Set and reset positions
        animals[0].setPosition(25, 25);
        animals[1].setPosition(100, 0);
        animals[2].setPosition(215, 25);
        animals[3].setPosition(325, 25);
        animals[4].setPosition(0, 150);
        animals[5].setPosition(125, 175);
        animals[6].setPosition(200, 150);
        animals[7].setPosition(300, 150);
        animals[8].setPosition(0, 300);
        animals[9].setPosition(100, 300);
        animals[10].setPosition(210, 310);
        animals[11].setPosition(310, 310);
        
        for (int i = 0; i < animals.length; i++) {
            animals[i].draw();
            animals[i].setPosition(animals[i].x, animals[i].y);
        }
       
    // Animal games
    // Rat and Ox game
    } else if (stage == 2 || stage == 3) {
        background3.draw();
        
        fill(255);
        
        // Game explanation
        text("Hide behind the ox for cover!" , 80 , 40);
        text("Use arrow keys to move" , 100, 60);
        text("Wind dodged: " + count, 120, 80);
        
        // Keyboard controls
        MoveAnimals rat = (MoveAnimals) animals[0];
        if (keyPressed) {
            if(keyCode == LEFT) {
                rat.move(-rat.getSpeed(), 0);
            } else if (keyCode == RIGHT) {
                rat.move(rat.getSpeed(), 0);
            } else if (keyCode == UP) {
                rat.move(0, -rat.getSpeed());
            } else if (keyCode == DOWN) {
                rat.move(0, rat.getSpeed());
            }
        }
        
        // Ox movement
        MoveAnimals ox = (MoveAnimals) animals[1];
        ox.move(0, ox.getSpeed());

        if (ox.y < 0 || ox.y > height - 100) {
            ox.setSpeed(ox.getSpeed() * - 1);
        }
        
        // Wind movement
        MoveAnimals windBlow = (MoveAnimals) wind;
        windBlow.move(windBlow.getSpeed(), 0);
        
        if (windMovement == 0) {
            if (windBlow.x < 0 || windBlow.x > width - 50) {
                windBlow.setPosition(50, 100);
                count++;
                windMovement = 1;
            }
        } else if (windMovement == 1) {
            if (windBlow.x < 0 || windBlow.x > width - 50) {
                windBlow.setPosition(50, 300);
                count++;
                windMovement = 2;
            }    
        } else if (windMovement == 2) {
            if (windBlow.x < 0 || windBlow.x > width - 50) {
                windBlow.setPosition(50, 150);
                count++;
                windMovement = 3;
            }
        } else if (windMovement == 3) {
            if (windBlow.x < 0 || windBlow.x > width - 50) {
                windBlow.setPosition(50, 350);
                count++;
                windMovement = 4;
            }
        } else if (windMovement == 4) {
            if (windBlow.x < 0 || windBlow.x > width - 50) {
                windBlow.setPosition(50, 50);
                count++;
                windMovement = 0;
            }
        }
        
        // Win condition
        if (count == 20) {
            stage = 14;
        }
        
        // Call draw collsions method
        drawCollisions();
        
        // Draw sprites
        animals[0].draw();
        animals[1].draw();
        wind.draw();
        
    // Tiger game
    } else if (stage == 4) {
        background3.draw();
        
        fill(255);
        
        // Game explanation
        text("Gain strength to run fast!" , 105 , 40);
        text("Repeatedly left click the tiger" , 90, 60);
        
        
        
        // Draw sprites
        animals[2].draw();

    // Rabbit and Dragon game
    } else if (stage == 5 || stage == 6) {
        background2.draw();

        // Game explanation
        text("Help the rabbit across!" , 100, 40);
        text("Hover your cursor on the dragon" , 70, 60);
        
        // Move rabbit object to the right
        if (animals[3].x + 50 < 400 && log.x + 50 < 400) {
            animals[3].move(1, 0);
            log.move(1, 0);
        }
        
        // Blow rabbit object to the left
        if (animals[4].isClicked(mouseX, mouseY)) {
            animals[3].move(-4, 0);
            log.move(-4, 0);
        }
        
        // Move dragon object back and forth
        MoveAnimals dragon = (MoveAnimals) animals[4];
        dragon.move(dragon.getSpeed(), 0);
        
        if (dragon.x < 0 || dragon.x > width - 100) {
            dragon.setSpeed(dragon.getSpeed() * - 1);
        }

        // Win condition
        if (animals[3].x + 50 < 0 && log.x  + 50 < 0) {
            stage = 14;
        }
        
        // Call mouse pressed method
        mousePressed();
        
        // Draw sprites
        animals[3].draw();
        animals[4].draw();
        log.draw();

    // Snake and Horse game
    } else if (stage == 7 || stage == 8) {
        background3.draw();
        
        fill(255);
        
        // Game explanation
        text("Surprise the horse and avoid the eyes!" , 50 , 40);
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
                eye.setPosition(0, 300);
                eyeMovement = 2;
            }    
        } else if (eyeMovement == 2) {
            if (eye.y < 0 || eye.y > height - 100) {
                eye.setSpeed(eye.getSpeed() * - 1);
                eye.setPosition(100, 0);
                eyeMovement = 3;
            }
        } else if (eyeMovement == 3) {
            if (eye.y < 0 || eye.y > height - 100) {
                eye.setSpeed(eye.getSpeed() * - 1);
                eye.setPosition(200, 300);
                eyeMovement = 0;
            }
        }
        
        // Call draw collsions method
        drawCollisions();
        
        // Draw sprites
        animals[5].draw();
        animals[6].draw();
        eyes.draw();
        
    // Sheep, Monkey and Rooster game
    } else if (stage == 9 || stage == 10|| stage == 11) {
        background2.draw();
    // Dog game
    } else if (stage == 12) {
        background3.draw();
        
        fill(255);
        
        // Game explanation
        text("The dog is distracted. Catch ten balls!" , 50 , 40);
        text("Use arrow keys to move" , 100, 60);
        text("Balls Collected: " + count, 125, 80);
        
        // Keyboard controls
        MoveAnimals dog = (MoveAnimals) animals[10];
        if (keyPressed) {
            if(keyCode == LEFT) {
                dog.move(-dog.getSpeed(), 0);
            } else if (keyCode == RIGHT) {
                dog.move(dog.getSpeed(), 0);
            } else if (keyCode == UP) {
                dog.move(0, -dog.getSpeed());
            } else if (keyCode == DOWN) {
                dog.move(0, dog.getSpeed());
            }
        }
        
        // Ball spawns;
        if (count == 0) {
            ball.setPosition(225, 225);
        } else if (count == 1) {
            ball.setPosition(10, 10);
        } else if (count == 2) {
            ball.setPosition(150, 300);
        } else if (count == 3) {
            ball.setPosition(300, 50);
        } else if (count == 4) {
            ball.setPosition(25, 250);
        } else if (count == 5) {
            ball.setPosition(150, 200);
        } else if (count == 6) {
            ball.setPosition(100, 150);
        } else if (count == 7) {
            ball.setPosition(300, 10);
        } else if (count == 8) {
            ball.setPosition(10, 350);
        } else if (count == 9) {
            ball.setPosition(200, 200);
        // Win condition
        } else if (count == 10) {
            stage = 14;
        }
        
        // Call draw collsions method
        drawCollisions();
        
         // Draw sprites
        animals[10].draw();
        ball.draw();
        
    // Pig game
    } else if (stage == 13) {
        background3.draw();
        
        fill(255);
        
        // Game explanation
        text("The pig is hungry. Catch ten potatoes!" , 50 , 40);
        text("Use arrow keys to move" , 100, 60);
        text("Potatoes Collected: " + count, 125, 80);
        
        // Keyboard controls
        MoveAnimals pig = (MoveAnimals) animals[11];
        if (keyPressed) {
            if(keyCode == LEFT) {
                pig.move(-pig.getSpeed(), 0);
            } else if (keyCode == RIGHT) {
                pig.move(pig.getSpeed(), 0);
            } else if (keyCode == UP) {
                pig.move(0, -pig.getSpeed());
            } else if (keyCode == DOWN) {
                pig.move(0, pig.getSpeed());
            }
        }
        
        // Ball spawns;
        if (count == 0) {
            potato.setPosition(225, 225);
        } else if (count == 1) {
            potato.setPosition(300, 300);
        } else if (count == 2) {
            potato.setPosition(50, 250);
        } else if (count == 3) {
            potato.setPosition(200, 50);
        } else if (count == 4) {
            potato.setPosition(350, 250);
        } else if (count == 5) {
            potato.setPosition(20, 20);
        } else if (count == 6) {
            potato.setPosition(100, 150);
        } else if (count == 7) {
            potato.setPosition(150, 200);
        } else if (count == 8) {
            potato.setPosition(320, 350);
        } else if (count == 9) {
            potato.setPosition(200, 200);
        // Win condition
        } else if (count == 10) {
            stage = 14;
        }
        
        // Call draw collsions method
        drawCollisions();
        
         // Draw sprites
        animals[11].draw();
        potato.draw();
        
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
          // Go to stage based on selected animal
          if (stage == 1) {
            if(animals[i].isClicked(mouseX, mouseY)) {
                stage = i + 2;

                // Reset properties
                count = 0;
            }
          
            // Reset animal positions
            // Set rat and ox position
            if (stage == 2 || stage == 3) {
               animals[0].setPosition(350, 200); 
               animals[1].setPosition(200, 300);
               wind.setPosition(50, 200);
            // Set tiger position
            } else if (stage == 4) {
                animals[2].setPosition(350, 200);
            // Set rabbit and dragon position
            } else if (stage == 5 || stage == 6) {
               animals[3].setPosition(250, 200); 
               animals[4].setPosition(300, 75);
               log.setPosition(225, 225);
            // Set snake and horse position
            } else if (stage == 7 || stage == 8) {
               animals[5].setPosition(0, 200); 
               animals[6].setPosition(100, 300);
               eyes.setPosition(200, 300);
            // Set dog position
            } else if (stage == 12) {
               animals[10].setPosition(0, 200);
            // Set pig position
            } else if (stage == 13) {
               animals[11].setPosition(0, 200);
            }
          }
      }
  }
  
  public void drawCollisions() {
      // Rat and ox game
      if (animals[0].isCollidingWith(wind)) {
          stage = 15;
      } else if(animals[1]. isCollidingWith(wind)) {
          wind.setPosition(50, 200);
          count++;
          if (windMovement < 4) {
              windMovement++;
          }
      // Snake and Horse game collision detected
      } else if (animals[5].isCollidingWith(animals[6])) {
          stage = 14;
      } else if (animals[5].isCollidingWith(eyes)) {
          stage = 15;
      // Dog game collision detected
      } else if (animals[10].isCollidingWith(ball)) {
          count++;
      // Pig game collision detected
      } else if (animals[11].isCollidingWith(potato)) {
          count++;
      }
  }
  
}
  

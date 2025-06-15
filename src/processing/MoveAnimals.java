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

public class MoveAnimals extends Animal {
    // Attribtues
    private int speed;
    private final static int DEFAULT_SPEED = 2;
    private SlowMo slowMo;
    
    /**
     * This is the primary constructor
     * @param p is the canvas to display the animal
     * @param x is the x position of the animal
     * @param y is the y position of the animal
     * @param imagePath is the image of the animal
     * @param speed is the speed of the animal
     * @param slowMo is the state of slow mode
     */
    public MoveAnimals(PApplet p, int x, int y, String imagePath, int speed, SlowMo slowMo) {
        super(p, x, y, imagePath);
        this.speed = speed;
        this.slowMo = slowMo;
    }
    
    /**
     * This is the default constructor
     * @param p is the canvas to display the animal
     * @param x is the x position of the animal
     * @param y is the y position of the animal
     * @param imagePath is the image of the animal
     * @param slowMo is the state of slow mode
     */
    public MoveAnimals(PApplet p, int x, int y, String imagePath, SlowMo slowMo) {
        super(p, x, y, imagePath);
        this.speed = DEFAULT_SPEED;
        this.slowMo = slowMo;
    }
    
    /**
     * This method gets the speed value
     * @return the speed value
     */
    public int getSpeed() {
        return slowMo.adjustSpeed(speed);
    }
    
    /**
     * This method sets the speed 
     * @param speed the speed value
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    @Override
    public void draw() {
        super.draw();
        
        // Mark slow mode animals
        if(slowMo.isSlowMo()) {
            app.ellipse(x + width / 2, y + height / 2, 10, 10);
        }
    }
}

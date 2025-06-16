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

public class ClickAnimals extends Animal {
    // Attributes
    private int numberOfClicks;
    
    /**
     * This is the primary constructor
     * @param p is the canvas to display the animal
     * @param x is the x position of the animal
     * @param y is the y position of the animal
     * @param imagePath is the image of the animal
     * @param numberOfClicks is the number of clicks on the animal
     */
    public ClickAnimals(PApplet p, int x, int y, String imagePath, int numberOfClicks) {
        super(p, x, y, imagePath);
        this.numberOfClicks = numberOfClicks;
    }
    
    /**
     * This method gets the number of clicks
     * @return the number of clicks
     */
    public int getNumberOfClicks() {
        return numberOfClicks;
    }
    
    /**
     * This method sets the number of clicks
     * @param numberOfClicks is the number of clicks
     */
    public void setNumberOfClicks(int numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }
}


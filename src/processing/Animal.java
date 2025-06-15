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
import processing.core.PImage;

public class Animal {
    // Attributes
    protected int x, y;
    protected int width, height;
    protected PImage image;
    protected PApplet app;
    
    /**
     * This is the primary constructor
     * @param p is the canvas to display the animal
     * @param x is the x position of the animal
     * @param y is the y position of the animal
     * @param imagePath is the image of the animal
     */
    public Animal(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        this.width = image.width;
        this.height = image.height;
    }
    
    /**
     * This method moves the animal in the x and y position
     * @param dx is the x movement
     * @param dy is the y movement
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * This method sets the position for the animal
     * @param dx is the x co-ordinate
     * @param dy is the y co-ordinate
     */
    public void setPosition(int dx, int dy) {
        x = dx;
        y = dy;
    }
    
    /**
     * This method draws the image at the position
     */
    public void draw() {
        app.image(image, x, y);
    }
    
    /**
     * This method is used to detect rectangular collisions between two objects
     * @param other is the object being collided into
     * @return detects the collision
     */
    public boolean isCollidingWith(Animal other) {
        boolean isLeftOfOtherRight = x < other.x + other.width - 20;
        boolean isRightOfOtherLeft = x + width - 20 > other.x;
        boolean isAboveOtherBottom = y < other.y + other.height - 20;
        boolean isBelowOtherTop = y + height - 20 > other.y;
        
        return isLeftOfOtherRight && isRightOfOtherLeft
                && isAboveOtherBottom && isBelowOtherTop;
    }
    
    /**
     * This method detects mouse clicks
     * @param mouseX is the x position of the mouse
     * @param mouseY is the y position of the mouse
     * @return detects the mouse click
     */
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x + (image.pixelWidth/2);
        int centerY = y + (image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        return d < 32;
    }

}
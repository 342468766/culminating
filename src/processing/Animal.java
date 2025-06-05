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
    protected int x, y; // Position of the animal
    private int width, height; // Dimensions of the image
    protected PImage image; // Image of the animal
    private PApplet app; // The canvas used to display graphical elements
    
    // Primary constructor
    public Animal(PApplet p, int x, int y, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
        this.width = image.width;
        this.height = image.height;
    }
    
    public void draw() {
        app.image(image, x, y);
    }
    
    public boolean isCollidingWith(Animal other) {
        boolean isLeftOfOtherRight = x < other.x + other.width;
        boolean isRightOfOtherLeft =  + width > other.x;
        boolean isAboveOtherBottom = y < other.y + other.height;
        boolean isBelowOtherTop = y + height > other.y;
        
        return isLeftOfOtherRight && isRightOfOtherLeft
                && isAboveOtherBottom & isBelowOtherTop;
    }
    
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x + (image.pixelWidth/2);
        int centerY = y + (image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        return d < 16;
    }

}
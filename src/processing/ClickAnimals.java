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
    private int numberOfClicks;
    
    public ClickAnimals(PApplet p, int x, int y, String imagePath, int numberOfClicks) {
        super(p, x, y, imagePath);
        this.numberOfClicks = numberOfClicks;
    }
    
    public boolean isClicked(int mouseX, int mouseY) {
        int centerX = x + (image.pixelWidth/2);
        int centerY = y + (image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        return d < 16;
    }
    
    public int getNumberOfClicks() {
        return numberOfClicks;
    }
    
    public void setNumberOfClicks(int numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }
}

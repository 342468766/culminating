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
    private int speed;
    
    public MoveAnimals(PApplet p, int x, int y, String imagePath, int speed) {
        super(p, x, y, imagePath);
        this.speed = speed;
    }
    
    public void move(int dx, int dy) {
        x += dx;
        y -= dy;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

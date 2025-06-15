/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processing;

/**
 *
 * @author 342468766
 */
public class SlowMo {
    // Attributes
    private boolean isSlow;
    
    /**
     * This is the default constructor
     */
    public SlowMo () {
        this.isSlow = false;
    }
    
    /**
     * This method is used to toggle slow mode
     */
    public void toggleSlowMo() {
        isSlow = !isSlow;
    }
    
    /**
     * This method is to return the state slow mode is in
     * @return 
     */
    public boolean isSlowMo() {
        return isSlow;
    }
    
    /**
     * This method is used to adjust the speed if slow mode is on
     * @param speed is the speed of the animal
     * @return the speed of the animal
     */
    public int adjustSpeed(int speed) {
        if(isSlow == true) {
            return speed - 1;
        }
        return speed;
    }

}

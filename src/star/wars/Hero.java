/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

/**
 *
 * @author Alexander Shurts
 */
public class Hero extends Character {
    
    private int health;
    
    //Constructor
    public Hero() { //no-args
        super();
        health = 3;
    }
    
    public Hero(int x, int y, Color color, int size, String name) {
        super(x, y, color, size, name);
        health = 3;
    }
    
    
    //Public Method
    
    public void collect() {
        
    }
    
    public void teleport() {
        
    }
    
    
    //Getters
    public int health() {
        return health;
    }
    
    //Setters
    
    
    //Private Methods
    private void grow() {
        
    }
    
    private void canTeleport() {
        
    }
    
}

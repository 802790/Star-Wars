/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javafx.scene.input.KeyCode;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 802790
 */
public class Space extends JPanel{
    int x;
    int y;
    int color;
    int size;
    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Timer timer;
    
    public Space() {
        super();
        marginX = 15;
        marginY = 15;
        hero = new Hero(600, 480, Color.BLUE, 20, "Dude");
        enemy = new Enemy(800, 480, Color.RED, 20, "Enemy");
        timer = new Timer(); 
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 100);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        g.setColor(Color.CYAN);
        drawStars(g);
        
        hero.draw(g);
        enemy.draw(g);
        
        g.dispose();
        
        
    }

    public void drawStars(Graphics g) {
        for (int i = 0; i < 100; i++) {
            color = (int) (Math.random() * 3 + 1);
            if(color == 1) {
                g.setColor(Color.CYAN);
            }else if(color == 2){
                g.setColor(Color.YELLOW);
            }else if(color == 3) {
                g.setColor(Color.RED);
            }
            size = (int) (Math.random() * 5 + 3);
            x = (int) (Math.random() * 1100 + 25);
            y = (int) (Math.random() * 860 + 25);
            g.fillOval(x, y, size, size);
        }
    }
       
    /**
     * Makes the hero and enemy bounce off walls
     */    
    private void wallCollissions(Character c) {
        
        c.getX();
        c.getY();
        
        if (c.getX() <= 0 || c.getY() >= this.getWidth()) {
            c.reverseX();
        }
        
        if (c.getY() <= 0 || c.getY() >= this.getHeight()) {
            c.reverseY();
        }
        
    }

    void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            hero.setDX(3);
        }

            if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            hero.setDX(-3);
        }
    
            if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            hero.setDY(3);
        }

            if (e.getKeyCode() == KeyEvent.VK_UP ) {
            hero.setDY(-3);
        }
    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            hero.setDY(0);
    }
    

    
    
    
        private class ScheduleTask extends TimerTask {
        	    
        @Override
        public void run() {
        wallCollissions(hero);
        wallCollissions(enemy);
            hero.update();
            enemy.update();
            repaint();
        }
    
    public void keyPressed(KeyEvent e) {
        
        
            
    }
    
        
    }
}


        
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleanimationstarter;

/**
 *
 * @author Malcolm
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleAnimationStarter extends JPanel implements ActionListener {

    private int frameNum;
    
    public void actionPerformed(ActionEvent evt) {
        frameNum++;
        repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g, frameNum, getWidth(), getHeight());
    }
    
    public void drawFrame(Graphics g, int frameNumber, int width, int height){
        int inset=frameNumber%15;
        
        g.setColor(Color.CYAN);
        g.fillRect(0,0, width, height);
        g.setColor(Color.BLACK);
        
        int rectWidth = width - 2*inset;
        int rectHeight = height - 2*inset;
        
        while(rectWidth >=0 && rectHeight >= 0){
            g.drawRect(inset, inset, rectWidth, rectHeight);
            inset=inset+15;
            rectWidth -= 30;
            rectHeight -= 30;
            
        }
        
    }
    public static void main(String[] args) {
        // Frame title
        JFrame window = new JFrame("Simple Animation");
        
        // Instantiate object in which animatoins will be drawn
        SimpleAnimationStarter drawingArea = new SimpleAnimationStarter();
        
        drawingArea.setBackground(Color.yellow); //Assign background color to window pane
        window.setContentPane(drawingArea); // assign drawingArea details to window
        
        // Set initial size of window important to set pixle size as a new Dimension
        drawingArea.setPreferredSize(new Dimension(600,450));
        
        window.pack();
        window.setLocation(50,50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        
        // The 20 sets the between calls to drawFrame in milliseconds
        Timer frameTimer = new Timer(20,drawingArea);
        
        window.setVisible(true);
        frameTimer.start();
    }
    
}

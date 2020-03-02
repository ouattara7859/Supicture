/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class imageBox extends JPanel {
    
    Image img;
    
    public void changePicture(File file){
        try {
            img = ImageIO.read(file);
            repaint();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("-- Error while loading image : " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(img, 0, 0, this);   
    }
    
    
    
}

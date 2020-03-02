/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.views;

import com.supinfo.components.miniImage;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Supicture extends JFrame {

    JPanel mainPanel;
    static Supicture _instance;
    public Supicture() {

        setTitle("Supicture");
        setBounds(0, 0, 800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 800, 800);
        mainPanel.setBackground(Color.BLUE);
        add(mainPanel);

        mainPanel.setLayout(new FlowLayout(0));
        
        updateMainPanel();
        
    }
    
    public static Supicture getInstance() {
        if (_instance == null) {
            _instance = new Supicture();
        }
        return _instance;
    }
    
    public void updateMainPanel() {
        mainPanel.removeAll();
        File mainFolder = new File("images/");
        File[] listFile = mainFolder.listFiles();
        for (File file : listFile) {
            System.out.println(file.getName());
            miniImage img1 = new miniImage("Supicture", file);
            img1.changeText(file.getName());
            mainPanel.add(img1);
        }
    }

    public static void main(String args[]) {
        Supicture.getInstance();
    }

}

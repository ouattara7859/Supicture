package com.supinfo.components;

import com.supinfo.views.Supicture;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class miniImage extends javax.swing.JPanel {

    public JLabel getImageText() {
        return imageText;
    }

    public void setImageText(JLabel imageText) {
        this.imageText = imageText;
    }

    public void changeText(String text) {
        imageText.setText(text);
    }

    public miniImage() {
        
    }

    public miniImage(String text, File imageFile) {
        initComponents();
        try {
            imageText.setText(text);
            imageBox1.changePicture(imageFile);
        } catch (Exception e) {
            System.out.println("Error while loading image : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageText = new javax.swing.JLabel();
        imageBox1 = new com.supinfo.components.imageBox();
        deleteButton = new javax.swing.JButton();
        renameButton = new javax.swing.JButton();

        imageText.setText("Image text");

        imageBox1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout imageBox1Layout = new javax.swing.GroupLayout(imageBox1);
        imageBox1.setLayout(imageBox1Layout);
        imageBox1Layout.setHorizontalGroup(
            imageBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imageBox1Layout.setVerticalGroup(
            imageBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        renameButton.setText("Rename");
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageText)
                    .addComponent(imageBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(renameButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(renameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String imageName = this.getImageText().getText();
        File f = new File("images/" + imageName);
        f.delete();
        Supicture.getInstance().updateMainPanel();
        Supicture.getInstance().revalidate();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        String fileName = JOptionPane.showInputDialog(this, "Entrez le nom du fichier");
        String imageName = this.getImageText().getText();
        String extension = imageName.split("\\.")[1];
        File f = new File("images/" + imageName);
        f.renameTo(new File("images/" + fileName + "." + extension));
        Supicture.getInstance().updateMainPanel();
        Supicture.getInstance().revalidate();
    }//GEN-LAST:event_renameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private com.supinfo.components.imageBox imageBox1;
    private javax.swing.JLabel imageText;
    private javax.swing.JButton renameButton;
    // End of variables declaration//GEN-END:variables
}

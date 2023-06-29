/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author HP
 */
public class EscritorioPersonalizado extends JDesktopPane{
    private BufferedImage img;
    public EscritorioPersonalizado (){
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/imgs/futuro.jpg"));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //muestra la imagen
        //g.drawImage(img, 50,50,268,96,null);
        g.drawImage(img, 0,0,null);
    }
}

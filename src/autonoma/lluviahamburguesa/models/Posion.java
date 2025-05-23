/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.lluviahamburguesa.models;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author marti
 */
public class Posion extends ElementType {
    /**
     * Atributo
     */
    /**
     * Atributo de imagen de posion
     */
    private Image posionImage;
    /**
     * contructor
     */
    public Posion(int x, int y, int height, int width) {
        super(x, y, height, width);
        posionImage = new ImageIcon(getClass().getResource("/autonoma/lluviahamburguesa/images/pocion1.png")).getImage();
        setStep(2);
    }
    /**
     * metodos de acceso
     */
    public void registerHit(FoodField foodField) {
        delete(foodField);
    }
    
    @Override
    public void delete(FoodField foodField) {
        System.out.println("Posion clickeado, disminuyendo puntaje");
        foodField.getPlayer().disminuirPuntaje();
        foodField.eliminarElement(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(posionImage, x, y, null);
    }
}

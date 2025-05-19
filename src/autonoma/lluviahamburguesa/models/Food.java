package autonoma.lluviahamburguesa.models;

import autonoma.lluviahamburguesas.sounds.ReproducirSonido;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author marti
 */
public class Food extends ElementType {

    private Image hamburguerImage;
    private ReproducirSonido soundPlayer = new ReproducirSonido();

    public Food(int x, int y, int height, int width) {
        super(x, y, height, width);
        hamburguerImage = new ImageIcon(getClass().getResource("/autonoma/lluviahamburguesa/images/hamburguer.png")).getImage();
        setStep(2);
    }

    public void registerHit(FoodField foodField) {
        delete(foodField);
    }

    @Override
    public void delete(FoodField foodField) {
        System.out.println("Food clickeado, aumentando puntaje");
        foodField.getPlayer().aumentarPuntaje(1);
        foodField.eliminarElement(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(hamburguerImage, x, y, width, height, null);
    }

    public void playEatSound() {
        ReproducirSonido.playSound("/autonoma/lluviahamburguesas/sounds/sonidoPoint.wav");
    }
}

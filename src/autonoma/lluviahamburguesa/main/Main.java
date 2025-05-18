package autonoma.lluviahamburguesa.main;

import autonoma.lluviahamburguesa.models.FoodField;
import autonoma.lluviahamburguesa.models.Player;
import autonoma.lluviahamburguesa.models.RefreshProgram;
import autonoma.lluviahamburguesa.views.GameWindow;
/**
 *La clase main, crea y muestra la ventana.
 * @author marti
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player(0, 0, 50, 50);
        FoodField foodField = new FoodField(0, 0, 500, 500);
        foodField.setPlayer(player);
        GameWindow window = new GameWindow(foodField);
        window.setFoodField(foodField);
        foodField.setGraphicContainer(window);
        window.setSize(500, 500);
        window.setTitle("Come  o muere ");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        RefreshProgram gameLoop = new RefreshProgram(foodField, window);
        gameLoop.start();
    }
}

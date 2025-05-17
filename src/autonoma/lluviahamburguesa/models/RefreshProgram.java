/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.lluviahamburguesa.models;

import autonoma.lluviahamburguesa.views.GameWindow;

/**
 *
 * @author Valerie Moreno
 * @version 1.0.0
 * @since 5/17/2025
 */
public class RefreshProgram implements Runnable{
    private FoodField foodField;
    private GameWindow gameWindow;
    private boolean running;
    private Thread thread;
    /**
     * Constructor
     */
    public RefreshProgram(FoodField foodField, GameWindow gameWindow) {
        this.foodField = foodField;
        this.gameWindow = gameWindow;
        running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            foodField.update();  // mueve los elementos y refresca
            try {
                Thread.sleep(30);  // 30ms como lo planeabas
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }
    
}

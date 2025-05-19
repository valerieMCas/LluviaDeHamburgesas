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
public class FoodSpawner implements Runnable{
    private FoodField foodField;
    private GameWindow gameWindow;

    protected long delay;
    private boolean running;
    private boolean paused;
    protected Thread thread;
    /**
     * Constructor
     */
    public FoodSpawner(FoodField foodField) {
        this.foodField = foodField;
        running = false;
        paused = false;
    }
    /**
    * Método run() que se ejecuta cuando el hilo asociado a FoodSpawner comienza.
    * Este método controla el ciclo de generación de alimentos en el campo de juego.
    * Aca se verifica que en patalla no haya mas de 4 comidas(Hamburguesas)
    */
    @Override
    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep(3000);
                if (!paused) {
                    if (foodField.getFoodCount() < 4) {
                        foodField.addFood();
                    }
                    
                }
            } catch (InterruptedException ex) {

            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        this.running = false;
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause() {
        this.paused = true;
    }

    public void unpause() {
        this.paused = false;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Inicia la ejecución del hilo asociado a esta clase. Este método crea un
     * nuevo hilo y lo inicia, ejecutando la lógica definida en el método Este
     * hilo permite que el proceso se ejecute de manera concurrente sin bloquear
     * el hilo principal de la aplicación, permitiendo realizar tareas en
     * segundo plano o en paralelo.
     */
    public void start() {
        thread = new Thread(this);
        thread.start();
    }
}

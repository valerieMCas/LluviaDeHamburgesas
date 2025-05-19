/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.lluviahamburguesa.models;

/**
 *
 * @author Valerie Moreno
 * @version 1.0.0
 * @since 5/17/2025
 */
public class Player {
    /**
     * Atributos
     */
    /**
     * Atributo del puntaje que tendra el jugador
     */
    private int puntaje;

    /**
     * Constructor
     */
    public Player(int x, int y, int height, int width) {
        this.puntaje = 0;
    }

    /**
     * Metodos de acceso
     */
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    /**
     * Metodo de aumentar el puntaje del jugador
     */
    public void aumentarPuntaje(int score) {
        this.puntaje += score;
        System.out.println("Puntaje actualizado: " + puntaje);
    }
    /**
     * Metodo de disminuir el puntaje del jugador
     */
    public void disminuirPuntaje(){
        this.puntaje -=2;
        if(this.puntaje<0){
            this.setPuntaje(0);
        }
        System.out.println("Puntaje actualizado: " + puntaje);
    }

}

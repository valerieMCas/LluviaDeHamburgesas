package autonoma.lluviahamburguesas.sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Clase utilitaria para reproducir sonidos en formato WAV.
 * Utiliza la API javax.sound.sampled para cargar y reproducir clips de audio.
 */
public class ReproducirSonido {

    /** 
     * Clip estático que almacena el sonido que se está reproduciendo actualmente.
     * Al ser estático, se comparte entre todas las llamadas a playSound.
     */
    private static Clip clip;

    /**
     * Reproduce un archivo de sonido WAV desde la ruta de recursos indicada.
     * Si ya hay un sonido en reproducción, lo detiene antes de iniciar uno nuevo.
     *
     * @param soundFilePath Ruta del archivo de sonido dentro del classpath (ej: "/carpeta/sonido.wav")
     */
    public static void playSound(String soundFilePath) {
        try {
            // Si hay un clip activo y reproduciéndose, detenerlo para evitar solapamiento
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }

            // Cargar el archivo de sonido desde recursos como un stream de audio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ReproducirSonido.class.getResource(soundFilePath));

            // Crear un nuevo clip para reproducir el sonido
            clip = AudioSystem.getClip();

            // Abrir el clip con el audio cargado
            clip.open(audioInputStream);

            // Iniciar la reproducción del clip
            clip.start();
        } catch (Exception ex) {
            // Capturar cualquier error al reproducir el sonido y mostrar mensaje en consola
            System.out.println("Error al reproducir sonido: " + ex.getMessage());
        }
    }
}

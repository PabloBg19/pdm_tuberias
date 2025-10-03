package aleatorio;

import java.util.Random;

/**
 * Clase principal que genera y muestra números aleatorios.
 *
 * @author Pablo Belascoain
 * @version 1.0
 */
public class App {
    /**
     * Método principal que ejecuta el programa.
     * Crea un array de 50 números enteros aleatorios entre 0 y 100
     * y los imprime en la consola separados por espacios.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int [] aleatorio= new int [50];  //se inicializa el array
        Random random = new Random(); //se crea el random

        for (int i = 0; i < aleatorio.length; i++) {   //for para recorrer y llenar el array
            aleatorio[i]= random.nextInt(101);
            System.out.print(aleatorio[i] + " ");
        }


    }
}
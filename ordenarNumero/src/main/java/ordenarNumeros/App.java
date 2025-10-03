package ordenarNumeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Clase principal que lee números desde la entrada estándar,
 * los ordena de forma ascendente y los imprime ordenados.
 *
 * @author Pablo Belascoain
 * @version 1.0
 */
public class App {
    /**
     * Método principal que ejecuta el programa.
     * Lee líneas de entrada desde la consola, extrae los números de cada línea,
     * los ordena usando Arrays.sort() y los imprime en orden ascendente.
     * El proceso continúa hasta que no haya más líneas de entrada.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     * @throws IOException si ocurre un error de entrada/salida durante la lectura
     */
    public static void main(String[] args) throws IOException {
        try{
            // Crear un InputStreamReader para leer desde la entrada estándar (consola)
            InputStreamReader isr = new InputStreamReader(System.in);

            // Envolver el InputStreamReader en un BufferedReader para lectura eficiente
            BufferedReader br = new BufferedReader(isr);

            // Variable para almacenar cada línea leída
            String linea = null;

            // Bucle que continúa mientras haya líneas para leer (hasta que sea null)
            while((linea = br.readLine()) != null){

                // Dividir la línea en caracteres individuales
                // split("") separa cada carácter: "321" -> ["3", "2", "1"]
                String datos[] = linea.trim().split("\\s+");
                int numeros[] = new int[datos.length];

                for(int i = 0; i < numeros.length; i++){
                    numeros[i] = Integer.parseInt(datos[i]);
                }

                Arrays.sort(numeros);

                for(int i = 0; i < numeros.length; i++){
                    System.out.print(numeros[i] + " ");
                }
                System.out.println();

            }

        } catch(Exception e){
            // Capturar cualquier excepción que ocurra durante la ejecución
            // Imprimir el error en consola
            System.out.println(e);
        }
    }
}
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ordenamiento {
    private static final Logger logger = LogManager.getLogger();

    public static void seleccionarArchivo(JTextArea textareaA, JTextArea textareaE, JTextArea textareaI, JTextArea textareaO, JTextArea textareaU, Ventana ventana) {

        /*
            Abre un buscador de archivos
            y se lee el archivo seleccionado
            con un BufferedReader para poder guardarlo
            en una variable usando el readLine
        */

        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null); // Abre el buscador de archivos
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            BufferedReader lectorDelArchivo = null;
            try {
                lectorDelArchivo = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = lectorDelArchivo.readLine()) != null) {

                    logger.info("Obteniendo lineas del Archivo");

                    textareaA.append(linea += "\n");
                    textareaE.append(linea += "\n");
                    textareaI.append(linea += "\n");
                    textareaO.append(linea += "\n");
                    textareaU.append(linea += "\n");
                }

                logger.info("Archivo leido correctamente");
                
            } catch (IOException e) {

                // Obtiene cualquier error de lectura del archivo

                logger.error("Error al leer el archivo", e);
            }
        }
    }

    public static void ordenarTextAreas(JTextArea textareaA, JTextArea textareaE, JTextArea textareaI, JTextArea textareaO, JTextArea textareaU, Ventana ventana) {

        String textoDelArchivo = textareaA.getText();

        ///////////////////separa por palabras/////////////////////////
        String[] palabras = textoDelArchivo.split("\\s+");



         /*
             Crea un array de tamaño 5 que
             contiene 5 arrays vacios en cada espacio
             para guardar los textAreas como arrays
         */

        ArrayList[] palabrasFiltradas = new ArrayList[5];
        for (int i = 0; i < palabrasFiltradas.length; i++) {
            palabrasFiltradas[i] = new ArrayList<>();
        }



        /*
            Compara la primera letra de cada palabra y
            si son iguales las mete en el array para separar
            las palabras que empiezan con la misma vocal
        */

        char[] vocales = {'A', 'E', 'I', 'O', 'U'};

        for (String palabra : palabras) {
            char primeraLetra = palabra.toUpperCase().charAt(0);
            for (int i = 0; i < vocales.length; i++) {
                if (primeraLetra == vocales[i]) {
                    palabrasFiltradas[i].add(palabra);
                    break;
                }
            }
        }



        /*
            ordenamos las palabras que ya fueron separadas
             por vocales usando el metodo "ordenarLista"
        */

        // Ordenamos alfabéticamente cada ArrayList
        for (ArrayList palabrasPorVocal : palabrasFiltradas) {
            ordenarLista(palabrasPorVocal);
        }



        /*
            actualiza los textAreas para mostrarlo
             en pantalla usando el metodo "actualizarTextAreas"
        */
        actualizarTextAreas(palabrasFiltradas, textareaA, textareaE, textareaI, textareaO, textareaU);

    }



    /*
        Método para ordenar alfabéticamente

        este metodo compara las palabras usando el metodo "compareToIgnoreCase"
        que compara 2 palabras y devuelve un valor positivo si la primera es
        mayor a la segunda palabra, si es menor, devuelve un valor negativo
    */


    private static void ordenarLista(ArrayList<String> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).compareToIgnoreCase(lista.get(j + 1)) > 0) {

                    // Intercambia las palabras si están en el orden incorrecto
                    // usando variables temporales

                    String temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

            /*
                Metodo para actualizar el valor de los textAreas
                y mostrarlos en la ventana
            */
    private static void actualizarTextAreas(ArrayList<String>[] palabrasFiltradas, JTextArea textareaA, JTextArea textareaE, JTextArea textareaI, JTextArea textareaO, JTextArea textareaU) {
        for (int i = 0; i < palabrasFiltradas.length; i++) {
            StringBuilder texto = new StringBuilder();
            for (String palabra : palabrasFiltradas[i]) {
                texto.append(palabra).append("\n");
            }
            switch (i) {
                case 0:
                    textareaA.setText(texto.toString());
                    break;
                case 1:
                    textareaE.setText(texto.toString());
                    break;
                case 2:
                    textareaI.setText(texto.toString());
                    break;
                case 3:
                    textareaO.setText(texto.toString());
                    break;
                case 4:
                    textareaU.setText(texto.toString());
                    break;
            }

            logger.info("Palabras del archivo ordenadas");

        }
    }
}
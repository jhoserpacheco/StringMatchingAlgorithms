package util;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Clase que permita leer un archivo de texto plano desde una URL
 */


public class ArchivoURL {

    //Almacena la dirección URL del archivo
    private String direccion;

    /**
     * Permite crear un objeto de tipo ArchivoLeerURL especificando su URL
     *
     * @param direccion la URL donde está el archivo
     */
    public ArchivoURL(String direccion) {
        this.direccion = direccion;
    }

    public ArchivoURL() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que retorna el archivo en un vector de Object. Cada línea se
     * almacena secuencialmente en cada posición del vector
     *
     * @return un vector con el archivo almacenado en la URL
     */
    public Object[] leerArchivo() {
        ArrayList<String> l = new ArrayList<>();
        try {
            // Indicamos la URL donde nos conectamos
            URL url = new URL(this.getDireccion());
            // Buffer con los datos recibidos
            BufferedReader in = null;

            try {
                // Volcamos lo recibido al buffer
                in = new BufferedReader(new InputStreamReader(
                        url.openStream()));
            } catch (IOException t) {
            }

            // Transformamos el contenido del buffer a texto
            String inputLine;
            String inputText = "";

            // Mientras haya cosas en el buffer las volcamos a las
            // cadenas de texto 
            while ((inputLine = in.readLine()) != null) {
                l.add(inputLine);
            }

            in.close();

        } catch (MalformedURLException ex1) {
            System.out.println("URL erronea: " + ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println("Error IO:" + ex2.getMessage());
        }

        return (l.toArray());

    }
    /*
    public static void main(String[] args) {
        ArchivoURL url = new ArchivoURL("https://gitlab.com/ronaldeduardobm/archivos-laberinto/raw/master/archivos/laberinto1SolucionCorto.csv");
        Object ob[] = url.leerArchivo();
        for (Object ob1 : ob) {
            System.out.println(ob1.toString());
        }
    }
     */
}

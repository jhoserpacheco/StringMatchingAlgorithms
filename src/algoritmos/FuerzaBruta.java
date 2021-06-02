/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author jhoser
 */
public class FuerzaBruta {

    public FuerzaBruta() {
    }

    /**
     *
     * @param cadena
     * @param patron
     *
     */
    public void fuerzaBruta(String cadena, String patron) {
        long start = System.nanoTime();
        int m = patron.length();
        int n = cadena.length();
        int j = 0, contador = 0;
        for (int i = 0; i <= n - m; i++) {
            while (j < m && cadena.charAt(i + j) == patron.charAt(j)) {
                j++;
            }
            if (j == m) {
                System.out.println("Encontrado en: " + i);
                contador++;
            }
            j = 0;
        }
        long end = System.nanoTime();

        System.out.println("Numero total de ocurrencias en Fuerza Bruta: " + contador);
        System.out.println("Tiempo Fuerza Bruta: " + (end - start));
    }
}

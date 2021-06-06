/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Jhoser and Jarlin
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
        double timeMili = (end - start) * 1.0e-6;

        System.out.println("Tiempo de Fuerza Bruta es: " + timeMili + " ms");
    }

//    public void fuerzaBruta2(String cadena, String patron) {
//        long start = System.nanoTime();
//        int contador = 0;
//        int ti, pi, tj;
//        ti = 0;
//        pi = 0;
//        tj = 0;
//        int m = patron.length();
//        int n = cadena.length();
//
//        while (ti < n - m) {
//            if (cadena.charAt(ti) == patron.charAt(0)) {
//                pi = 0;
//                tj = ti;
//                do {
//                    tj++;
//                    pi++;
//                    if (pi == m) {
//                        System.out.println("Ocurrencia en: " + ti);
//                        contador++;
//                        break;
//                    }
//
//                } while (cadena.charAt(tj) == patron.charAt(pi));
//
//            }
//            ti++;
//        }
//
//        long end = System.nanoTime();
//
//        System.out.println("Numero total de ocurrencias en Fuerza Bruta: " + contador);
//        double timeMili = (end - start) * 1.0e-6;
//
//        System.out.println("Tiempo de Fuerza Bruta es: " + timeMili + " ms");
//    }
}

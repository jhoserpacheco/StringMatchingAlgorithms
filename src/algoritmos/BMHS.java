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
public class BMHS {

    public BMHS() {
    }

    public int[] tablaBMHS(String patron) {

        int m = patron.length();
        int maxChar = 99999;
        int bmhsTable[] = new int[maxChar];
        for (int i = 0; i < maxChar; i++) {
            bmhsTable[i] = m + 1;
        }
        for (int i = 0; i < m; i++) {
            bmhsTable[patron.charAt(i)] = m - i;
        }
        return bmhsTable;
    }

    public void BMHS(String cadena, String patron) {
        long start = System.nanoTime();
        int n = cadena.length();
        int m = patron.length();
        int bmhsTable[] = tablaBMHS(patron);

        int i = m - 1;
        int contador = 0;
        while (i < n) {
            int k = i;
            int j = m - 1;
            while (j >= 0 && (cadena.charAt(k) == patron.charAt(j))) {
                j--;
                k--;
            }
            if (j < 0) {
                System.out.println("Encontrado en :  " + (k + 1));
                contador++;
            }
            i = i + bmhsTable[cadena.charAt(i + 1)];
        }
        long end = System.nanoTime();
        double timeMili = (end - start) * 1.0e-6;

        System.out.println("Numero total de ocurrencias en BMHS: " + contador);
        System.out.println("Tiempo de BMHS es: " + timeMili + " ms");
    }

}

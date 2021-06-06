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


    public int[] tablaBMHS(String texto, String patron) {

        int n = texto.length();
        int m = patron.length();
        System.out.println(n);
        int maxChar = 99999;
        int bmhsTable[] = new int[maxChar];
        for (int j = 0; j < maxChar; j++) {
            bmhsTable[j] = m + 1;
        }
        for (int j = 0; j < m; j++) {
            bmhsTable[(int) patron.charAt(j)] = m - j;
        }

        return bmhsTable;
    }

    public void BMHS(String T, String P) {
        long start = System.nanoTime();
        int n = T.length();
        int m = P.length();
        int tablaPreprocesamiento[] = tablaBMHS(T, P);
        
        int i = m - 1;
        int contador = 0;
        while (i < n) { 
            int k = i;
            int j = m - 1;

            while ((j >= 0) && (T.charAt(k) == P.charAt(j))) {
                j--;
                k--;
            }
            if (j < 0) {
                System.out.println("Encontrado en :  " + (k + 1));
                contador++;

            }

            i = i + tablaPreprocesamiento[(int) T.charAt(i + 1)];
        }
        System.out.println("Numero total de ocurrencias en BMHS: " + contador);
        long end = System.nanoTime();
         double timeMili = (end - start)*1.0e-6;
        
        System.out.println("Tiempo de BMHS es: " + timeMili+" ms");
    }

}

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
public class BMH {

    public BMH() {
    }
    

    public int[] tablaBMH(String pattern) {
        int table[];
        table = new int[128];
        int i, j, m;
        char p[] = pattern.toCharArray();
        m = pattern.length();

        for (i = 0; i < 128; i++) {
            table[i] = m;
        }
        for (j = 0; j < m - 1; j++) {
            table[p[j]] = m - 1 - j;
        }
        return table;
    }

    public void BMH(String cadena, String patron) {
        long start = System.nanoTime();
        int i, k, m;
        char T[] = cadena.toCharArray();
        char P[] = patron.toCharArray();
        m = patron.length();
        i = m - 1;
        int table[] = tablaBMH(patron);
        while (i < cadena.length()) {
            k = 0;
            while ((k < m) && (P[m - 1 - k] == T[i - k])) {
                k++;
            }
            if (k == m) {
                System.out.println("Encontrado en: " + (i - m + 1)); // position of the pattern founded
                i++;
            } else {
                i += table[T[i]];
            }
        }

        long end = System.nanoTime();
        System.out.println("Tiempo BMH: " + (end - start));
    }
}

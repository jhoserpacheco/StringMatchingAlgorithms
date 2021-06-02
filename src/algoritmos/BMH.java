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

    public int[] tablaBMH(char[] patron) {
        int bmhTable[];
        bmhTable = new int[256];
        int m = patron.length;
        for (int i = 0; i < 256; i++) {
            bmhTable[i] = m;
        }
        for (int j = 0; j < m - 1; j++) {
            bmhTable[patron[j]] = m - 1 - j;
        }
        return bmhTable;
    }

    public void BMH(String cadena, String patron) {
        long start = System.nanoTime();
        int i, k, m, n;
        n = cadena.length();
        m = patron.length();
        i = m - 1;
        int table[] = tablaBMH(patron.toCharArray());
        while (i < n) {
            k = 0;
            while ((k < m) && (patron.charAt(m - 1 - k) == cadena.charAt(i - k))) {
                k++;
            }
            if (k == m) {
                System.out.println("Encontrado en: " + (i - m + 1)); // position of the pattern founded
                i++;
            } else {
                i += table[cadena.charAt(i)];
            }
        }

        long end = System.nanoTime();
        System.out.println("Tiempo BMH: " + (end - start));
    }
}

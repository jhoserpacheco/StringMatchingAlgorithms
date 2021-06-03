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
        int m = patron.length;
        int bmhTable[] = new int[256];
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
        int count = 0;
        int[] table = tablaBMH(patron.toCharArray());
        int m = patron.length();
        int n = cadena.length();
        int i = m - 1;
        while (i < n) {
            int k = 0;
            while (k < m) {
                if (patron.charAt(m - 1 - k) == cadena.charAt(i - k)) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == m) {
                System.out.println("Encontrado en : " + (i - m + 1));
                count++;
                i++;
            } else {
                i += table[cadena.charAt(i)];
            }
        }
        System.out.println("Numero total de ocurrencias en BMH: " + count);
        long end = System.nanoTime();
        System.out.println("Tiempo BMH: " + (end - start));
    }
}

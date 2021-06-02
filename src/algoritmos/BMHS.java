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
public class BMHS {

    public BMHS() {
    }

    public int[] tablaBMHS(char[] patron) {
        int m = patron.length;
        int[] bmhsTable = new int[256]; // Number of characters

        for (int i = 0; i < bmhsTable.length; ++i) {
            bmhsTable[i] = m + 1;
        }

        for (int i = 0; i < m; i++) {
            bmhsTable[patron[i]] = m - i;
        }
        return bmhsTable;
    }

    public void BMHS(String cadena, String patron) {
        long start = System.nanoTime();
        int[] tab = tablaBMHS(patron.toCharArray());
        int i = 0, j = 0;
        while (j < patron.length() && i < cadena.length()) {
            while (j < patron.length() && i + j < cadena.length() && cadena.charAt(i + j) == patron.charAt(j)) {
                ++j;
            }
            // Match success
            if (j == patron.length()) {
                System.out.println("Encontrado en: " + i);
                i++;
                j = 0;
            }
            if (i + patron.length() > cadena.length() - 1) {
                break;
            }
            i += tab[cadena.charAt(i + patron.length())];

        }
        long end = System.nanoTime();
        System.out.println("Tiempo BMHS: " + (end - start));

    }
}

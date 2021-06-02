package test;

import util.ArchivoTXT;
import algoritmos.*;

public class Main {

    /*static int[] tablaLPS(char[] patron) {
        int n = patron.length;
        int lps[] = new int[n];
        lps[0] = 0;
        for (int i = 1, j = 0; i < n; i++) {
            while (j == 1 && patron[i] != patron[j]) {
                j = lps[j - 1];
            }
            if (patron[i] == patron[j]) {
                j++;
                lps[i] = j;
            }
            lps[i] = j;
        }
        return lps;
    }

    static void KMP(String cadena, String patron) {
        long start = System.nanoTime();
        int n = cadena.length();
        int m = patron.length();
        int tab[] = tablaLPS(patron.toCharArray());
        for (int i = 0, rep = 0; i < n; i++) {
            while (rep > 0 && cadena.charAt(i) != patron.charAt(rep)) {
                rep = tab[(rep - 1)];
            }
            if (cadena.charAt(i) == patron.charAt(rep)) {
                rep++;
            }
            if (rep == m) {
                System.out.println("Encontrado en: " + (i - rep + 1));
                rep = tab[(rep - 1)];
            }
        }
        long end = System.nanoTime();
        System.out.println("Tiempo KMP: " + (end - start));
    }

    static int[] tablaBMH(String pattern) {
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

    static void BMH(String cadena, String patron) {
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

    static int[] tablaBMH2(char[] patron) {//metodo 2
        int m = patron.length;
        int bmhTable[] = new int[256];
        bmhTable[m] = m;
        for (int i = 0; i < 256; i++) { //256 hace referencia a la tabla ascii 
            bmhTable[i] = m;
        }
        for (int i = 0; i < patron.length; i++) {
            if (m - i - 1 != 0) {
                bmhTable[patron[i]] = m - i - 1;
            } else {
                bmhTable[patron[i]] = Math.min(m, bmhTable[patron[i]]);
            }
        }
        return bmhTable;
    }

    static void BMH2(String cadena, String patron) {
        long start = System.nanoTime();
        int n = cadena.length();
        int m = patron.length();
        int tab[] = tablaBMH2(patron.toCharArray());
        int k, j, rep = 0;
        for (int i = m - 1; i < n; i += tab[cadena.charAt(i)]) {
            k = i - 1;
            for (j = m - 1; j >= 0 && cadena.charAt(k) == patron.charAt(j); j--) {
                k--;
                rep++;
            }
            if (rep == m) {
                System.out.println("Encontrado: " + (k + 1));
            }
            rep = 0;
        }
        long end = System.nanoTime();
        System.out.println("Tiempo BMH: " + (end - start));
    }

    static int[] tablaBMHS(char[] patron) {
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

    static void BMHS(String cadena, String patron) {
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

    static void fuerzaBruta(String cadena, String patron) {
        long start = System.nanoTime();
        int m = patron.length();
        int n = cadena.length();
        int j = 0;
        for (int i = 0; i <= n - m; i++) {
            while (j < m && cadena.charAt(i + j) == patron.charAt(j)) {
                j++;
            }
            if (j == m) {
                System.out.println("Encontrado en: " + i);
            }
            j = 0;
        }
        long end = System.nanoTime();
        System.out.println("Tiempo Fuerza Bruta: " + (end - start));
    }
     */
    public static void main(String[] args) {
        BMH bmh = new BMH();
        BMHS bmhs = new BMHS();
        KMP kmp = new KMP();
        FuerzaBruta fuerza = new FuerzaBruta();
        ArchivoTXT txt = new ArchivoTXT("C:/Users/jhose/OneDrive/Escritorio/expo.txt", "\n");
        String str[][] = txt.leerTodo();
        for (String[] str1 : str) {
            for (String str2 : str1) {
                System.out.println(str2);
            }
        }

        int i = 0, j = 0, k = 1;
        while (i < str.length) {
            String cadena = str[j][0];
            String patron = str[k][0];

            System.out.println("\n*** PRUEBAS #" + (i + 1) + " ***\n");

            System.out.println("\tBMH");
            bmh.BMH(cadena, patron);

            System.out.println("\n\tBMHS");
            bmhs.BMHS(cadena, patron);

            System.out.println("\n\tKMP");
            kmp.KMP(cadena, patron);

            System.out.println("\n\tFUERZA BRUTA");
            fuerza.fuerzaBruta(cadena, patron);

            j += 3;
            k += 3;
            i++;

            if (i > str.length || k > str.length || j > str.length) {
                break;
            }
        }

    }

}

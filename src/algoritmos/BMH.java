package algoritmos;

/**
 *
 * @author Jhoser and Jarlin
 */
public class BMH {

    public BMH() {
    }

    public int[] tablaBMH(String texto, String patron) {

        int n = texto.length();
        int m = patron.length();
        System.out.println(n);
        int maxChar = 99999;
        int bmhTable[] = new int[maxChar];
        for (int j = 0; j < maxChar; j++) {
            bmhTable[j] = m;
        }
        for (int j = 0; j < (m - 1); j++) {
            bmhTable[(int) patron.charAt(j)] = m - j - 1;
        }

        return bmhTable;
    }

    public void BMH(String T, String P) {
        long start = System.nanoTime();
        int count = 0;
        int n = T.length();
        int m = P.length();
        int tablaPreprocesamiento[] = tablaBMH(T, P);
        int i = m - 1;
        while (i < n) {
            int k = i;
            int j = m - 1;
            while ((j >= 0) && (T.charAt(k) == P.charAt(j))) {
                j--;
                k--;
            }
            if (j < 0) {
                System.out.println("Encontrado en: " + (k + 1));
                count++;
            }
            i = i + tablaPreprocesamiento[(int) T.charAt(i)];
        }
        System.out.println("Numero total de ocurrencias en BMH: " + count);
        long end = System.nanoTime();
        double timeMili = (end - start) * 1.0e-6;

        System.out.println("Tiempo de BMH es: " + timeMili + " ms");
    }

}

package algoritmos;

/**
 *
 * @author Jhoser and Jarlin
 */
public class BMH {

    public BMH() {
    }

    public int[] tablaBMH(char[] patron) {

        int m = patron.length;
        int maxChar = 99999;
        int bmhTable[] = new int[maxChar];
        for (int i = 0; i < maxChar; i++) {
            bmhTable[i] = m;
        }
        for (int i = 0; i < m - 1; i++) {
            bmhTable[patron[i]] = m - i - 1;
        }

        return bmhTable;
    }

    public void BMH(String cadena, String patron) {
        long start = System.nanoTime();
        int count = 0;
        int n = cadena.length();
        int m = patron.length();
        char []cadenaC= cadena.toCharArray();
        char []patronC= patron.toCharArray();
        int bmhtable[] = tablaBMH(patron.toCharArray());
        int i = m - 1;
        while (i < n) {
            int k = i;
            int j = m - 1;
            while (j >= 0 && (cadenaC[k]== patronC[j])) {
                j--;
                k--;
            }
            if (j < 0) {
                System.out.println("Encontrado en: " + (k + 1));
                count++;
            }
            i = i + bmhtable[cadenaC[i]];
        }
        long end = System.nanoTime();
        double timeMili = (end - start) * 1.0e-6;
        System.out.println("Numero total de ocurrencias en BMH: " + count);
        System.out.println("Tiempo de BMH es: " + timeMili + " ms");
    }

}

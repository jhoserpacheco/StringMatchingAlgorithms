package test;

import util.ArchivoTXT;
import algoritmos.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BMH bmh = new BMH();
        BMHS bmhs = new BMHS();
        KMP kmp = new KMP();
        FuerzaBruta fuerza = new FuerzaBruta();
        ArchivoTXT txt = new ArchivoTXT("C:/Users/jhose/OneDrive/Escritorio/prueba.txt", "\n");
        String str[][] = txt.leerTodo();
        String cadena = "";
        for (String[] str1 : str) {
            for (String str2 : str1) {
                cadena += str2;
            }
            cadena += "\n";
        }

        int i = 0, j = 0, k = 1;
        while (i < str.length) {
            System.out.println(cadena);
            String patron = sc.nextLine();

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

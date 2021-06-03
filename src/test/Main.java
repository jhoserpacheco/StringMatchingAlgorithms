package test;

import util.*;
import algoritmos.*;
import java.util.*;

public class Main {

    public static String lecturaTxtLocal(String rutaLocal) {
        ArchivoTXT txt = new ArchivoTXT(rutaLocal, "\n");
        String str[][] = txt.leerTodo();
        String cadena = "";
        for (String[] str1 : str) {
            for (String str2 : str1) {
                cadena += str2;
            }
            cadena += "\n";
        }
        return cadena;
    }

    public static String lecturaTxtRemoto(String url) {
        String cadena = "";
        ArchivoURL txt = new ArchivoURL(url);
        cadena += (Arrays.toString(txt.leerArchivo()));
        return cadena;
    }

    public static void elegirAlgortimo(int n, String cadena, String patron) {
        BMH bmh = new BMH();
        BMHS bmhs = new BMHS();
        KMP kmp = new KMP();
        FuerzaBruta fuerza = new FuerzaBruta();
        if (n == 1) {
            kmp.KMP(cadena, patron);
        } else if (n == 2) {
            bmh.BMH(cadena, patron);
        } else if (n == 3) {
            bmhs.BMHS(cadena, patron);
        } else if (n == 4) {
            fuerza.fuerzaBruta(cadena, patron);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        System.out.println("******************************************\n* BIENVENIDO A LA 3RA NOTA DE ALGORITMOS *\n******************************************");

        while (true) {
            System.out.println("¿La lectura del archivo de txt es local o remota? Digite 0 o 1:\n  Local: 1\n  Remoto: 0");
            int lectura = sc.nextInt();
            if (lectura == 1) {
                cadena = lecturaTxtLocal("././test/prueba.txt");
            } else {
                cadena = lecturaTxtRemoto("https://raw.githubusercontent.com/jhoserpacheco/StringMatchingAlgorithms/main/test/prueba.txt");
            }
            System.out.println("Elija el algoritmo para realizar la busqueda en el texto: \n  KMP: 1\n  BMH: 2\n  BMHS: 3\n  FUERZA BRUTA: 4");
            int algoritmo = sc.nextInt();
            System.out.println("Digite el patron a buscar en el texto: ");
            sc.nextLine();
            String patron = sc.nextLine();
            elegirAlgortimo(algoritmo, cadena, patron);
            System.out.println("¿Desea seguir buscando patrones en el texto?\n  Si: 0\n  No: 1");
            int seguir = sc.nextInt();
            if (seguir == 0) {
                sc.nextLine();
                while (true) {
                    System.out.println("Digite el nuevo patron");
                    patron = sc.nextLine();
                    elegirAlgortimo(algoritmo, cadena, patron);
                    System.out.println("Salir de la busqueda de patrones digite \"salir\" o digite cualquier letra para continuar");
                    String salir = sc.next();
                    if (salir.equals("salir")) {
                        break;
                    }
                    System.out.println("Digite el nuevo patron");
                    sc.nextLine();
                }
            } else {
                System.out.println("***************\n* FINALIZADO. *\n***************");
            }
        }

    }

}

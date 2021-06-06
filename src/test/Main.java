package test;

import util.*;
import algoritmos.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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

        while (true) {
            System.out.println("**********************************************************************************************************************************************\n*                                               BIENVENIDO A LA 3RA NOTA DE ANALISIS ALGORITMOS                                              *\n**********************************************************************************************************************************************");
            System.out.println("");
            int validar = 0;

            System.out.println("¿La lectura del archivo de txt es local o remota? Digite 0 o 1:\n  Local: 1\n  Remoto: 0");
            JFileChooser fileChooser = new JFileChooser();
            StringBuilder data = new StringBuilder();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos txt(.txt)", "txt");
            //Se le asigna al JFileChooser el filtro
            fileChooser.setFileFilter(filtro);

            int lectura = sc.nextInt();
            if (lectura == 1) {
                //se muestra la ventana
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        if (file.getName().endsWith(".txt")) {
                            Scanner reader = new Scanner(file);
                            while (reader.hasNextLine()) {
                                data.append(reader.nextLine());
                                data.append("\n");
                            }
                            reader.close();

                        } else {
                            JOptionPane.showMessageDialog(null, "No has seleccionado un archivo .txt, porfavor vuelva a leer el archivo");
                            validar = 5;
                            System.out.println("**********************************************************************************************************************************************\n*                                                                   FINALIZADO.                                                              *\n**********************************************************************************************************************************************");
                            System.out.println("");
                            sc.nextLine();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo, porfavor vuelva a leer el archivo");
                    validar = 5;
                    System.out.println("**********************************************************************************************************************************************\n*                                                                   FINALIZADO.                                                              *\n**********************************************************************************************************************************************");
                    System.out.println("");
                    sc.nextLine();
                }

                cadena = data.toString();
            } else {
                cadena = lecturaTxtRemoto("https://raw.githubusercontent.com/jhoserpacheco/StringMatchingAlgorithms/main/test/prueba.txt");
            }

            if (validar != 5) {
                String seguir;
                String patron;
                int algoritmo;
                do {

                    System.out.println("Elija el algoritmo para realizar la busqueda en el texto: \n  KMP: 1\n  BMH: 2\n  BMHS: 3\n  FUERZA BRUTA: 4");
                    algoritmo = sc.nextInt();
                    do {
                        System.out.println("Digite el patron a buscar en el texto: ");
                        sc.nextLine();
                        patron = sc.nextLine();
                        elegirAlgortimo(algoritmo, cadena, patron);
                        do {
                            System.out.println("¿Desea seguir buscando patrones en el text, salir o cambiar de algoritmo?\n  Si: 1\n  No(Salir y Leer nuevo archivo): 0\n  Cambiar algoritmo: 2");

                            seguir = sc.next();

                            if (seguir.equals("1") || seguir.equals("2") || seguir.equals("0")) {

                            } else {
                                System.out.println("Porfavor escoja las 3 opciones dadas");
                                seguir = "3";
                            }
                        } while (seguir.equals("3"));
                    } while (seguir.equals("1"));

                } while (seguir.equals("2"));

                if (seguir.equals("0")) {
                    System.out.println("**********************************************************************************************************************************************\n*                                                                   FINALIZADO.                                                              *\n**********************************************************************************************************************************************");
                    System.out.println("");
                }

            }
        }

    }
}

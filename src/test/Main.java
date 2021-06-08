package test;

import util.*;
import algoritmos.*;
import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

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
        switch (n) {
            case 1:
                kmp.KMP(cadena, patron);
                break;
            case 2:
                bmh.BMH(cadena, patron);
                break;
            case 3:
                bmhs.BMHS(cadena, patron);
                break;
            case 4:
                fuerza.fuerzaBruta(cadena, patron);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena, patron;
        short seguir;
        int algoritmo;
        String finalizado = "**********************************************************************************************************************************************\n*                                                                   FINALIZADO.                                                              *\n**********************************************************************************************************************************************";
        while (true) {
            System.out.println("**********************************************************************************************************************************************\n*                                               BIENVENIDO A LA 3RA NOTA DE ANALISIS ALGORITMOS                                              *\n**********************************************************************************************************************************************\n");
            boolean validar = true;
            /*
            LECTURA DE ARCHIVO DE TEXTO DESDE MAQUINA LOCAL 
             */
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
                            try (Scanner reader = new Scanner(file)) {
                                while (reader.hasNextLine()) {
                                    data.append(reader.nextLine());
                                    data.append("\n");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No has seleccionado un archivo .txt, porfavor vuelva a leer el archivo");
                            validar = false;
                            System.out.println(finalizado + "\n");
                            sc.nextLine();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo, porfavor vuelva a leer el archivo");
                    validar = false;
                    System.out.println(finalizado + "\n");
                    sc.nextLine();
                }
                cadena = data.toString();
            } else { //LECTURA DE TEXTO DESDE UNA URL
                cadena = lecturaTxtRemoto("https://raw.githubusercontent.com/jhoserpacheco/StringMatchingAlgorithms/main/test/Prueba%203.txt");
            }
            if (validar) {
                do {
                    System.out.println("Elija el algoritmo para realizar la busqueda en el texto: \n  KMP: 1\n  BMH: 2\n  BMHS: 3\n  FUERZA BRUTA: 4");
                    algoritmo = sc.nextInt();
                    do {
                        System.out.println("Digite el patron a buscar en el texto: ");
                        sc.nextLine();
                        patron = sc.nextLine();
                        elegirAlgortimo(algoritmo, cadena, patron);
                        do {
                            System.out.println("¿Desea seguir buscando patrones en el texto, salir o cambiar de algoritmo?\n  Si: 1\n  Cambiar algoritmo: 2  \n  Salir: 0");
                            seguir = sc.nextShort();
                            if (seguir == 3) {
                                System.out.println("Por favor escoja las 3 opciones dadas");
                                seguir = 3;
                            }
                        } while (seguir == 3);
                    } while (seguir == 1);
                } while (seguir == 2);

                if (seguir == 0) {
                    System.out.println(finalizado + "\n");
                    break;
                }
            }
        }
    }
}

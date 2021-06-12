package test;

import algoritmos.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jhoser and Jarlin
 */

public class Main {

    public static String patron() {
        JFrame frame = new JFrame("Patron");
        final SpringLayout layout = new SpringLayout();
        final JPanel panel = new JPanel(layout);
        panel.setPreferredSize(new Dimension(250, 160));
        JLabel lblAddress = new JLabel("Patron");
        panel.add(lblAddress);
        JTextArea txtAddress = new JTextArea();
        txtAddress.setBorder(BorderFactory.createLineBorder(Color.black));
        txtAddress.setLineWrap(true);
        txtAddress.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtAddress, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(250, 100));
        panel.add(scrollPane);
        layout.putConstraint(SpringLayout.NORTH, scrollPane,
                10,
                SpringLayout.SOUTH, lblAddress);

        int result = JOptionPane.showConfirmDialog(frame, panel,
                "Patron en el texto", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        return txtAddress.getText();
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

    public static String readFileAsString(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String cadena, patron;
        int seguir;
        int algoritmo;
        String finalizado = "**********************************************************************************************************************************************\n*                                                                   FINALIZADO.                                                              *\n**********************************************************************************************************************************************";
        while (true) {
            System.out.println("**********************************************************************************************************************************************\n*                                               BIENVENIDO A LA 3RA NOTA DE ANALISIS ALGORITMOS                                              *\n**********************************************************************************************************************************************\n");
            boolean validar = true;
            /*
            LECTURA DE ARCHIVO DE TEXTO DESDE MAQUINA LOCAL 
             */

            JFileChooser fileChooser = new JFileChooser();
            StringBuilder data = new StringBuilder();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos txt(.txt)", "txt");
            //Se le asigna al JFileChooser el filtro
            fileChooser.setFileFilter(filtro);

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
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo, porfavor vuelva a leer el archivo");
                validar = false;
                System.out.println(finalizado + "\n");
            }
            cadena = data.toString();
            if (validar) {
                do {
                    System.out.println("Elija el algoritmo para realizar la busqueda en el texto: \n  KMP: 1\n  BMH: 2\n  BMHS: 3\n  FUERZA BRUTA: 4");
                    algoritmo = sc.nextInt();
                    do {
                        System.out.println("Digite el patron a buscar en el texto: ");

                        patron = patron();
                        elegirAlgortimo(algoritmo, cadena, patron);
                        do {
                            System.out.println("¿Desea seguir buscando patrones en el texto, salir o cambiar de algoritmo?\n  Si: 1\n  Cambiar algoritmo: 2  \n  Salir: 0");
                            seguir = sc.nextInt();
                            if (seguir == 3) {
                                System.out.println("Por favor escoja las 3 opciones dadas");
                                seguir = 3;
                            }
                        } while (seguir == 3);
                    } while (seguir == 1);
                } while (seguir == 2);

                if (seguir == 0) {
                    System.out.println(finalizado + "\n");
                    System.exit(0);
                    break;
                }
            }
        }

    }
}

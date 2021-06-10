package test;

import algoritmos.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

    public static String cadena() {
        String cadena;
        JFileChooser fileChooser = new JFileChooser();
        StringBuilder data = new StringBuilder();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos txt(.txt)", "txt");
        fileChooser.setFileFilter(filtro);
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
                }
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo, porfavor vuelva a leer el archivo");
        }
        cadena = data.toString();
        return cadena;
    }

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
        String cadena = cadena();
        String patron = patron();
        for (int i = 1; i < 5; i++) {
            elegirAlgortimo(i, cadena, patron);
        }
        System.exit(0);
    }
}

package util;

import java.io.*;
import java.util.*;

public class ArchivoTXT {

    private String filename;
    private BufferedReader reader;
    private String delimitador;

    public ArchivoTXT(String filename) //throws IOException
    {
        this.filename = filename;
        try {
            this.reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            System.err.print(e.toString());
        }

    }

    public ArchivoTXT(String filename, String delimitador) //throws IOException
    {
        this.filename = filename;
        this.delimitador = delimitador;
        try {
            this.reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            System.err.print(e.toString());
        }

    }

    public String readLine() //throws IOException
    {

        try {
            return (this.reader.readLine());
        } catch (IOException e) {
            System.err.print(e.toString());
        }
        return null;
    }

    public void close() //throws IOException
    {

        try {
            this.reader.close();
        } catch (IOException e) {
            System.err.print(e.toString());
        }
    }

    public String[][] leerTodo() //throws IOException
    {

        String Linea = this.readLine();
        ArrayList<ArrayList<String>> r = new ArrayList<>();
        while (Linea != null) {
            String[] v = Linea.split(this.delimitador);
            ArrayList<String> p = new ArrayList<>();
            p.addAll(Arrays.asList(v)); //   System.out.print(dato + "-");

            r.add(p);
            Linea = this.readLine();
        }

        String matrix[][] = new String[r.size()][];
        int i = 0;
        for (ArrayList<String> v : r) {

            matrix[i] = new String[v.size()];
            int j = 0;
            for (String dato : v) {
                matrix[i][j++] = dato;
            }
            i++;

        }
        this.close();
        return matrix;
    }

}

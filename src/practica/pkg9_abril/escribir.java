/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg9_abril;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Escuela
 */
public class escribir {

    private FileWriter fileWriter = null;
    private PrintWriter printWriter = null;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void abrirArchivo() {
        Calendar c = new GregorianCalendar();

        String dia, mes, annio;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        int MES = Integer.parseInt(mes);
        MES = MES + 1;
        File archivo;
        try {
            archivo = new File("Datos_" + dia + "-" + MES + "-" + annio + ".html");
            if (archivo.createNewFile()) {
                System.out.println("se a creado el archivo");
            }
        } catch (IOException e) {
            System.err.println("no se pudo crear el archivo ");
        }

    }

    public void archivo(String contenido) throws IOException {
        Scanner entrada = new Scanner(System.in);
        BufferedWriter bw = null;
        FileWriter escribir;
        PrintWriter linea;
        Calendar c = new GregorianCalendar();

        String dia, mes, annio;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        int MES = Integer.parseInt(mes);
        MES = MES + 1;
        try {
            escribir = new FileWriter("Datos_" + dia + "-" + MES + "-" + annio + ".html", true);
            linea = new PrintWriter(escribir);
            linea.println(contenido);
            linea.close();
            escribir.close();
        } catch (Exception err) {

        }

    }

    public void cerrarArchivo() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("Datoshtml");
        pw.close();
    }
}

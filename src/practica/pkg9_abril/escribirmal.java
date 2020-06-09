/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg9_abril;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Escuela
 */
public class escribirmal {

    private Formatter salida;

    public void abrirArchivo() {
        Calendar c = new GregorianCalendar();

        String dia, mes, annio;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        int MES = Integer.parseInt(mes);
        MES = MES + 1;
        try {
            salida = new Formatter("url_" + dia + "-" + MES + "-" + annio + ".html"); // abre el archivo
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1); // termina el programa
        } // fin de catch
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir o crear el archivo.");
            System.exit(1); // termina el programa
        } // fin de catch
    } // fin del método abrirArchivo

    public void agregarRegistros(String datos) {
        try {
            salida.format("%s \r\n", datos);
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("}Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("}Entrada invalida. Intente de nuevo.");

        }

    }

    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }

}

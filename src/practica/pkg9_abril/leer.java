/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg9_abril;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Escuela
 */
public class leer {

    escribir datos = new escribir();
     escribirmal d=new escribirmal();
    public void leer_url() {
        try {
            // Indicamos la URL donde nos conectamos
            URL url = new URL("http://salud.edomex.gob.mx/salud/covid19_municipio");

            // Buffer con los datos recibidos
            BufferedReader in = null;

            try {
                // Volcamos lo recibido al buffer
                in = new BufferedReader(new InputStreamReader(
                        url.openStream()));
            } catch (Throwable t) {
            }

            // Transformamos el contenido del buffer a texto
            String inputLine;
            String inputText = "";

            // Mientras haya cosas en el buffer las volcamos a las
            // cadenas de texto 
            while ((inputLine = in.readLine()) != null) {
                inputText = inputText + inputLine + "\n";
                //datos.abrirArchivo();
                //datos.archivo(inputLine);
                //datos.cerrarArchivo();
                d.abrirArchivo();
                d.agregarRegistros(inputText);
                d.cerrarArchivo();
            }

            // Mostramos el contenido y cerramos la entrada
            //System.out.println("El contenido de la URL es: " + inputText);
            in.close();

        } catch (MalformedURLException me) {
            System.out.println("URL erronea");
        } catch (IOException ioe) {
            System.out.println("Error IO");
        }
    }
}

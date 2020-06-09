/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg9_abril;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class buscar {

    public void solicitud() {
        Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);

        //Para seleccionar el archivo
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe el dia: ");
        String dia = teclado.nextLine();
        System.out.print("Escribe el mes: ");
        String mes = teclado.nextLine();
        System.out.print("Escribe el año: ");
        String ano = teclado.nextLine();
        File f = new File("url_" + dia + "-" + mes + "-" + ano + ".html");
        if (f.exists()) {
            System.out.print("El erchivo en el que ba a buscar es el siguiente: url_" + dia + "-" + mes + "-" + ano + ".html\n");
            //Introducimos el texto a buscar
            System.out.print("Introduce texto a buscar: ");
            String texto = sc.nextLine();

            try {
                entrada = new Scanner(f);

                while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                    linea = entrada.nextLine();  //se lee una línea
                    if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                        System.out.println(linea);
                        FileInputStream fs = new FileInputStream(f);
                        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                        int n1;
                        n1 = numeroDeLinea;
                        for (int i = 0; i < n1; ++i) {
                            br.readLine();
                        }
                        String lineIWant1 = br.readLine();
                        System.out.print(lineIWant1 + "\n");
                        
                        FileInputStream fc = new FileInputStream(f);
                        BufferedReader bc = new BufferedReader(new InputStreamReader(fc));
                        int n2;
                        n2 = numeroDeLinea+1;
                        for (int i = 0; i < n2; ++i) {
                            bc.readLine();
                        }
                        String lineIWant2 = bc.readLine();
                        System.out.print(lineIWant2 );
                        contiene = true;
                    }
                    numeroDeLinea++; //se incrementa el contador de líneas
                }
                if (!contiene) { //si el archivo no contienen el texto se muestra un mensaje indicándolo

                    System.out.println(texto + " no se ha encontrado en el archivo");
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            } catch (NullPointerException e) {
                System.out.println(e.toString() + "No ha seleccionado ningún archivo");
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
        } else {
            System.out.println("el archivo no existe o esta mal escrito");
        }
    }
}

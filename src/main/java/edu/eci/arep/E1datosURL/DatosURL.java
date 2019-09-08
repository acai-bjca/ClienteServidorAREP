package edu.eci.arep.e1datosURL;

import java.net.MalformedURLException;
import java.net.URL;

public class DatosURL {

    /**
     * Muestra en pantalla los datos de una url
     * @param args Parámetros que recibe la clase principal
     */
    public static void main(String[] args) {
        //Ejercicio 1
        try {
            URL myURL = new URL("https://www.otranasa.gov:6030/moon/imagenes/imagenLuna.jpg?año=2019");

            System.out.println("protocolo =" + myURL.getProtocol());
            System.out.println("autoridad =" + myURL.getAuthority());
            System.out.println("host =" + myURL.getHost());
            System.out.println("puerto =" + myURL.getPort());
            System.out.println("ruta =" + myURL.getPath());
            System.out.println("query =" + myURL.getQuery());
            System.out.println("file =" + myURL.getFile());
            System.out.println("ref =" + myURL.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}

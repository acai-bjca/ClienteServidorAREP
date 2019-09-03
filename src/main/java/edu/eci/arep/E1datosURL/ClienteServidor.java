package edu.eci.arep.E1datosURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class ClienteServidor {

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

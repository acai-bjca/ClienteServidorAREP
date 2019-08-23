/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2137441
 */
public class BrowserApp {

    public static void main(String[] args) {
        //Ejercicio 2
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingrese una url:");
       

        URL url;
        try {
            url = new URL(myObj.nextLine()); // Read user input            
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String urlData;
            urlData = reader.readLine();
            while (reader.readLine() != null) {                
                urlData += urlData;
                System.out.println(urlData);                
                urlData = reader.readLine();
            }
            System.out.println(urlData);
            saveURLData(urlData);

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void saveURLData(String urlData) {
        File archivo = new File("src/main/resources/resultado.htm");
        FileOutputStream writer;
        PrintStream p;
        System.out.println(urlData);
        try{
            if (!archivo.exists()) {
                archivo.createNewFile();
                writer = new FileOutputStream(archivo);
                p = new PrintStream(archivo);
                p.println(urlData);
                p.close();
            } else {
                writer = new FileOutputStream("resultado.htm");
                p = new PrintStream(archivo);
                p.println(urlData);
                p.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(BrowserApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

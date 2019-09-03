/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.E2browser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class BrowserApp {

    public static void main(String[] args) {
        //Ejercicio 2
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingrese una url:");
       

        URL url;
        try {
            url = new URL(myObj.nextLine()); // Read user input            
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String urlData = "";
            String dataLine = "";
            while ((dataLine = reader.readLine()) != null) {
                urlData += dataLine;
                //System.out.println(urlData);   
            }
            System.out.println("Fin main :"+urlData);
            saveURLData(urlData);

        } catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void saveURLData(String urlData) throws IOException {
        System.out.println("Save url data; "+urlData);
        String ruta = "src/main/resources/resultado.html";
        File archivo = new File(ruta);
        BufferedWriter bw; //se encarga de escribir en el archivo
        
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(urlData);
        
        bw.close();        
    }
}

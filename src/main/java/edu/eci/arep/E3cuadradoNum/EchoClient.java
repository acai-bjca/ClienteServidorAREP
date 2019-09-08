package edu.eci.arep.e3cuadradoNum;

import java.io.*;
import java.net.*;

public class EchoClient {

    /**
     * Cliente que envía peticiones al servidor EchoServer.
     * Puede enviar como peticion un numero.
     * @param args Parámetros clase principal
     * @throws IOException Excepcion de entrada y salida
     */
    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host!.");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: localhost.");            
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Ingrese un número:");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

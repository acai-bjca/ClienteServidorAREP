package edu.eci.arep.cCuadradoNum;

import java.io.*;
import java.net.*;

/**
* Cliente que env�a peticiones al servidor EchoServer.
* Puede enviar como peticion un numero.
*/
public class EchoClient {
    
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
        System.out.println("Ingrese un n�mero:");
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

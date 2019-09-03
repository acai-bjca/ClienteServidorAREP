package edu.eci.arep.E4Trigonometry;

import java.net.*;
import java.io.*;

public class TrigonometryClient {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don�t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn�t get I/O for " + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Ingrese un n�mero o una funcion as�: fun:sin");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            String lectura = in.readLine();
            System.out.println("echo: " + lectura);
            if (lectura != null) {
                System.out.println("Ingrese un numero, si desea cambiar de funcion hagalo asi= fun:sin");
            }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

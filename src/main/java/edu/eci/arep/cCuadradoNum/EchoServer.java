package edu.eci.arep.cCuadradoNum;

import java.net.*;
import java.io.*;

/**
* Servidor que recibe peticioens del  cleitne EchoClient.
* Puede recibir un numero, el cual es elevado al cuadrado y devuelto al cliente.
*/
public class EchoServer {
    
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            try {
                int numeroRespuesta = Integer.parseInt(inputLine);
                outputLine = "Respuestas: " + (numeroRespuesta * numeroRespuesta);
            } catch (NumberFormatException e) {
                outputLine = "Respuestas: " + inputLine;
                if (outputLine.equals("Respuestas: Bye.")) break;                
            }
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

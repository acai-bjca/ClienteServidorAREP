package edu.eci.arep.e5multiplesSolicitudes;

import java.net.*;
import java.io.*;

public class HttpServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();         
        } catch (IOException e) {
            System.err.println("Accept failed.");           
        }
        
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        //Muestra la petici�n del cliente.
        String inputLine;
        String outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }   
        }
        
        out.println("HTTP/1.1 200 OK");
        out.println("content-type: text/html");
        out.println();
        out.flush();
        outputLine = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>Title of the document</title>\n" + "</head>" + "<body>" + "My Web Site" + "</body>" + "</html>" + inputLine;
        out.println(outputLine);
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

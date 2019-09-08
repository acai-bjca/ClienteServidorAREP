package edu.eci.arep.dTrigonometry;

import java.net.*;
import java.io.*;

/**
 * Servidor que responde a peticiones del cliente TrigonometryClient. Cómo
 * respuesta enviará el resultado de la función trigonométrica solicitada sobre
 * el número recibido, que por defecto al iniciar es cos.
 */
public class TrigonometryServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
            //serverSocket.close();
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        String outputLine;
        String operacionPred = "cos";
        String operacion = operacionPred;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            double rta = 0.0;
            try {
                //Trata de convertir entrada en numero
                double numero = Double.parseDouble(inputLine);
                numero = (numero * Math.PI) / 180;
                if (operacion.equals("cos")) {
                    rta = Math.cos(numero);
                } else if (operacion.equals("sin")) {
                    rta = Math.sin(numero);
                } else if (operacion.equals("tan")) {
                    rta = Math.tan(numero);
                }
                rta = (double) Math.round(rta * 100d) / 100d;
                outputLine = "Respuesta: " + rta;
            } catch (NumberFormatException e) {
                //si al entrada no es numero, captura excepcion, lo cual indica que cambio de operacion
                if (inputLine.contains("fun:")) {
                    operacion = inputLine.substring(inputLine.indexOf(":") + 1); //obtiene la funcion que está después de los dos puntos
                }
                outputLine = "Respuesta: " + inputLine;
                if (inputLine.contains("fin")) {
                    break;
                }
            }
            out.println(outputLine);
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

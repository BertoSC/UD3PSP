package org.example.ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareServerWorker implements Runnable{
    Socket socket;

    public SquareServerWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var out = new PrintWriter(socket.getOutputStream(), true)) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("QUIT")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                try {
                    int number = Integer.parseInt(inputLine);
                    int square = number * number;
                    out.println("Square: " + square);
                } catch (NumberFormatException e) {
                    out.println("Error: Input must be a valid number.");
                }
            }

        } catch (IOException e) {
            System.err.println("Error in SquareServerWorker: " + e.getMessage());
        }
    }
}

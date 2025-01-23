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
        try {
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var out = new PrintWriter(socket.getOutputStream(), true);
            int number = Integer.parseInt(in.readLine());
            int square = number * number;
            out.println(square);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

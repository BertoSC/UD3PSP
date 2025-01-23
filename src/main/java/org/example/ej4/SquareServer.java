package org.example.ej4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SquareServer {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(57779);
        System.out.println("The SquareServer is running...");
        while (true){
            Socket socket = listener.accept();


            Thread squareTh = new Thread(new SquareServerWorker(socket));
            squareTh.start();
        }

    }
}

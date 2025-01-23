package org.example.DateServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(57778)) {
            System.out.println("The date server is running...");
            while (true) {
                Socket socket = listener.accept();
                Thread serverThread = new Thread(new DateServerWorker(socket));
                serverThread.start();

            }
        }
    }
}


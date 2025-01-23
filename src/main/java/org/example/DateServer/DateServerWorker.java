package org.example.DateServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class DateServerWorker implements Runnable{
    private Socket clientSocket;

    public DateServerWorker(Socket socket){
        this.clientSocket = socket;
    }
    @Override
    public void run() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(new Date().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

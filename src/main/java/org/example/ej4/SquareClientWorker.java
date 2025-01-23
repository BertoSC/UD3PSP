package org.example.ej4;
import java.net.Socket;

public class SquareClientWorker implements Runnable{
    Socket socket;

    public SquareClientWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


    }
}

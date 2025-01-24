package org.example.ej4;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareClientWorker implements Runnable{
    Socket socket;

    public SquareClientWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            var input = new Scanner(socket.getInputStream());
            System.out.println("Enter a number : ");
            Scanner sc = new Scanner(System.in);
            String num = sc.nextLine();

            out.println(num);
            String response = input.nextLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}

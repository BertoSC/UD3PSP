package org.example.ej4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareClient {
    public static void main(String[] args) throws IOException {
        try (var socket = new Socket("localhost", 57779);
             var out = new PrintWriter(socket.getOutputStream(), true);
             var input = new Scanner(socket.getInputStream())) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("SELECT OPERATION");
                System.out.println("1. Square calculator");
                System.out.println("2. EXIT");
                int opc = scanner.nextInt();
                scanner.nextLine();

                switch (opc) {
                    case 1:
                        Thread workerThread = new Thread(new SquareClientWorker(socket));
                        workerThread.start();
                        workerThread.join();

                        break;

                    case 2:
                        System.out.println("BYE");
                        out.println("QUIT");
                        return;
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.ej4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareClient {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("localhost", 57779);
        var out = new PrintWriter(socket.getOutputStream(), true);
        var in = new Scanner(socket.getInputStream());
        while (true) {
            System.out.println("Enter a number : ");
            Scanner input = new Scanner(System.in);
            String num = input.nextLine();
            if (num.equals("exit")) {
                break;
            }
            out.println(num);
            String response = in.nextLine();
            System.out.println("Server response: " + response);
        }
    }
}

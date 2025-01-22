package org.example.ej3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EncryptClient {
        public static void main(String[] args) throws IOException {
            var socket = new Socket("localhost", 57777);
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new Scanner(socket.getInputStream());
            while (true) {
                System.out.println("Enter a MSG : ");
                Scanner input = new Scanner(System.in);
                String msn = input.nextLine();
                if (msn.equals("exit")){
                    break;
                }
                out.println(msn);
                String response = in.nextLine();
                System.out.println("Server response: " + response);
            }
    }
}

package org.example.ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;

public class EncryptServer {
    public static void main(String[] args) throws IOException {
        try (var listener = new ServerSocket(57777)) {
            System.out.println("The server is running...");
            while (true) {
                try (var socket = listener.accept()) {
                    var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    String clientMSN;
                    while ((clientMSN=in.readLine())!=null) {
                        if (clientMSN.equals("exit")){
                            out.println("Closing server...");
                            break;
                        }
                        String cypherMSN = msnEncrypted(clientMSN);
                        out.println(cypherMSN);
                    }
                }
            }
        }
    }

    public static String msnEncrypted(String msn){
        char[][] polybiusSquare = {
                {'A', 'B', 'C', 'D', 'E', 'F'},
                {'G', 'H', 'I', 'J', 'K', 'L'},
                {'M', 'N', 'O', 'P', 'Q', 'R'},
                {'S', 'T', 'U', 'V', 'W', 'X'},
                {'Y', 'Z', '0', '1', '2', '3'},
                {'4', '5', '6', '7', '8', '9'}
        };
        StringBuilder cypherMsn = new StringBuilder();
        for (char c: msn.toUpperCase().toCharArray()){
            for (int i=0; i<polybiusSquare.length;i++){
                for (int j=0; j<polybiusSquare.length;j++){
                     if (polybiusSquare[i][j]==c){
                         cypherMsn.append(i+1).append(j+1).append(" ");
                     }
                }
            }
        }
        return cypherMsn.toString().trim();
    }

}

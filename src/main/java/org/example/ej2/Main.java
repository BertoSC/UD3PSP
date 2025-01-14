package org.example.ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Main {
    private static final String URL_LINK = "https://api.slingacademy.com/v1/sample-data/blog-posts/";

    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número de id:");
        int id = sc.nextInt();
        URL peticion = new URI(URL_LINK+id).toURL();
        HttpURLConnection con = (HttpURLConnection) peticion.openConnection();
        con.setRequestMethod("GET");
        String json;

        if (con.getResponseCode()== HttpURLConnection.HTTP_OK){
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))){
                String line;
                while ((line=br.readLine())!=null){
                    System.out.println(line);
                }

            }
        }

    }
}

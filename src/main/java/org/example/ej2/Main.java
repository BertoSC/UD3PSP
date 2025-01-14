package org.example.ej2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static final String API_LINK = "https://api.slingacademy.com/v1/sample-data/blog-posts/";

    public static void main(String[] args) throws URISyntaxException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número de id:");
        int id = sc.nextInt();
        URL peticion = new URI(API_LINK+id).toURL();
        HttpURLConnection con = (HttpURLConnection) peticion.openConnection();
        con.setRequestMethod("GET");
        StringBuilder json = new StringBuilder();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Blog.class, new BlogAdapter()).create();
        if (con.getResponseCode()== HttpURLConnection.HTTP_OK){
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))){
                String line;
                while ((line=br.readLine())!=null){
                    json.append(line);
                }
            }
        }
        Blog temp = gson.fromJson(json.toString(), Blog.class);
        System.out.println(temp);

        String htmlArticle = Files.readString(Paths.get("src/main/resources/blog-resources/index.html"));
        String nuevo = htmlArticle.replace( "<h2 class=\"title fs-1\"></h2>", "<h2 class=\"title fs-1\">"+temp.getTitle()+"</h2>");
        nuevo = nuevo.replace("<!--<img src=\"IMAGE-SRC\" alt=\"article\">-->","<img src="+"\""+temp.getPhoto_url()+"\""+" alt=\"article\">"+temp.getContent_html());
        System.out.println(nuevo);
        File file = new File("src/main/resources/blog-resources/prueba.html");
        Files.writeString(file.toPath(), nuevo);


    }
}

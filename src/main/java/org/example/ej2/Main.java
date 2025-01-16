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

/*PARA OBTENER EL AUTOR DEL ARTÍCULO

* The id of the user who wrote the post.
* To get the information about that user, make an HTTP GET request to this API endpoint: https://api.slingacademy.com/v1/sample-data/users/[id]
*
* */

public class Main {
    private static final String API_LINK = "https://api.slingacademy.com/v1/sample-data/blog-posts/";
    private static final String API_AUTHOR_LINK ="https://api.slingacademy.com/v1/sample-data/users/";

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
                .registerTypeAdapter(User.class, new UserAdapter())
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
        String authorJson = obtieneJsonAutor(temp.getUser_id());
        User firma = gson.fromJson(authorJson, User.class);
        System.out.println(temp);
        System.out.println(firma);

        String htmlArticle = Files.readString(Paths.get("src/main/resources/blog-resources/index.html"));
        String nuevo = htmlArticle.replace( "<h2 class=\"title fs-1\"></h2>", "<h2 class=\"title fs-1\">"+temp.getTitle()+"</h2>");
        nuevo = nuevo.replace(
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">",
                "<link href=\"C:\\Users\\a23albertogc\\Desktop\\PSP\\UD3\\src\\main\\resources\\blog-resources\\style.css\" rel=\"stylesheet\">" +
                        "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">"
        );
        nuevo = nuevo.replace("<!--<img src=\"IMAGE-SRC\" alt=\"article\">-->","<img src="+"\""+temp.getPhoto_url()+"\""+" alt=\"article\">"+temp.getContent_html());
        nuevo = nuevo.replace("<time datetime=\"\"></time>", "<time datetime=\"" + temp.getUpdated_at() + "\">"+ temp.getUpdated_at()+"</time>");
        nuevo = nuevo.replace("Written by", "Written by "+firma.getName());
        System.out.println(nuevo);
        File file = new File("src/main/resources/blog-resources/prueba.html");
        Files.writeString(file.toPath(), nuevo);

    }


    public static String obtieneJsonAutor(int idAutor) throws URISyntaxException, IOException {
        URL peticion = new URI(API_AUTHOR_LINK+idAutor).toURL();
        HttpURLConnection con = (HttpURLConnection) peticion.openConnection();
        con.setRequestMethod("GET");
        StringBuilder author = new StringBuilder();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Blog.class, new BlogAdapter()).create();
        if (con.getResponseCode()== HttpURLConnection.HTTP_OK){
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))){
                String line;
                while ((line=br.readLine())!=null){
                    author.append(line);
                }
            }
        }
        return author.toString();
    }
}

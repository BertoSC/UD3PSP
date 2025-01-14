package org.example.url;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URL_DEMO {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
            URL url = new
                    URI("https://en.wikipedia.org/wiki/Internet#Terminology").toURL();
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host Name: " + url.getHost());
            System.out.println("Port Number: " + url.getPort());
            System.out.println("Default Port Number: " + url.getDefaultPort());
            System.out.println("Query String: " + url.getQuery());
            System.out.println("Path: " + url.getPath());
            System.out.println("File: " + url.getFile());
    }
}

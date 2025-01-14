package org.example.ej1;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SocketException {
        try {

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            for (NetworkInterface ni : Collections.list(interfaces)) {
                System.out.println("Interfaz: " + ni.getName());
                System.out.println("  Descripción: " + ni.getDisplayName());

                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    System.out.println("  Dirección IP: " + inetAddress.getHostAddress());
                }

                System.out.println();
            }
        } catch (SocketException e) {
            System.out.println("Error al obtener las interfaces de red: " + e.getMessage());
        }
    }
}
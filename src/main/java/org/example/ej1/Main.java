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
            // Obtener todas las interfaces de red
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            if (interfaces == null) {
                System.out.println("No se encontraron interfaces de red.");
                return;
            }

            // Iterar sobre las interfaces
            for (NetworkInterface ni : Collections.list(interfaces)) {
                System.out.println("Interfaz: " + ni.getName());
                System.out.println("  Descripción: " + ni.getDisplayName());

                // Obtener las direcciones IP asociadas a la interfaz
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
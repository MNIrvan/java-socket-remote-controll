/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java2asocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mni
 */
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class roihan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== REMOTE CONTROLLER CLIENT ===");
        System.out.print("Masukkan IP Target: ");
        String targetIP = scanner.nextLine();
        
        try {
            Socket s = new Socket("xx.x.x.xx", 12345);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            
            System.out.println("\nPilih perintah:");
            System.out.println("1. Buka VS Code");
            System.out.println("2. Sleep laptop (20 detik)");
            System.out.println("3. Shutdown laptop");
            System.out.println("4. Buka Calculator");
            System.out.println("5. Buka Notepad");
            System.out.print("Pilihan (1-5): ");
            
            String choice = scanner.nextLine();
            String command = "";
            
            switch(choice) {
                case "1":
                    command = "OPEN_VSCODE";
                    break;
                case "2":
                    command = "SLEEP_20";
                    break;
                case "3":
                    command = "SHUTDOWN";
                    break;
                case "4":
                    command = "OPEN_CALC";
                    break;
                case "5":
                    command = "OPEN_NOTEPAD";
                    break;
                default:
                    command = "UNKNOWN";
            }
            
            out.println(command);
            out.flush();
            s.close();
            
            System.out.println("✓ Perintah '" + command + "' terkirim ke " + targetIP);
            
        } catch (Exception e) {
            System.err.println("✗ Gagal terhubung: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java2asocket;

/**
 *
 * @author mni
 */
import java.net.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    
    public static void main(String[] args) {
        System.out.println("=== REMOTE CONTROLLER SERVER ===");
        System.out.println("Server berjalan di port 12345...");
        System.out.println("Menunggu perintah dari client...\n");
        
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client terhubung: " + clientSocket.getInetAddress());
                
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
                );
                
                String command = in.readLine();
                System.out.println("Perintah diterima: " + command);
                
                executeCommand(command);
                
                // Kirim respons ke client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("OK");
                
                clientSocket.close();
                System.out.println("Client disconnected\n");
            }
            
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void executeCommand(String command) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = null;
            
            switch(command) {
                case "OPEN_VSCODE":
                    // Windows
                    process = runtime.exec("cmd.exe /c code .");
                    System.out.println(">> Membuka VS Code...");
                    break;
                    
                case "SLEEP_20":
                    // Windows - sleep/hibernate
                    process = runtime.exec("cmd.exe /c timeout /t 20 && rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
                    System.out.println(">> Laptop akan sleep dalam 20 detik...");
                    break;
                    
                case "SHUTDOWN":
                    // Windows shutdown
                    process = runtime.exec("shutdown /s /t 10 /c \"Remote shutdown initiated\"");
                    System.out.println(">> Shutdown dalam 10 detik...");
                    break;
                    
                case "OPEN_CALC":
                    process = runtime.exec("calc.exe");
                    System.out.println(">> Membuka Calculator...");
                    break;
                    
                case "OPEN_NOTEPAD":
                    process = runtime.exec("notepad.exe");
                    System.out.println(">> Membuka Notepad...");
                    break;
                    
                default:
                    System.out.println(">> Perintah tidak dikenali: " + command);
            }
            
            if (process != null) {
                process.waitFor();
            }
            
        } catch (Exception e) {
            System.err.println("Gagal mengeksekusi perintah: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

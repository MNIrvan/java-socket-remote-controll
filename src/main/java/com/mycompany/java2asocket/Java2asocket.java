/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java2asocket;

import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author mni
 */
public class Java2asocket {

    public static void main(String[] args) {
        try {
            Socket s=new Socket("10.8.0.44", 12345);
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.write("Oi Han");
        } catch(Exception e){
            
        }
    }
}

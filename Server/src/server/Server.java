/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;
public class Server {

    public static void main (String [] args ) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        
        System.out.println("Accepted connection : " + socket);
        
        File transferFile = new File ("/Users/furkanalptokac/Desktop/gonderilecekDosya.txt");
        byte [] bytearray  = new byte [(int)transferFile.length()];
        FileInputStream fin = new FileInputStream(transferFile);
        BufferedInputStream bin = new BufferedInputStream(fin);
        
        bin.read(bytearray,0,bytearray.length);
        OutputStream os = socket.getOutputStream();
        
        System.out.println("Sending Files...");
        os.write(bytearray,0,bytearray.length);
        os.flush();
        socket.close();
        
        System.out.println("File transfer complete");
    }
    
}
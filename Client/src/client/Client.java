/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.*;
import java.io.*;

public class Client {
    
    public static void main (String [] args ) throws IOException {
        int filesize=1022386; 
        int bytesRead;
        int currentTot = 0;
        
        Socket socket = new Socket("172.20.10.13",5000);
        byte [] bytearray  = new byte [filesize];
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("/Users/furkanalptokac/Desktop/gonderilecekDosya.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        
        bytesRead = is.read(bytearray,0,bytearray.length);
        currentTot = bytesRead;
        
        do {
           bytesRead =
              is.read(bytearray, currentTot, (bytearray.length-currentTot));
           if(bytesRead >= 0) currentTot += bytesRead;
        } while(bytesRead > -1);
 
        bos.write(bytearray, 0 , currentTot);
        bos.flush();
        bos.close();
        socket.close();
      }
    
}
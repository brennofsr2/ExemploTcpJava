/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            while(true){
                Scanner sc = new Scanner(System.in);
                String msg3 = sc.nextLine();
                
                byte[] buf2 = new byte[50];
                byte[] buf3 = msg3.getBytes();
                
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf3);
                System.out.println("[OK] ]");
                
                is.read(buf2);
                String msg2 = new String(buf2);
                System.out.println("  Mensagem recebida: "+ msg2);
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}
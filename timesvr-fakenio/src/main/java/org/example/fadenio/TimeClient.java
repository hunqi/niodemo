package org.example.fadenio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/11/22 18:36
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0) {
            try{
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {}
        }

        try (Socket socket = new Socket("127.0.0.1", port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);){
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server successfully");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

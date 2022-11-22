package org.example.fadenio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/11/22 18:36
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {}
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is starting in port: " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool pool = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                pool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server closed");
                server.close();
            }
        }

    }

}

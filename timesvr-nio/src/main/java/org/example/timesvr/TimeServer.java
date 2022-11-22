package org.example.timesvr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/11/21 11:08
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {}
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}

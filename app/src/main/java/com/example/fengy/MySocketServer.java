package com.example.fengy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 服务端
 */
public class MySocketServer {

    public static void main(String[] args) {

        try {
            int clientCount = 0;

            System.out.println("创建ServerSocket对象 端口号为8888");
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true) {
                Socket socket = serverSocket.accept();
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
                System.out.println("客户端数量为：" + clientCount++);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

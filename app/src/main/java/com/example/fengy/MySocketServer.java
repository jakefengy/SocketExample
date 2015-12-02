package com.example.fengy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 服务端
 */
public class MySocketServer {

    public static void main(String[] args) {

        try {
            System.out.println("创建ServerSocket对象 端口号为8888");
            ServerSocket serverSocket = new ServerSocket(8888);

            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String clientMsg = null;
            while ((clientMsg = br.readLine()) != null) {
                System.out.println("我是服务端，收到客户端的内容为：" + clientMsg);
            }
            socket.shutdownInput();

            System.out.println("服务器反馈");
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();
            socket.shutdownOutput();

            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
            serverSocket.close();
            System.out.println("服务关闭");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.example.fengy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket 线程处理类
 */
public class SocketThread extends Thread {

    private Socket socket = null;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream is = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try {
            // 读取客户端数据
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String inputMsg = null;
            while ((inputMsg = br.readLine()) != null) {
                System.out.println("Message From " + socket.getInetAddress().getHostAddress() + ", Msg is " + inputMsg);
            }
            socket.shutdownInput();

            // 返回数据給客户端
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("Message from server to client !");
            pw.flush();
            socket.shutdownOutput();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (is != null) is.close();
                if (br != null) br.close();
                if (os != null) os.close();
                if (pw != null) pw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

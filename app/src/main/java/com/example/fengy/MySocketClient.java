package com.example.fengy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket 客户端
 */
public class MySocketClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 8888);

            OutputStream os = socket.getOutputStream();
            PrintWriter ps = new PrintWriter(os);
            ps.write("I am Client 2 ..");
            ps.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println("我是客户端，收到服务端返回：" + msg);
            }
            socket.shutdownInput();

            br.close();
            is.close();
            ps.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

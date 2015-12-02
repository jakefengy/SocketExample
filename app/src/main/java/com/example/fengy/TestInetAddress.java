package com.example.fengy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * InetAddress 使用
 */
public class TestInetAddress {

    public static void main(String[] args) {

        try {

            InetAddress address = InetAddress.getLocalHost();
            System.out.println("InetAddress is : " + address);

            URL url = new URL("http://www.baidu.com");
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data != null) {
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

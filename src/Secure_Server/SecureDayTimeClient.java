package Secure_Server;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by         : Chanaka Fernando.
 * Date               : Sun, 8/6/2017 .
 * Email              : nuwan.c.fernando@gmail.com.
 * LinkedIn           : https://www.linkedin.com/in/n-chanaka-fernando
 * Belongs to Project : NetworkProgramming_Java.
 * Package            : Secure_Server.
 */
public class SecureDayTimeClient {
    public final static int SERVER_PORT =13;

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore","C:\\Users\\Chanaka_Fernando\\clientKeyStore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","19941215");
        SocketFactory factory = SSLSocketFactory.getDefault();
        try {
            Socket socClient = factory.createSocket("localhost",SERVER_PORT);
            InputStream is = socClient.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String time = br.readLine();
            System.out.println("Time at local host is : "+time);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

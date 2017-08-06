package NIO_Server;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by         : Chanaka Fernando.
 * Date               : Sun, 8/6/2017 .
 * Email              : nuwan.c.fernando@gmail.com.
 * LinkedIn           : https://www.linkedin.com/in/n-chanaka-fernando
 * Belongs to Project : NetworkProgramming_Java.
 * Package            : NIO_Server.
 */
public class NonBlockingDayTimeClent {
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

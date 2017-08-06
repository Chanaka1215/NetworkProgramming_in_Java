package Secure_Server;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
public class SecureDayTimeServer {
    public final static int SERVER_PORT = 13;

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore","C:\\Users\\Chanaka_Fernando\\serverKeyStore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","19941215");
        ServerSocket socServerSocket = null;
        Socket socClient = null;
        try {
            ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
            socServerSocket = factory.createServerSocket(SERVER_PORT);
            System.out.println("Server socket to string" + socServerSocket.toString());
            for(;;){
                socClient = socServerSocket.accept();
                System.out.println("Client connected . Inf 1 : "+socClient.toString());
                Date today = new Date();
                PrintWriter out = new PrintWriter(socClient.getOutputStream(),true);
                out.println(today);
                System.out.println("Senet to the client : "+today);
                System.out.println("Client connected. Inf 2 : "+socClient.toString());
                socClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

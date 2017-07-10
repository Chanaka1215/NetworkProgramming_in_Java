package UsageOfInetAddress_Class;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by       : Chanaka Fernando.
 * Date             : Tue, 7/11/2017 .
 * Email            : nuwan.c.fernando@gmail.com.
 * LinkedIn         : https://www.linkedin.com/in/n-chanaka-fernando
 * Blongs to Project: NetworkProgramming_Java.
 * Package          : UDP_SocketsProgramming.UsageOfMulticastSocket.
 */
public class getByName {
    public static void main(String[] ar){
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address.getHostName()+" - "+address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}


// www.google.com - 172.217.27.100
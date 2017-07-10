package UsageOfInetAddress_Class;

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
public class getLocalHost {
    public static void main(String[] args){
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostName()+" - " +address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

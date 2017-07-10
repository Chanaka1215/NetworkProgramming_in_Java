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
public class getAllByName {
    public static void main(String[] args) {

        try {
           InetAddress[] addresses = InetAddress.getAllByName("www.google.com");

//            for(int i=0;i<addresses.length;i++){
//                System.out.println(addresses[i].getHostName() +" - "+addresses[i].getHostAddress());
//            }

            for (InetAddress i : addresses)
                System.out.println(i);
//                  System.out.println(i.getHostName() +" - "+i.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}


/***
 www.google.com/74.125.68.106
 www.google.com/74.125.68.147
 www.google.com/74.125.68.99
 www.google.com/74.125.68.105
 www.google.com/74.125.68.104
 www.google.com/74.125.68.103
 */


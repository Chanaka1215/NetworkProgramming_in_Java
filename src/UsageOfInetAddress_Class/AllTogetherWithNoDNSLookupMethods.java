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
public class AllTogetherWithNoDNSLookupMethods {
    public static void main(String[] args) {
        try {
            InetAddress googleAddress = InetAddress.getByName("www.google.com");
            InetAddress addresIpAsName =InetAddress.getByName("208.80.154.224");
            InetAddress addressByIP   = InetAddress.getByAddress(new byte[]{98,(byte)139,(byte)183,24});
            InetAddress localAddress = InetAddress.getLocalHost();
            InetAddress LocalAddressByIP =InetAddress.getByName("127.0.0.1");



            System.out.println("Google               : "+googleAddress.getHostName()+" - "+googleAddress.getHostAddress());
            System.out.println("208.80.154.224(Name) : "+addresIpAsName.getHostName()+" - " +addresIpAsName.getHostAddress());
            System.out.println("Local (Name)         : "+localAddress.getHostName() +" - "+localAddress.getHostAddress());
            System.out.println("Local (IP)           : "+LocalAddressByIP.getHostName()+" - "+LocalAddressByIP.getHostAddress());

        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
}

/*
Google               : www.google.com - 172.217.24.100
208.80.154.224(Name) : text-lb.eqiad.wikimedia.org - 208.80.154.224
Local (Name)         : ********************************
Local (IP)           : 127.0.0.1 - 127.0.0.1

Process finished with exit code 0

 */



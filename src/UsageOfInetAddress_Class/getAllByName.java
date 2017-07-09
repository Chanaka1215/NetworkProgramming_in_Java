package UsageOfInetAddress_Class;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Chanaka Fernando on 7/9/2017.
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

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}


//www.google.com/216.58.203.228
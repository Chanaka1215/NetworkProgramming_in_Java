package UsageOfInetAddress_Class;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Chanaka Fernando on 7/9/2017.
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

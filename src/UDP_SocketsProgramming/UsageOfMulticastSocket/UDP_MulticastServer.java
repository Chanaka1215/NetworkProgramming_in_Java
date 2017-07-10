package UDP_SocketsProgramming.UsageOfMulticastSocket;

import java.io.IOException;
import java.net.*;
import java.util.Date;

/**
 * Created by Chanaka Fernando on 7/10/2017.
 */
public class UDP_MulticastServer {
    private final static int MCAST_PORT=3000;
    private final static String MCAST_GROUP_IP="224.0.0.1"; //127.0.0.1
    public static void main(String[] args) {
        try {
            //create the socket bu we didnot bind it beaseause we are only going to send data
            DatagramSocket serverSocket = new DatagramSocket();

            // We don't have to join tha multicast group
            // beacaue we are only sending data and not receiving

            //Buffer for storing datagram data
            byte[] bufferData = new byte[1024];

            //Create a Datagra to send
            DatagramPacket packetOut = null;
            try {
                packetOut = new DatagramPacket(bufferData,bufferData.length, InetAddress.getByName(MCAST_GROUP_IP),MCAST_PORT);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }


            // Send the packet in one second intervals with modified data
            while(true){
                packetOut.setData(new Date().toString().getBytes());
                System.out.println("Sending "+new String(packetOut.getData()));
                serverSocket.send(packetOut);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            //close the datagram socket (net need bcoz this is unreachable)
//            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

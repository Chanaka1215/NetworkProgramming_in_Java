package UDP_SocketsProgramming.UsageOfMulticastSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by       : Chanaka Fernando.
 * Date             : Tue, 7/11/2017 .
 * Email            : nuwan.c.fernando@gmail.com.
 * LinkedIn         : https://www.linkedin.com/in/n-chanaka-fernando
 * Blongs to Project: NetworkProgramming_Java.
 * Package          : UDP_SocketsProgramming.UsageOfMulticastSocket.
 */
public class UDP_MulticastClient {
    private final static int MCAST_PORT=3000;
    private final static String MCAST_GROUP_IP="224.0.0.1"; //127.0.0.1

    public static void main(String[] args) {
        try {
            // Create a socket and bind it to te Listning port
            MulticastSocket clientSocket = new MulticastSocket(MCAST_PORT);

            // Join/ Subscribe to the multicast group
            clientSocket.joinGroup(InetAddress.getByName(MCAST_GROUP_IP));

            // Buffer for storing datagram data
            byte[] bufferedData = new byte[1024];

            // Create Datagram packet object 4 wrapping incomming packet
            DatagramPacket packetIn = new DatagramPacket(bufferedData,bufferedData.length);

            // receive data
            clientSocket.receive(packetIn);

            // Display the received data
            String receivedString = new String(packetIn.getData());
            System.out.println("Client received data :"+receivedString);

            // Leave/Unsbscribe the multicast group
            clientSocket.leaveGroup(InetAddress.getByName(MCAST_GROUP_IP));

            // Close the datagram
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

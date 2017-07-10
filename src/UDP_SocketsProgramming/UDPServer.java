package UDP_SocketsProgramming;

import java.io.IOException;
import java.net.*;

/**
 * Created by Chanaka Fernando on 7/10/2017.
 */
public class UDPServer {
    private final static int MCAST_PORT= 3000;
    public static void main(String[] args) {
        try {
            //create a datagramSocket object
            DatagramSocket serverSocket = new DatagramSocket(MCAST_PORT);

            //Create  Buffers for storing datagram data in DatagramPacket object
            byte[] bufferReceiveData = new byte[1024];  // for incoming data
            byte[] bufferSendData    = new byte[1024];  // for outgoing data

            // create a datagramPacket object for wrapping incomming packets/datagrams
            DatagramPacket packetIn = new DatagramPacket(bufferReceiveData,bufferReceiveData.length);

            // receive incoming Datagram in to DatagramPacket object
            // This is a blocking system call tfore program blocks here untill a Datagram is received
            // May emmit IOException and Need a try/catch
            try {
                serverSocket.receive(packetIn);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Get the data from received packet
            String InDataString = new String(packetIn.getData());
            System.out.println("Server received Data : "+InDataString);

            // prepare rspond message
            String respondMessage ="Hello client how are you?  from server";
            bufferSendData =respondMessage.toUpperCase().getBytes();//InDataString.toUpperCase().getBytes();


            //Find sender's address and port froom the received packet
            InetAddress senderAddress = packetIn.getAddress();
            int senderPort            = packetIn.getPort();
            int messageLength         = packetIn.getLength();

            System.out.println("Sender Host Name : " +senderAddress.getHostName());
            System.out.println("Sender Host Address : " +senderAddress.getHostAddress());
            System.out.println("Sender port : " +senderPort);
            System.out.println("Message Length : " +messageLength);



            //crete a datagram to send
            DatagramPacket packetOut = new DatagramPacket(bufferSendData,bufferSendData.length,senderAddress,senderPort);


            //send the responce datagram
            try {
                serverSocket.send(packetOut);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //close the datagram socket
            serverSocket.close();


        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}


/*

Server received Data : Hello Server, How are you? from client
Sender Host Name : 127.0.0.1
Sender Host Address : 127.0.0.1
Sender port : 61738
Message Length : 38
 */
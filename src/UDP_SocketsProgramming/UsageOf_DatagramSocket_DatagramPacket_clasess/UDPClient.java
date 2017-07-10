package UDP_SocketsProgramming.UsageOf_DatagramSocket_DatagramPacket_clasess;

import java.io.IOException;
import java.net.*;

/**
 * Created by Chanaka Fernando on 7/10/2017.
 */
public class UDPClient {
    private final static int MCAST_PORT=3000;
    public static void main(String[] args) {
        try {
            // create a datagramSocket  object
            DatagramSocket clientSocket = new DatagramSocket();

            //find the IP address of the server by Name
            InetAddress serverIP =null;
            try {
                serverIP = InetAddress.getByName("127.0.0.1");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }


            //Create  Buffers for storing datagram data in DatagramPacket object
            byte[] bufferReceiveData = new byte[1024];  // for incoming data
            byte[] bufferSendData    = new byte[1024];  // for outgoing data

            // data to send to the server
            String message = "Hello Server, How are yoy? from client";
            bufferSendData =message.getBytes();

            // create a DatagramPacket object for wrapping outgoind datagram packets
            DatagramPacket sendPackets = new DatagramPacket(bufferSendData,bufferSendData.length,serverIP,MCAST_PORT);

            // send  Datagram to above specified location
            // May emmit IOException and Need a try/catch
            try {
                clientSocket.send(sendPackets);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // create a datagramPacket object for wrapping incomming packets/datagrams
            DatagramPacket packetIn = new DatagramPacket(bufferReceiveData,bufferReceiveData.length);


            // receive incoming Datagram in to DatagramPacket object
            // This is a blocking system call tfore program blocks here untill a Datagram is received
            // May emmit IOException and Need a try/catch
            try {
                clientSocket.receive(packetIn);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //display received data
            String receivedString = new String(packetIn.getData());
            System.out.println("Client received data : "+receivedString);

            //close the datagram
            clientSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}


//Client received data : HELLO CLIENT HOW ARE YOU?  FROM SERVER
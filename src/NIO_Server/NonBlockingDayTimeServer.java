package NIO_Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by         : Chanaka Fernando.
 * Date               : Sun, 8/6/2017 .
 * Email              : nuwan.c.fernando@gmail.com.
 * LinkedIn           : https://www.linkedin.com/in/n-chanaka-fernando
 * Belongs to Project : NetworkProgramming_Java.
 * Package            : NIO_Server.
 */
public class NonBlockingDayTimeServer {
    public static final int SERVICE_PORT =13;

    public static void main(String[] args) {
        try {
            //The server socket similar for NIO
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            //creating a selecter - The multiplexter which multiplexes the messages received from diferrent clients
            Selector selector = Selector.open();

            //Set the socket chanel to be non blocking
            serverSocketChannel.configureBlocking(false);

            //creating a Socket address object with server IP and port
            //InetAddress - contain ip address and ITs host name
            //InetSocketAddress - consists ofIP address and port number pair
            InetSocketAddress socketAddress = new InetSocketAddress("localhost",SERVICE_PORT);

            //bind the server socket to the IP and PORT
            serverSocketChannel.socket().bind(socketAddress);
            System.out.println("Server socket chanel : "+serverSocketChannel.toString());

            //Interest set is the set of events interested to selecting
            int interestSet = SelectionKey.OP_ACCEPT;
            SelectionKey key =serverSocketChannel.register(selector,interestSet);

            //The repeating activities
            while (true){
                //this line block untill some event has occured
                selector.select();

                //when the return value of the Select() method indicates that one or more chanel are ready, Can access redy chanels via the selected key set.
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();

                while (iterator.hasNext()){
                    SelectionKey selectionKey = (SelectionKey)iterator.next();
                    iterator.remove(); //removed the fetched key;

                    if(!selectionKey.isValid()){
                        continue;
                    }
                    if(selectionKey.isAcceptable()){ // conection accepted by Server Socket Chanel
                        OnConnectionAcceptable(selectionKey);
                    }

                    //if(selectionKey.isReadable()){} // Chanel is ready for reading
                    //if(selectionKey.isWritable()){} // Chanel is ready for writing

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void OnConnectionAcceptable(SelectionKey selectionKey){
        try {
        //get the chanel
        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();

        //Accept it
        SocketChannel socketChannel = channel.accept();
        System.out.println("Accept the new connecttion . "+socketChannel.toString());

        //send date and time
        PrintWriter out = new PrintWriter(socketChannel.socket().getOutputStream(),true);
        Date now = new Date();
        out.println(now);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

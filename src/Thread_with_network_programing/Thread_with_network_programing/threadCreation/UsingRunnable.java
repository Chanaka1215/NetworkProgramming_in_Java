package Thread_with_network_programing.Thread_with_network_programing.threadCreation;

import com.sun.corba.se.impl.orbutil.threadpool.ThreadPoolImpl;

/**
 * Created by       : Chanaka Fernando.
 * Date             : Mon, 7/17/2017 .
 * Email            : nuwan.c.fernando@gmail.com.
 * LinkedIn         : https://www.linkedin.com/in/n-chanaka-fernando
 * Blongs to Project: NetworkProgramming_Java.
 * Package          : Thread_with_network_programing.Thread_with_network_programing.threadCreation.
 */
public class UsingRunnable implements Runnable{
    String sThrName;

    public UsingRunnable(String str){
        this.sThrName =str;
    }



    @Override
    public void run() {

        System.out.println(sThrName +" : Hello thread implemented by Runnable");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sThrName +"exiting the Thread");
    }
}

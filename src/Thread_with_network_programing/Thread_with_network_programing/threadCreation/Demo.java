package Thread_with_network_programing.Thread_with_network_programing.threadCreation;

/**
 * Created by       : Chanaka Fernando.
 * Date             : Mon, 7/17/2017 .
 * Email            : nuwan.c.fernando@gmail.com.
 * LinkedIn         : https://www.linkedin.com/in/n-chanaka-fernando
 * Blongs to Project: NetworkProgramming_Java.
 * Package          : Thread_with_network_programing.Thread_with_network_programing.threadCreation.
 */
public class Demo {
    public static void main(String[] args) {

        for(int i=0;i <10;i++){
            UsingRunnable thread = new UsingRunnable("Chanaka : "+ i);
            Thread t = new Thread(thread);
            t.start();
        }
    }
}

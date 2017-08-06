package Remote_Merhod_Invocation.ServerSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by         : Chanaka Fernando.
 * Date               : Sun, 8/6/2017 .
 * Email              : nuwan.c.fernando@gmail.com.
 * LinkedIn           : https://www.linkedin.com/in/n-chanaka-fernando
 * Belongs to Project : NetworkProgramming_Java.
 * Package            : Remote_Merhod_Invocation.ServerSide.
 */
public interface AdditionInterface extends Remote{
    public int Add (int a, int b) throws RemoteException;
}

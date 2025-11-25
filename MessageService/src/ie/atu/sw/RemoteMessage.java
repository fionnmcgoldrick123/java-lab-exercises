package ie.atu.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessage extends Remote{

	String message() throws RemoteException;

}
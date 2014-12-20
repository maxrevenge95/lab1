package serverOpoytsev;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remoteOpoytsev.*;
import dbOpoytsev.DBshema;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		final Registry registry = LocateRegistry.createRegistry(1112);
		final MyRemote remoteObj = new ServerRemote();
		Remote objStub = UnicastRemoteObject.exportObject(remoteObj, 0);
		registry.bind("RemoteObject", objStub);
		//System.out.println("Сервер запущен...");
		new ServerFrame().setVisible(true);
		try {
			DBshema.createDatabase();
			DBshema.createTabel();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

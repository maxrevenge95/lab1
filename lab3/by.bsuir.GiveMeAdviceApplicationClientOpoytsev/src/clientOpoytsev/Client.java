/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientOpoytsev;

import framesOpoytsev.AuthFrame;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author макс
 */
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, SQLException {
        new AuthFrame().setVisible(true);
    }
}

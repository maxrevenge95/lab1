package remoteOpoytsev;

import objectsOpoytsev.Comment;
import objectsOpoytsev.Post;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public interface MyRemote extends Remote {

    int logIn(String login, String password) throws RemoteException,
            SQLException;

     int logIn(String login, String password,int i) throws RemoteException,
            SQLException;

    int createUser(String login, String password) throws RemoteException,
            SQLException;

    DefaultTableModel getPosts() throws RemoteException, SQLException;

    void addPost(Post p) throws RemoteException, SQLException;

    void addComment(Comment c) throws RemoteException, SQLException;

    DefaultTableModel getComments(int postID) throws RemoteException, SQLException;

    DefaultTableModel getAllPostFromUser(int userId) throws RemoteException,
            SQLException;

    DefaultTableModel getPostByTag(String Tag) throws RemoteException,
            SQLException;

    String getUser(int userID) throws RemoteException, SQLException;

    void deletePost(int postID) throws RemoteException, SQLException;

    void blockingUser(int userId, boolean state) throws RemoteException, SQLException;

    boolean blocked(int userId) throws RemoteException, SQLException;

    void setPass(String username, String password) throws RemoteException, SQLException;

    boolean isPass(String username, String password) throws RemoteException, SQLException;

    DefaultTableModel getBlocked() throws RemoteException,
            SQLException;

    DefaultTableModel getPost(int postId) throws RemoteException, SQLException;
}

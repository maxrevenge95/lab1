package remoteOpoytsev;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import objectsOpoytsev.Comment;
import objectsOpoytsev.Post;
import dbOpoytsev.DBshema;

public class ServerRemote implements MyRemote {
	@Override
	public int logIn(String login, String password) throws RemoteException,
			SQLException {
		int id = DBshema.logIn(login, password);
		return id;
	}
	@Override
	public int logIn(String login, String password,int i) throws RemoteException,
			SQLException {
		int id = DBshema.logIn(login, password);
		return id;
	}

	@Override
	public int createUser(String login, String password)
			throws RemoteException, SQLException {
		return DBshema.createUser(login, password); // return id;
	}

	@Override
	public DefaultTableModel getPosts() throws RemoteException, SQLException {
		return DBshema.getPosts();
	}

	@Override
	public void addPost(Post p) throws RemoteException, SQLException {
		DBshema.addPost(p);
	}

	@Override
	public void addComment(Comment c) throws RemoteException, SQLException {
		DBshema.addComment(c);
	}

	@Override
	public DefaultTableModel getComments(int postID) throws RemoteException,
			SQLException {
		return DBshema.getComments(postID);
	}

	@Override
	public DefaultTableModel getAllPostFromUser(int userId)
			throws RemoteException, SQLException {
		return DBshema.getAllPostsFromUser(userId);
	}

	@Override
	public DefaultTableModel getPostByTag(String Tag) throws RemoteException,
			SQLException {
		return DBshema.getPostByTag(Tag);
	}

	@Override
	public String getUser(int userID) throws RemoteException, SQLException {
		return DBshema.getUser(userID);
	}

	@Override
	public void blockingUser(int userID, boolean state) throws RemoteException,
			SQLException {
		// TODO Auto-generated method stub
		DBshema.blockingUser(userID, state);
	}

	@Override
	public void deletePost(int postID) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		DBshema.deletePost(postID);

	}

	@Override
	public boolean blocked(int UserId) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		if (DBshema.blocked(UserId))
			return true;
		return false;
	}

	@Override
	public void setPass(String username, String password)
			throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		DBshema.setPass(username, password);

	}

	@Override
	public boolean isPass(String username, String password)
			throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		return DBshema.isPass(username, password);

	}

	@Override
	public DefaultTableModel getBlocked() throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		return DBshema.getBlocked();
	}

	@Override
	public DefaultTableModel getPost(int postId) throws RemoteException, SQLException {
		return DBshema.getPost(postId);
	}

}

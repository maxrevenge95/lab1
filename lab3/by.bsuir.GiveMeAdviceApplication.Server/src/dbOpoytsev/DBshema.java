package dbOpoytsev;

//import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import objectsOpoytsev.Comment;
import objectsOpoytsev.Post;

public class DBshema {
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";
	private static final String CONECTION = "jdbc:mysql://localhost/gmaapp?useUnicode=false&characterEncoding=utf8";
	private static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS gmaapp";
	private static final String CREATE_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS comment (\n"
			+ "commentID int(11) NOT NULL auto_increment,\n"
			+ "commentText varchar(512) NOT NULL,\n"
			+ "userID int(11) NOT NULL,\n"
			+ "postID int(11) NOT NULL,\n"
			+ "PRIMARY KEY  (commentID),\n"
			+ "KEY userID (userID),\n"
			+ "CONSTRAINT fk_c_p FOREIGN KEY (postID) REFERENCES post (postID) ON DELETE CASCADE ON UPDATE CASCADE,\n"
			+ "CONSTRAINT fk_c_u FOREIGN KEY (userID) REFERENCES user (userID) ON DELETE CASCADE ON UPDATE CASCADE\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";
	private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS user (\n"
			+ "userID int(11) NOT NULL auto_increment,\n"
			+ "userName varchar(45) NOT NULL,\n"
			+ "userPassword varchar(45) NOT NULL,\n"
			+ "rank int(11) NOT NULL default '0',\n"
			+ "blocking int(11) NOT NULL default '0',\n"
			+ "PRIMARY KEY  (userID)\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";
	private static final String CREATE_POST_TABLE = "CREATE TABLE IF NOT EXISTS post (\n"
			+ " postID int(11) NOT NULL auto_increment,\n"
			+ "  title varchar(45) NOT NULL,\n"
			+ " postText varchar(2048) NOT NULL,\n"
			+ " tag1 varchar(45) default NULL,\n"
			+ "tag2 varchar(45) default NULL,\n"
			+ "tag3 varchar(45) default NULL,\n"
			+ " tag4 varchar(45) default NULL,\n"
			+ " userID int(11) NOT NULL,\n"
			+ "postDate varchar(30) NOT NULL,\n"
			+ " PRIMARY KEY  (postID),\n"
			+ " KEY userID (userID),\n"
			+ " CONSTRAINT fk_post_user FOREIGN KEY (userID) REFERENCES user (userID) ON DELETE CASCADE ON UPDATE CASCADE\n"
			+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";

	public static int logIn(String log, String pas) throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet idResultSet = statement
					.executeQuery("SELECT userID FROM user "
							+ "WHERE userName='" + log + "' AND userPassword='"
							+ pas + "'");
			if (idResultSet != null) {
				idResultSet.next();
				int id = idResultSet.getInt(1);
				return id;
			} else
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return 0;
	}

	public static int logIn(String log, String pas, int i) throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet idResultSet = statement
					.executeQuery("SELECT userID FROM user "
							+ "WHERE userName='" + log + "'");
			if (idResultSet != null) {
				idResultSet.next();
				int id = idResultSet.getInt(1);
				return id;
			} else
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return 0;
	}

	public static void createTabel() throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			statement.executeUpdate(CREATE_USER_TABLE);
			statement.executeUpdate(CREATE_POST_TABLE);
			statement.executeUpdate(CREATE_COMMENT_TABLE);
			ResultSet id = statement.executeQuery("SELECT userID FROM user WHERE userName = 'admin'");
			if(!id.next())
				statement
				 .executeUpdate("INSERT INTO user (userName,userPassword,rank) VALUE ('admin','admin','1')");			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public static void createDatabase() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/",
					LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			statement.executeUpdate(CREATE_DATABASE);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public static int createUser(String log, String pas) throws SQLException {
		Connection connection = null;
		int k = 0;
		try {
			int id = logIn(log, pas, k);
			if (id != 0)
				return 0;
			else {
				connection = DriverManager.getConnection(CONECTION, LOGIN,
						PASSWORD);
				Statement statement = connection.createStatement();
				statement
						.executeUpdate("INSERT INTO user (userName, userPassword) "
								+ "VALUES ('" + log + "','" + pas + "')");
				id = logIn(log, pas);
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return 0;
	}

	public static void addComment(Comment c) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("INSERT INTO comment (commentText,userID,postID) VALUE"
							+ "('"
							+ c.getCommentText()
							+ "','"
							+ c.getUserID()
							+ "','" + c.getPostID() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

	}

	public static DefaultTableModel getPosts() throws SQLException {
		Connection connection = null;
		DefaultTableModel gut = new DefaultTableModel();
		gut.addColumn("ID поста");
		gut.addColumn("Заголовок");
		gut.addColumn("Текст");
		gut.addColumn("тег1");
		gut.addColumn("тег2");
		gut.addColumn("тег3");
		gut.addColumn("тег4");
		gut.addColumn("ID автора");
		gut.addColumn("дата");
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM post ORDER BY postID DESC");

			while (rs.next()) {
				Vector<String> post = new Vector<String>();
				post.addElement(rs.getString(1));
				post.addElement(rs.getString(2));
				post.addElement(rs.getString(3));
				post.addElement(rs.getString(4));
				post.addElement(rs.getString(5));
				post.addElement(rs.getString(6));
				post.addElement(rs.getString(7));
				post.addElement(rs.getString(8));
				post.addElement(rs.getString(9));
				gut.addRow(post);
			}
			// gut.toString();
			return gut;
		} catch (SQLException e) {
			// addMessageToLog(e.getMessage());
			throw e;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}
	}

	public static void addPost(Post p) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			String[] temp = new String[4];
			temp = p.getTags();
			statement
					.executeUpdate("INSERT INTO gmaapp.post(title,postText,tag1,tag2,tag3,tag4,userID,postDate) VALUE"
							+ "('"
							+ p.getTitle()
							+ "','"
							+ p.getPostText()
							+ "','"
							+ temp[0]
							+ "','"
							+ temp[1]
							+ "','"
							+ temp[2]
							+ "','"
							+ temp[3]
							+ "','"
							+ p.getUserID()
							+ "','" + p.getDatetime() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

	}

	public static DefaultTableModel getComments(int postID) throws SQLException {
		Connection connection = null;
		DefaultTableModel gut = new DefaultTableModel();
		gut.addColumn("ID комментария");
		gut.addColumn("Текст");
		gut.addColumn("ID автора");
		gut.addColumn("ID поста");
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM comment WHERE postID = "
							+ postID + " ORDER BY commentID DESC");
			while (rs.next()) {
				Vector<String> post = new Vector<String>();
				post.addElement(rs.getString(1));
				post.addElement(rs.getString(2));
				post.addElement(rs.getString(3));
				post.addElement(rs.getString(4));
				gut.addRow(post);
			}
			// gut.toString();
			return gut;
		} catch (SQLException e) {
			// addMessageToLog(e.getMessage());
			throw e;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}

	}

	public static DefaultTableModel getAllPostsFromUser(int userID)
			throws SQLException {
		Connection connection = null;
		DefaultTableModel gut = new DefaultTableModel();
		gut.addColumn("ID поста");
		gut.addColumn("Заголовок");
		gut.addColumn("Текст");
		gut.addColumn("тег1");
		gut.addColumn("тег2");
		gut.addColumn("тег3");
		gut.addColumn("тег4");
		gut.addColumn("ID автора");
		gut.addColumn("дата");
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM post WHERE userID = " + userID
							+ " ORDER BY postID DESC");
			while (rs.next()) {
				Vector<String> post = new Vector<String>();
				post.addElement(rs.getString(1));
				post.addElement(rs.getString(2));
				post.addElement(rs.getString(3));
				post.addElement(rs.getString(4));
				post.addElement(rs.getString(5));
				post.addElement(rs.getString(6));
				post.addElement(rs.getString(7));
				post.addElement(rs.getString(8));
				post.addElement(rs.getString(9));
				gut.addRow(post);
			}
			// gut.toString();
			return gut;
		} catch (SQLException e) {
			// addMessageToLog(e.getMessage());
			throw e;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}

	}

	public static String getUser(int userID) throws SQLException {
		Connection connection = null;
		String name = new String();
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet idResultSet = statement
					.executeQuery("SELECT userName FROM user "
							+ "WHERE userID='" + userID + "'");

			name = idResultSet.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return name;
	}

	public static DefaultTableModel getPost(int postID) throws SQLException {
		Connection connection = null;
		DefaultTableModel gut = new DefaultTableModel();
		gut.addColumn("ID поста");
		gut.addColumn("Заголовок");
		gut.addColumn("Текст");
		gut.addColumn("тег1");
		gut.addColumn("тег2");
		gut.addColumn("тег3");
		gut.addColumn("тег4");
		gut.addColumn("ID автора");
		gut.addColumn("дата");
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			// System.out.println("statement created");
			ResultSet rs = statement.executeQuery("SELECT * FROM post "
					+ "WHERE postID='" + postID + "'");

			while (rs.next()) {
				Vector<String> post = new Vector<String>();
				post.addElement(rs.getString(1));
				post.addElement(rs.getString(2));
				post.addElement(rs.getString(3));
				post.addElement(rs.getString(4));
				post.addElement(rs.getString(5));
				post.addElement(rs.getString(6));
				post.addElement(rs.getString(7));
				post.addElement(rs.getString(8));
				post.addElement(rs.getString(9));
				gut.addRow(post);
			}
			return gut;
		} catch (SQLException e) {
			// addMessageToLog(e.getMessage());
			throw e;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}

	}

	public static DefaultTableModel getPostByTag(String Tag)
			throws SQLException {
		Connection connection = null;
		DefaultTableModel gut = new DefaultTableModel();
		gut.addColumn("ID поста");
		gut.addColumn("Заголовок");
		gut.addColumn("Текст");
		gut.addColumn("тег1");
		gut.addColumn("тег2");
		gut.addColumn("тег3");
		gut.addColumn("тег4");
		gut.addColumn("ID автора");
		gut.addColumn("дата");
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			// System.out.println("statement created");
			ResultSet rs = statement
					.executeQuery("SELECT * FROM post WHERE tag1 LIKE '%" + Tag
							+ "%' OR tag2 LIKE '%" + Tag + "%' OR tag3 LIKE '%"
							+ Tag + "%' OR tag4 LIKE '%" + Tag
							+ "%' ORDER BY postID DESC");

			while (rs.next()) {
				Vector<String> post = new Vector<String>();
				post.addElement(rs.getString(1));
				post.addElement(rs.getString(2));
				post.addElement(rs.getString(3));
				post.addElement(rs.getString(4));
				post.addElement(rs.getString(5));
				post.addElement(rs.getString(6));
				post.addElement(rs.getString(7));
				post.addElement(rs.getString(8));
				post.addElement(rs.getString(9));
				gut.addRow(post);
			}
			return gut;
		} catch (SQLException e) {
			// addMessageToLog(e.getMessage());
			throw e;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}

	}

	public static void blockingUser(int userId, boolean state)
			throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(CONECTION, LOGIN, PASSWORD);
		Statement statement = connection.createStatement();
		if (state) {
			statement
					.executeUpdate("UPDATE user SET blocking = 1 WHERE userID = '"
							+ userId + "'");
		} else
			statement
					.executeUpdate("UPDATE user SET blocking = 0 WHERE userID = '"
							+ userId + "'");
		if (connection != null)
			connection.close();

	}

	public static void deletePost(int postId) {
		Connection connection = null;
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM post WHERE postID = '"
					+ postId + "'");
		} catch (SQLException e) {
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}
	}

	public static boolean blocked(int userId) throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(CONECTION, LOGIN, PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet rs = statement
				.executeQuery("SELECT blocking FROM user WHERE userID = '"
						+ userId + "'");
		if (rs != null) {
			rs.next();
			int state = rs.getInt(1);
			if (state == 1)
				return true;
			else
				return false;
		}
		return false;
	}

	public static void setPass(String username, String password)
			throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(CONECTION, LOGIN, PASSWORD);
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE user SET userPassword = '" + password
				+ "' WHERE userName = '" + username + "'");
		connection.close();

	}

	public static boolean isPass(String username, String password)
			throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(CONECTION, LOGIN, PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet rs = statement
				.executeQuery("SELECT userPassword FROM user WHERE userName = '"
						+ username + "'");
		if (rs != null) {
			rs.next();
			String state = rs.getString(1);
			if (state.equals(password))
				return true;
			else
				return false;
		}
		return false;
	}

	public static DefaultTableModel getBlocked() throws SQLException {
		Connection connection = null;
		DefaultTableModel gut = new DefaultTableModel();
		gut.addColumn("ID");
		gut.addColumn("Логин");
		try {
			connection = DriverManager
					.getConnection(CONECTION, LOGIN, PASSWORD);
			Statement statement = connection.createStatement();
			// System.out.println("statement created");
			ResultSet rs = statement
					.executeQuery("SELECT userID,userName FROM user WHERE blocking = '1'");

			while (rs.next()) {
				Vector<String> post = new Vector<String>();
				post.addElement(rs.getString(1));
				post.addElement(rs.getString(2));
				gut.addRow(post);
			}
			return gut;
		} catch (SQLException e) {
			// addMessageToLog(e.getMessage());
			throw e;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// addMessageToLog(e.getMessage());
				}
		}

	}
}

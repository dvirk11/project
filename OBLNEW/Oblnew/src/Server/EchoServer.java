package Server;

//This file contains material supporting section 3.7 of the textbook:
//"Object Oriented Software Engineering" and is issued under the open-source
//license found at www.lloseng.com 

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import Entity.*;
import java.sql.Date;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
	//Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	public static Connection conn = null;

	//Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public EchoServer(int port) 
	{
		super(port);
	}

	private Connection connectToDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			/* handle the error */
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/obl", "root", "hanan123");
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}


	public ArrayList<String> getQuery(String query) throws Exception {
		Statement stmt;
		Connection con = connectToDB();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> objectArr = new ArrayList<>();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while(rs.next()) {
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					objectArr.add(rs.getString(i));
					System.out.println(rs.getString(i));}
			}
			this.sendToAllClients(objectArr);
			rs.close();
			return objectArr;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}




	private void saveUserToDB(Connection con,Statement s) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			// String query = String.format("INSERT INTO obl.member VALUES('%s','%s','%s','%s','%s')",s.getID(),s.getName(),s.getStatusMembership(),s.getOperation(),Integer.parseInt(s.isFreeze()));
			// stmt.execute(query);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	//private Statement parsingTheData(ArrayList<String> arr) {
	//	return new Statement(arr.get(1), arr.get(0), arr.get(2), arr.get(3), arr.get(4));
	//}



	//Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg The message received from the client.
	 * @param client The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		//ArrayList<Object> objectArr = null;
		Connection con = connectToDB();
		//Statement stmt;
		Msg newMsg = (Msg) msg;
		switch(newMsg.getFuncToRun())
		{
		case getMemberByIdAndPass:
		{
			 newMsg = getMemberByIdAndPass(newMsg, con);
			 break;
		}
		
		case getMemberByIdAndGraduation:
		{
			newMsg=getMemberByIdAndGraduation(newMsg,con);
			break;
		}
		case searchBook:
		{
			newMsg=searchBook(newMsg,con);
			break;
		}
			
			
	}
		/*
		String query = msg.toString();
		if (msg instanceof String) {
			if (query.contains("SELECT")) {
			
				try {
					//ArrayList<String> objectArr = new ArrayList<>();
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {
						objectArr.add(rs.getString(1));
						objectArr.add(rs.getString(2));
						objectArr.add(rs.getString(3));
						objectArr.add(rs.getString(4));
						objectArr.add(rs.getString(5));
						objectArr.add(rs.getString(6));
						objectArr.add(rs.getString(7));
						objectArr.add(rs.getString(8));
						objectArr.add(rs.getString(9));
						objectArr.add(rs.getString(10));

					}*/
		System.out.println(newMsg.dataFromServer.toString());
		System.out.println(newMsg.getFuncToRun());
					try {
						client.sendToClient(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	//				rs.close();
					return ;
				}
				/*catch (SQLException e) {
					e.printStackTrace();
					return ;
				} */
		/*
			if (query.contains("UPDATE")) {
				Statement statement;
				try {
					statement = con.createStatement();
					statement.executeUpdate(query);
				}  catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
		

/**
 * Parse the result set in to a Book object
 * 
 * @param rs - the data from the DB 
 * @return new object to add to MSG array 
 * @throws SQLException
 */
	

	
	public Object createObject(ResultSet rs) throws SQLException {
		
		String idbook = rs.getString(1);
		String bookname = rs.getString(2);
		int Quantity = rs.getInt(3);
		String booklocation = rs.getString(4);
		int Editionnumber =rs.getInt(5);
		String Genre = rs.getString(6);
		String Author = rs.getString(7);
		String Description = rs.getString(8);;
		String tableofcontents = rs.getString(9);;
		String Tagged = rs.getString(10);;
		int currentlyonloan = rs.getInt(11);
		String Purchasedate = rs.getString(12);
		String Executiondate = rs.getString(13);
		
		return new Book(idbook,bookname,Quantity,booklocation,Editionnumber,Genre,Author,Description,tableofcontents,Tagged,currentlyonloan,Purchasedate,Executiondate);
	}

	/**
	 * This method overrides the one in the superclass.  Called
	 * when the server starts listening for connections.
	 */
	protected void serverStarted()
	{
		System.out.println
		("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass.  Called
	 * when the server stops listening for connections.
	 */
	protected void serverStopped()
	{
		System.out.println
		("Server has stopped listening for connections.");
	}
	
	

	//Class methods ***************************************************

	/**
	 * This method is responsible for the creation of 
	 * the server instance (there is no UI in this phase).
	 *
	 * @param args[0] The port number to listen on.  Defaults to 5555 
	 *          if no argument is entered.
	 */
	public static void main(String[] args) 
	{
		int port = 0; //Port to listen on

		try
		{
			port = Integer.parseInt(args[0]); //Get port from command line
		}
		catch(Throwable t)
		{
			port = DEFAULT_PORT; //Set port to 5555
		}

		EchoServer sv = new EchoServer(port);

		try 
		{
			sv.listen(); //Start listening for connections
		} 
		catch (Exception ex) 
		{
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
	public Msg getMemberByIdAndPass(Msg msg, Connection conn) 
	{
		ArrayList<Object> objectArr = new ArrayList<>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(msg.getQuery());
			while(rs.next()) {
				msg.dataFromServer.add(rs.getString(1));
				msg.dataFromServer.add(rs.getString(2));
				msg.dataFromServer.add(rs.getString(3));
				msg.dataFromServer.add(rs.getString(4));
				msg.dataFromServer.add(rs.getString(5));
				msg.dataFromServer.add(rs.getString(6));
				msg.dataFromServer.add(rs.getString(7));
				msg.dataFromServer.add(rs.getString(8));
				msg.dataFromServer.add(rs.getString(9));
				msg.dataFromServer.add(rs.getString(10));
				msg.dataFromServer.add(rs.getString(11));
			}
			rs.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//msg.setDataFromServer(objectArr);
		System.out.println(msg.dataFromServer.toString());
		return msg;
		
	}
	
	public Msg getMemberByIdAndGraduation(Msg msg, Connection conn) {
		
		ArrayList<Object> objectArr = new ArrayList<>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(msg.getQuery());
			while(rs.next()) {
				msg.dataFromServer.add(rs.getString(1));
				msg.dataFromServer.add(rs.getString(2));
				msg.dataFromServer.add(rs.getString(3));
				msg.dataFromServer.add(rs.getString(4));
				msg.dataFromServer.add(rs.getString(5));
				msg.dataFromServer.add(rs.getString(6));
				msg.dataFromServer.add(rs.getString(7));
				msg.dataFromServer.add(rs.getString(8));
				msg.dataFromServer.add(rs.getString(9));
				msg.dataFromServer.add(rs.getString(10));
				msg.dataFromServer.add(rs.getString(11));
			}
			rs.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//msg.setDataFromServer(objectArr);
		System.out.println(msg.dataFromServer.toString());
		return msg;
		
		
	}
	
	public Msg searchBook(Msg msg, Connection conn) {
	//	String search;
		
		ArrayList<Object> objectArr = new ArrayList<>();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			//PreparedStatement stm=conn.prepareStatement(msg.getQuery());
		    //search = "'"+msg.dataToServer.get(1).toString()+"'";
			//stm.setString(1, search);
			ResultSet rs = stmt.executeQuery(msg.getQuery());
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while(rs.next()) {
				
				Object obj = createObject(rs);
				System.out.println(obj.toString());
				msg.dataFromServer.add(obj);
			/*	
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					objectArr.add(rs.getString(i));
					System.out.println(rs.getString(i));
					}
				
				/*
				msg.dataFromServer.add(rs.getString(1));
				msg.dataFromServer.add(rs.getString(2));
				msg.dataFromServer.add(rs.getString(3));
				msg.dataFromServer.add(rs.getString(4));
				msg.dataFromServer.add(rs.getString(5));
				msg.dataFromServer.add(rs.getString(6));
				msg.dataFromServer.add(rs.getString(7));
				msg.dataFromServer.add(rs.getString(8));
				msg.dataFromServer.add(rs.getString(9));
				msg.dataFromServer.add(rs.getString(10));
				msg.dataFromServer.add(rs.getString(11));
				msg.dataFromServer.add(rs.getString(12));
				msg.dataFromServer.add(rs.getString(13));
				*/
			}
			rs.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//msg.setDataFromServer(objectArr);
	//	System.out.println(msg.dataFromServer.get(0).toString());
		//System.out.println(msg.dataFromServer.get(1).toString());
		
		return msg;
		
		
		
	}
	
	
	
}
//End of EchoServer class

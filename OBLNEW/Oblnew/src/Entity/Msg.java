package Entity;
import java.util.ArrayList;

import Client.Command;

import java.io.Serializable;
/**
 * This class uses for hands all the details about database sending and receiving
 *
 */
public class Msg implements Serializable {
	/**
	 * the command we send to DB
	 */
	String query;
	/**
	 * the array we send with the data to the server
	 */
	public ArrayList<Object> dataToServer= new ArrayList<Object>();
	/**
	 * the array we receive with the data from the server 
	 */
	public ArrayList<Object> dataFromServer = new ArrayList<Object>();
	/**
	 * the 	operation we send to the server 
	 */
	Command funcToRun;

	/***
	 * Constructor for the Msg
	 * 
	 * @param query
	 *           
	 * @param command
	 *                     
	 */
	public Msg(String query, Command command) {
		super();
		this.query = query;

		this.funcToRun = command;
	}
	/**
	 * 
	 * @return the query
	 */

	public String getQuery() {
		return query;
	}
	/**
	 * 
	 * @param query
	 *         to set
	 */

	public void setQuery(String query) {
		this.query = query;
	}
	/**
	 * 
	 * @return ArrayList of the Data To Server 
	 */

	public ArrayList<Object> getDataToServer() {
		return dataToServer;
	}
	/**
	 * 
	 * @param dataToServer
	 *           to set
	 */

	public void setDataToServer(ArrayList<Object> dataToServer) {
		this.dataToServer = dataToServer;
	}
	/**
	 * 
	 * @return ArrayList of the Data From Server 
	 */


	public ArrayList<Object> getDataFromServer() {
		return dataFromServer;
	}
	/**
	 * 
	 * @param dataFromServer
	 *          to set
	 */

	public void setDataFromServer(ArrayList<Object> dataFromServer) {
		this.dataFromServer = dataFromServer;
	}
	/**
	 * 
	 * @return Command
	 */

	public Command getFuncToRun() {
		return funcToRun;
	}
	/**
	 * 
	 * @param funcToRun
	 *          set to Command
	 */


	public void setFuncToRun(Command funcToRun) {
		this.funcToRun = funcToRun;
	}
	
/*	public <T> ArrayList<T> convertedResultListFormServer(Msg newmsg){
		ArrayList<T> genericList = new ArrayList<>();
		for(Object temp :newmsg.dataFromServer ) {
			genericList.add((T) String.valueOf(newmsg.dataFromServer));
		}
		
		
		return genericList;
	}*/
	







}

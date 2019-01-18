package Client;

import Entity.*;
import java.io.IOException;
import java.util.ArrayList;



import Controllers.MemberController;
import Gui.*;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ocsf.client.AbstractClient;
import Gui.ForgotpasswordController;
public class CommunicationController extends AbstractClient {

	public  MainController mainController;
	public  MemberController memberController;
	public ForgotpasswordController forgotpasswordController;
	public SearchBookMainController searchBookMainController;
	public HomepageController HomePageController;
	public CommunicationController(String host, int port) {
		super(host, port);
		try {
			openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		Msg newmsg = (Msg)msg;	
		System.out.println(newmsg.dataFromServer.toString()+"from comm");

		switch(newmsg.getFuncToRun()) {

		case getMemberByIdAndPass:
			try {
				if(!(newmsg.getDataFromServer().isEmpty())){
					System.out.println(newmsg.dataFromServer.toString()+"from comm");

					//Member member=memberController.creatNewMember(newmsg.dataFromServer);		
					Member member=new Member (Boolean.valueOf(newmsg.dataFromServer.get(10).toString()),newmsg.dataFromServer.get(0).toString(),
							newmsg.dataFromServer.get(1).toString(),newmsg.dataFromServer.get(2).toString(),
							newmsg.dataFromServer.get(3).toString(),newmsg.dataFromServer.get(4).toString(),
							newmsg.dataFromServer.get(5).toString(),newmsg.dataFromServer.get(6).toString(),
							newmsg.dataFromServer.get(7).toString(),Integer.valueOf(newmsg.dataFromServer.get(8).toString()),
							newmsg.dataFromServer.get(9).toString());
					if(member.getStatus().equals("Active")) {
						mainController.handleloginresult();
					}
					else {
						{
							mainController.displayAlert(AlertType.INFORMATION, "Blocked", "User Blocked", "Your user has been blocked. Contact our stuff managment");

						}

					}
				}
				else {
					mainController.displayAlert(AlertType.ERROR, "Error", "Login Failed", "Make sure that you have filled in all fields correctly!");

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block we need to add Alert

				e.printStackTrace();
			}
			break;


		case getMemberByIdAndGraduation:
			try {
				if((newmsg.getDataFromServer().isEmpty())){
					System.out.println(newmsg.dataFromServer.toString()+"from comm");
					forgotpasswordController.displayAlert(AlertType.INFORMATION, "Error", "Member does not exist", "Member does not exist in the system");
				}
				else {
					forgotpasswordController.handleforgotpasswordresult(newmsg.getDataFromServer().get(5).toString());
				}
			}

			catch (Exception e) {
				// TODO Auto-generated catch block we need to add Alert

				e.printStackTrace();
			}
			break;	 
		case searchBook:{
			Book book=(Book) newmsg.dataFromServer.get(0);
			System.out.println(book.getBookname());
		//	Platform.runLater(new Runnable() {
	    	   // @Override
	    	//    public void run() {
	    	  //try
	    	    	//{
			if(!(newmsg.getDataFromServer().isEmpty())){
				//System.out.println(newmsg.dataFromServer.toString()+"xxx");
				for(int i = 0 ; i<newmsg.dataFromServer.size();i++) {
					Book.books.add((Book) newmsg.dataFromServer.get(i));
					System.out.println(Book.books.get(i).getBookname());
				}
				
				searchBookMainController.handleSearchresult(Book.books);
				//Book book=(Book) newmsg.dataFromServer.get(0);
			//	Book book1=(Book) newmsg.dataFromServer.get(1);
				//System.out.println(book.getBookname());
				//System.out.println(book.getEditionnumber());
				//System.out.println(book1.getEditionnumber());
				//searchBookMainController.searchBookHandler();

	 }
			
			//}
	    	   	
		    	//catch (Exception e)
		    //	{
		    		//displayAlert(AlertType.ERROR, "Error", "Exception", e.getMessage());
		    //	}
			break;
		       }
		}
	
		   // }
		//});

			//}
		
		}

	 	

















	public void handleMessageFromClientUI(Object arr) {
		System.out.println(arr);
		try
		{
			sendToServer(arr);		 
		}
		catch(IOException e)
		{
			System.out.println("Could not send message to server.  Terminating client." + e);
		}
	}

}


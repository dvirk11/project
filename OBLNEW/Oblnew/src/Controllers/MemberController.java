package Controllers;
import Entity.Member;
import Entity.Msg;
import Gui.MainController;
import Client.Command;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
import Client.Main;

/***
 * 
 * Controller class to perform subscription actions
 *
 */

public class MemberController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MemberController() {
		super();
	}
	/**
	 * handle login Checks for if the member exist and logs in to the system
	 * @param userName - geting from the MainController
	 * @param pass - geting from the MainController
	 * @throws IOException
	 */
	public void handlelogin(String userName,String pass  ) throws IOException {
			
    	Msg msg=new Msg("SELECT * FROM Member WHERE MemberID ="+ userName+ " and Password =" + pass +";", Command.getMemberByIdAndPass);
    	//msg.dataToServer.add(userName);
        //msg.dataToServer.add(pass);
    	Main.client.sendToServer(msg);
	}
	
	public Member creatNewMember(ArrayList<Object> dataFromServer) {
	
		Member member=new Member (Boolean.valueOf(dataFromServer.get(10).toString()),dataFromServer.get(0).toString(),
				dataFromServer.get(1).toString(),dataFromServer.get(2).toString(),
				dataFromServer.get(3).toString(),dataFromServer.get(4).toString(),
				dataFromServer.get(5).toString(),dataFromServer.get(6).toString(),
				dataFromServer.get(7).toString(),Integer.valueOf(dataFromServer.get(8).toString()),
				dataFromServer.get(9).toString());
		System.out.println(member.toString());
		return member;
		
		
	}
	/**
	 * handle Forgot password help the member to login by identification by ID and year of graduation to sent the password
	 * @param ID - geting from the ForgotpasswordController
	 * @param graduation - geting from the ForgotpasswordController
	 * @throws IOException
	 */
	public void handlelForgotpassword(String ID , String graduation) throws IOException {
		Msg msg=new Msg("SELECT * FROM Member WHERE MemberID ="+ ID+ " and Graduationyear =" + graduation +";", Command.getMemberByIdAndGraduation);
    	msg.dataToServer.add(ID);
    	msg.dataToServer.add(graduation);
    	Main.client.sendToServer(msg);
		
	}

}

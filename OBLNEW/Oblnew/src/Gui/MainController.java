package Gui;


import Client.Main;
import Controllers.MemberController;
import java.io.IOException;
import java.util.EventObject;

import Gui.HomepageController;
import Client.Command;
import Entity.Msg;
import Entity.Member;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class MainController {

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private Label UsernameLabel;

    @FXML
    private TextField TextFiledUsername;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Button Loginbnt;

    @FXML
    private Button Forgotbnt;

    @FXML
    private Button SearchBookbnt;

    @FXML
    private Label Clabel;

    @FXML
    private Button Exit;
	/**
	 * current stage
	 */
	 static Stage mainStage;

    @FXML
    private PasswordField TextFiledPassword;
    HomepageController home=new HomepageController();


    
    public void initialize() {
    	Main.client.mainController=this;
    }
  

    @FXML
    void ExitHandler(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Exit Window");
		alert.setContentText("Are you Sure?");
		ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonData.NO);

		alert.getButtonTypes().setAll(okButton, noButton);
		alert.showAndWait().ifPresent(type -> {
			if (type == okButton) {
				System.exit(0);

			}
		});
	}

    

    @FXML
    void LoginHandler(ActionEvent event) throws IOException {
      	String userName = TextFiledUsername.getText();
    	String pass = TextFiledPassword.getText();
    	
    	
    	if (userName.isEmpty() || pass.isEmpty())
    	{
    		displayAlert(AlertType.ERROR, "Error", "Login Failed", "User name or Password are missing!");
    		return;
    	}
    	
    	MemberController member=new MemberController();
    	member.handlelogin(userName,pass);
    /*
    	String temp = "SELECT * FROM Member WHERE MemberID ="+ userName+ " and Password =" + pass +";";	
    	Msg msg=new Msg(temp, 1);
    	msg.dataToServer.add(userName);
    	msg.dataToServer.add(pass);*/
    	//msg.getSentmsg(getMemberByIdAndPass);
    	
    	//Main.client.sendToServer(msg);
    	
    }
    
    public void handleloginresult() throws Exception 
	{
    	
    	Platform.runLater(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try
    	    	{
    	    		mainStage.close();
    	    		

    	        	Stage primaryStage = new Stage();
    	        	Main.client.HomePageController.HomeStage=primaryStage;
    	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
    	            System.out.println(getClass().getResource("Homepage.fxml"));
    	            AnchorPane pane =(AnchorPane) loader.load();
    	            Scene scene = new Scene( pane );
    	            
    	            // setting the stage
    	            primaryStage.setScene( scene );
    	            primaryStage.setTitle( "Home Page" );
    	            primaryStage.show();
    	       
    	    	}
    	    	catch (Exception e)
    	    	{
    	    		displayAlert(AlertType.ERROR, "Error", "Exception", e.getMessage());
    	    	}
    	    }
    	});
  	
    	
	}
    @FXML
    void SearchBookHandler(ActionEvent event) throws IOException {
      	Stage primaryStage = new Stage();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchBookMain.fxml"));
        System.out.println(getClass().getResource("SearchBookMain.fxml"));
        AnchorPane pane =(AnchorPane) loader.load();
        Scene scene = new Scene( pane );
        
        // setting the stage
        primaryStage.setScene( scene );
        primaryStage.setTitle( "Search Book" );
        primaryStage.show();

    }
    
    
	public void start(Stage primaryStage) throws Exception {
		this.mainStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
	    System.out.println(getClass().getResource("Main.fxml"));
	    AnchorPane pane =(AnchorPane) loader.load();
	    Scene scene = new Scene( pane );
	    
	   // mainClientController = (MainClientController) loader.getController();
		// setting the stage
	    primaryStage.setScene( scene );
	    primaryStage.setTitle( "Welcome to OBL" );
	    primaryStage.show();

	 }
	
	
	/**
	 * Show an Alert dialog with custom info
	 * @param type type alert
	 * @param title title window
	 * @param header header of the message
	 * @param content message
	 */
	public static void displayAlert(AlertType type , String title , String header , String content)
	{

		Platform.runLater(new Runnable() {
    	    @Override
    	    public void run() {
    			Alert alert = new Alert(type);
    			alert.setTitle(title);
    			alert.setHeaderText(header);
    			alert.setContentText(content);
    			alert.showAndWait();
    	    }
    	});
	}
	
	
	  @FXML
	    void ForgotbntHandler(ActionEvent event) {
		  
		  
	    	Platform.runLater(new Runnable() {
	    	    @Override
	    	    public void run() {
	    	    	try
	    	    	{
	    	    		mainStage.close();

	    	        	Stage primaryStage = new Stage();
	    	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Forgotpassword.fxml"));
	    	            System.out.println(getClass().getResource("Forgotpassword.fxml"));
	    	            AnchorPane pane =(AnchorPane) loader.load();
	    	            Scene scene = new Scene( pane );
	    	            
	    	            // setting the stage
	    	            primaryStage.setScene( scene );
	    	            primaryStage.setTitle( "Forgot password" );
	    	            primaryStage.show();
	    	       
	    	    	}
	    	    	catch (Exception e)
	    	    	{
	    	    		displayAlert(AlertType.ERROR, "Error", "Exception", e.getMessage());
	    	    	}
	    	    }
	    	});
	  	

	    }

}

	
	
	
	


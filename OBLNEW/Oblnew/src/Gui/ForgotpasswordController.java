package Gui;
import java.io.IOException;

import Client.Main;
import Controllers.MemberController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Gui.MainController;
public class ForgotpasswordController {

    @FXML
    private ImageView Image;

    @FXML
    private Label forgotpasswordLabel;

    @FXML
    private Label enterLabel;

    @FXML
    private Label IDLabel;

    @FXML
    private Label YearofgraduationLabel;

    @FXML
    private TextField TextFiledID;

    @FXML
    private TextField TextFiledgraduation;

    @FXML
    private Button FindMEbnt;

    @FXML
    private Button Backbnt;
    
    MainController mainController;

    @FXML
    void BackbntHandler(ActionEvent event) {
    	Platform.runLater(new Runnable() {
        @Override
	    public void run() {
	    	try
	    	{
	    		((Node) event.getSource()).getScene().getWindow().hide(); //hiding primary window
	    		
	        	Stage primaryStage = new Stage();
	        	mainController.mainStage=primaryStage;
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
	            System.out.println(getClass().getResource("Main.fxml"));
	            AnchorPane pane =(AnchorPane) loader.load();
	            Scene scene = new Scene( pane );
	            
	            // setting the stage
	            primaryStage.setScene( scene );
	            primaryStage.setTitle( "Welcome to OBL" );
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
    void FindMEbntHandler(ActionEvent event) throws IOException {
    	
    	String ID=TextFiledID.getText();
    	String graduation=TextFiledgraduation.getText();
    	if (ID.isEmpty() || graduation.isEmpty())
    	{
    		displayAlert(AlertType.ERROR, "Error", "The identification process failed", "Member ID or Year of graduation are missing!");
    		return;
    	}
    	
    	MemberController member=new MemberController();
    	member.handlelForgotpassword(ID, graduation);
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
	/**
	 * 
	 * @param pass
	 */
	
	public void handleforgotpasswordresult(String pass){
		
		System.out.println( pass);
		Platform.runLater(new Runnable() {
    	    @Override
    	    public void run() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Your password");
		alert.setHeaderText("We found a match ");
		alert.setContentText("Your lost Password is :"+ " " +pass );
		ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
		alert.getButtonTypes().setAll(okButton);
		alert.showAndWait();
    }
});
		
	}
	
	 public void initialize() {
	    	Main.client.forgotpasswordController=this;
	    }
}

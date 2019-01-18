package Gui;
import java.io.IOException;

import Client.Main;
import Gui.MainController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomepageController {

    @FXML
    private AnchorPane AnchorHome;

    @FXML
    private ImageView Image;

    @FXML
    private GridPane GrindPane;

    @FXML
    private RadioButton ByNameLabel;

    @FXML
    private ToggleGroup Search;

    @FXML
    private RadioButton ByAuthorLabel;

    @FXML
    private RadioButton ByGenreLabel;

    @FXML
    private RadioButton ByTextLabel;

    @FXML
    private TextField ByNameTextField;

    @FXML
    private TextField ByAuthorTextField;

    @FXML
    private TextField ByTextTExtField;

    @FXML
    private TextField ByGenreTextField;

    @FXML
    private Label SearchBookL;

    @FXML
    private VBox Vbox;

    @FXML
    private Label TimeL;

    @FXML
    private Label DateL;

    @FXML
    private Label NameLabel;

    @FXML
    private Button Profilebnt;

    @FXML
    private Button MyBooksbn;

    @FXML
    private Button SearchBookbnt;

    @FXML
    private ImageView SearchImage;

    @FXML
    private Button ActivityLogbnt;

    @FXML
    private Button Logoutbnt;

    @FXML
    private Button Clearbnt;

    @FXML
    private Button Searchbnt;

    @FXML
    private ImageView Imagebnt;
    MainController mainController;
     static Stage HomeStage;
    

    @FXML
    void ActivityLogbntHandler(ActionEvent event) {

    }

    @FXML
    void ClearHandler(ActionEvent event) {

    }

    @FXML
    void LogoutHandler(ActionEvent event) {

    }

    @FXML
    void MyBooksbnHandler(ActionEvent event) throws IOException {
    	
    	Platform.runLater(new Runnable() {
    	    @Override
    	    public void run() {
    	    	try
    	    	{
    	    		Main.client.HomePageController.HomeStage.close();

    	Stage primaryStage = new Stage();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MyBook.fxml"));
        System.out.println(getClass().getResource("MyBook.fxml"));
        AnchorPane pane =(AnchorPane) loader.load();
        Scene scene = new Scene( pane );
        
        // setting the stage
        primaryStage.setScene( scene );
        primaryStage.setTitle( "My Books" );
        primaryStage.show();
    	    	}
    	    	catch (Exception e)
    	    	{
    	    		//displayAlert(AlertType.ERROR, "Error", "Exception", e.getMessage());
    	    	}
    	    }
    	});
  	

    }

    @FXML
    void ProfileHandler(ActionEvent event) {

    }

    @FXML
    void SearchBookbntHandler(ActionEvent event) {

    }

    @FXML
    void SearchHandler(ActionEvent event) {

    }
    
    public void initialize() {
    	Main.client.HomePageController=this;
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
	

}

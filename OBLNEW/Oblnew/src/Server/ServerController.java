package Server;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ServerController {

    @FXML
    private AnchorPane AnchorPaneServer;

    @FXML
    private ImageView HomeImage;

    @FXML
    private Label ServerInterfaceLabel;

    @FXML
    private TextField txtPort;

    @FXML
    private Label PortLabel;

    @FXML
    private TextField txtDb;

    @FXML
    private Label DataBaseLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Label UserLabel;

    @FXML
    private TextField txtUser;

    @FXML
    private Label ServerIPLabel;

    @FXML
    private TextField txtIP;

    @FXML
    private Button StartBnt;

    @FXML
    private Button ClearBnt;
int port;
    @FXML
    void ClearBntHandler(ActionEvent event) {
    	txtIP.clear();
    	txtUser.clear();
    	txtPass.clear();
    	txtDb.clear();
    	txtPort.clear();

    }

    @FXML
    void StartBntHandler(ActionEvent event) {
    	

    	

    }
    

	/**
	 * Show the scene view of the server *
	 * 
	 * @param arg0
	 *            current stage to build
	 * @throws Exception
	 *             if failed to display
	 */
	public void start(Stage arg0) throws Exception {

		String title = "Server";
		String srcFXML = "Server.fxml";
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			arg0.setTitle(title);
			arg0.setScene(scene);
			arg0.show();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}


}

package Client;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

import Gui.*;

public class Main extends Application {
	final public static int DEFAULT_PORT = 5555;
	private static String args0, args1;
	public static CommunicationController client;
	public static MainController MainController;

	public static void main(String[] args) {

		String host = "10.0.0.8";
		client = new CommunicationController(host, DEFAULT_PORT);
		launch(args);

	}



	@Override
	public void start(Stage arg0) throws Exception {
		MainController aFrame = new MainController();

		aFrame.start(arg0);

	}
}
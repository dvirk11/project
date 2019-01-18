package Server;

import javafx.application.Application;
import javafx.stage.Stage;

public class ServerUI extends Application {

	
	
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * create GUI
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		EchoServer ser = new EchoServer(5555);
		ser.start(primaryStage);
	}

	


}

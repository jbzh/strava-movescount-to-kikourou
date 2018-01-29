package kikstrava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kikstrava.model.Config;

public class KikStravaGui extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Set proxy
			if ( Config.getConfig().isProxy() ) {
				System.setProperty("http.proxyHost", Config.getConfig().getProxyHost());
			    System.setProperty("http.proxyPort",  Config.getConfig().getProxyPort());
				System.setProperty("https.proxyHost", Config.getConfig().getProxyHost());
			    System.setProperty("https.proxyPort", Config.getConfig().getProxyPort());
			}
			
			primaryStage.initStyle(StageStyle.UTILITY);
			
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(KikStravaGui.class.getResource("view/kikstrava.fxml"));
			Parent root =  loader.load();
	       
	        Scene scene = new Scene(root, 640, 540);
	        //scene.getStylesheets().add(NeuranetGui.class.getResource("application.css").toExternalForm());
	    
	        primaryStage.setTitle("Strava to kikourou");
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
	        primaryStage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
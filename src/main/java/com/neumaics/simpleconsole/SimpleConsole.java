package com.neumaics.simpleconsole;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author neumaics
 *
 */
public class SimpleConsole extends Application{

	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("SimpleConsoleDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        
        stage.setScene(scene);
        stage.show();
	}
}

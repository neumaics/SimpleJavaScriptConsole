package com.neumaics.simpleconsole.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class SimpleConsoleController implements Initializable {
	
	@FXML
	private TextArea workPad;
	
	@FXML
	private TextArea outputPad;
	private ConsoleArea outputConsole;
	
	public void initialize(URL url, ResourceBundle rb) {
		 outputConsole = new ConsoleArea(outputPad);
		
    }
	
	@FXML
	private void runScript(ActionEvent event) {
		Long start = System.nanoTime();
		
		try {
			outputConsole.clear();
		} catch (Exception e) {
			outputConsole.write(e.getMessage() + "\n");
		} finally {
			Long end = System.nanoTime();
			outputConsole.write("\n[Finished " + (((end - start) * 100)/10000000000.0) + "]\n");
		}
	}
	
	public class ConsoleArea {
		private final TextArea outputArea;
		
		public ConsoleArea(TextArea outputArea) {
			this.outputArea = outputArea;
		}
		
		public void write(String message) {
			outputArea.appendText(message);
		}
		
		public void clear() {
			outputArea.setText("");
		}
	}
}

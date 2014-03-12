package com.neumaics.simpleconsole.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class SimpleConsoleController implements Initializable {
	
	@FXML
	private TextArea workPad;
	
	@FXML
	private TextArea outputPad;
	private ConsoleArea outputConsole;
	private final ScriptEngineManager engineManager = new ScriptEngineManager();
	private ScriptEngine engine;
	
	public void initialize(URL url, ResourceBundle rb) {
		 outputConsole = new ConsoleArea(outputPad);
		 initializeScriptEngine();
    }
	
	private void initializeScriptEngine() {
		engine = engineManager.getEngineByName("nashorn");  // TODO: consider making configurable.
		engine.put("console", outputConsole);
	}
	
	@FXML
	private void runScript(ActionEvent event) {
		Long start = System.nanoTime();
		
		try {
			outputConsole.clear();
			engine.eval(workPad.getText());
			
		} catch (Exception e) {
			outputConsole.print(e.getMessage() + "\n");
		} finally {
			Long end = System.nanoTime();
			outputConsole.print("[Finished " + (((end - start) * 100)/10000000000.0) + "]\n");
		}
	}
	
	public class ConsoleArea {
		private final TextArea outputArea;
		
		public ConsoleArea(TextArea outputArea) {
			this.outputArea = outputArea;
		}
		
		public void print(String message) {
			outputArea.appendText(message);
		}
		
		public void println(String message) {
			print(message + "\n");
		}
		
		public void clear() {
			outputArea.setText("");
		}
	}
}

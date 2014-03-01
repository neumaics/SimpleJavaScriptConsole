package com.neumaics.simpleconsole.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

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
		try {
			final Context jsContext = Context.enter();
			final Scriptable jsScope = jsContext.initStandardObjects();
			
			ScriptableObject.putProperty(jsScope, "console", Context.javaToJS(outputConsole, jsScope));
			
			outputConsole.clear();
			jsContext.evaluateString(jsScope, workPad.getText(), "<workPad>", 1, null);
			
		} catch (Exception e) {
			outputConsole.write(e.getMessage() + "\n");
		} finally {
			outputConsole.write("\n[Finished]\n");
			Context.exit();
		}
	}
	
	public void write(String message) {
		
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

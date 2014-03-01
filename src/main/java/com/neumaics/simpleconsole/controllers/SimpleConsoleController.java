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
	
	public void initialize(URL url, ResourceBundle rb) {
    	
    }
	
	@FXML
	private void runScript(ActionEvent event) {
		
	}
	
}

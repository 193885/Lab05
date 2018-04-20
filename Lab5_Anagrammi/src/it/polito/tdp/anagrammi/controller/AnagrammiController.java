/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;
import it.polito.tdp.anagrammi.model.Model;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInsert"
    private TextField txtInsert; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagramma"
    private Button btnAnagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void calcolaAnagramma(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();
  
    	if ( txtInsert.getText()==null || !txtInsert.getText().toLowerCase().matches("[a-z]+") )
    		
    		txtCorretti.setText("inserire una parola corretta");
    	
    	else {
    	 	    	   	
	    	for ( String parola : model.calcolaAnagrammi(txtInsert.getText()) ) {
	    	    		
	    		if(model.isCorrect(parola))
	    			
	    			txtCorretti.appendText(parola+"\n");
	    		
	    		else
	    			
	    			txtErrati.appendText(parola+"\n");
	  	}
    		
    		}
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtInsert.clear();
    	
    }

    public void setModel(Model model) {
    	
		this.model = model;
	}
   
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}

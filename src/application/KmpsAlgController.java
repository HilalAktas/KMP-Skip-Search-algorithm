package application;




import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


public class KmpsAlgController {
	
	ArrayList<Integer> Liste;
	
	String filename ="";
	String text = "";
	
	String sourch="";
	
	private String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
         
        try {
 
            bufferedReader = new BufferedReader(new FileReader(file));
             
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KmpsAlgController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KmpsAlgController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(KmpsAlgController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
         
        return stringBuffer.toString();
    }
	
	@FXML
	private Button btntextSecim;

	
	

	@FXML
	public ListView<Integer> indexListesi;
	
	@FXML
	private TextField
	patternSec;
	
	@FXML
	private TextField textSec;
	private String key;
	private Instant starts;

	
	@FXML
	private Label lblTime;

	
	
     @FXML
 	private Label lblSize;
	
     
     @FXML
	public void btntextSec() {
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {

			textSec.setText("File selected: " + selectedFile.getName());
			text = readFile(selectedFile);
		}
		else {
			textSec.setText("File selection cancelled.");
		}
		
		
	}
	
	
	@FXML
	public void btnRun() {
		
		try {
			if (patternSec.getText()!=null) {
				key = patternSec.getText();
				//source=textPane.getText();
				//long startTime = System.currentTimeMillis();
	            starts = Instant.now();                                         //
				java.util.List<Integer> test = kmpalg.findAll(key, text); 
		
				String sonuc=String.valueOf(test.size());
				
		       
		        
             	Instant ends = Instant.now();
          
             	Liste=new ArrayList<Integer>();
             	
             	for(Integer item:test) {
             		
             		Liste.add((item));
             		
             	}
             	
             	indexListesi.getItems().setAll(Liste);
             	
             	 lblSize.setText(sonuc);
				
			    lblTime.setText(String.valueOf(Duration.between(starts, ends)));
				// long endTime = System.currentTimeMillis();
				 //long estimatedTime = endTime - startTime;
				// double seconds = (double)estimatedTime;
				 //text_seconds.setText(Double.toString(seconds));
				
			} else {
				
			
			}		
					
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		
		
	}
	
	@FXML
	public void btntextSearch() {
		
		
		
		
		try {
			
			
			
			if (patternSec.getText()!=null) {
				key = patternSec.getText();
				//source=textPane.getText();
				//long startTime = System.currentTimeMillis();
	           
				text=textSec.getText();
				
				starts = Instant.now();                                         //
				java.util.List<Integer> test = kmpalg.findAll(key, text); 
		
				String sonuc=String.valueOf(test.size());
				
		       
		        
             	Instant ends = Instant.now();
          
             	Liste=new ArrayList<Integer>();
             	
             	for(Integer item:test) {
             		
             		Liste.add((item));
             		
             	}
             	
             	indexListesi.getItems().setAll(Liste);
             	
             	 lblSize.setText(sonuc);
				
			    lblTime.setText(String.valueOf(Duration.between(starts, ends)));
				// long endTime = System.currentTimeMillis();
				 //long estimatedTime = endTime - startTime;
				// double seconds = (double)estimatedTime;
				 //text_seconds.setText(Double.toString(seconds));
				
			} else {
				
			
			}		
					
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		
		
	}
	
	
	@FXML
	public void initialize() {
	
		
		 }
	
	
	}
	


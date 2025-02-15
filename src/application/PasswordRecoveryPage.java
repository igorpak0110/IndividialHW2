package application;

import databasePart1.DatabaseHelper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// hello
/**
 * This page displays the user three security questions to generate a temporary password that can only be used once.
 */

public class PasswordRecoveryPage {
	
	// constructor
    public PasswordRecoveryPage(DatabaseHelper databaseHelper) {}

	public void show(Stage primaryStage) {
    	VBox layout = new VBox(10);
	    layout.setStyle("-fx-alignment: center; -fx-padding: 20;");
	    
	    Label userLabel = new Label("Three security questions:");
	    userLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	 // Body of the page:
	    TextField input1= new TextField();
	    input1.setPromptText("Name the street you grew up in: ");
	    input1.setMaxWidth(250);
	    
	    TextField input2= new TextField();
	    input2.setPromptText("What was the name of your first pet: ");
	    input2.setMaxWidth(250);
	    
	    TextField input3= new TextField();
	    input3.setPromptText("Name the city you were born in:");
	    input3.setMaxWidth(250);

	    Button submitButton = new Button("Submit");
	    submitButton.setOnAction(e -> verifyAnswers(input1.getText(), input2.getText(), input3.getText()));
	    
	    layout.getChildren().addAll(userLabel, input1, input2, input3, submitButton);
	    Scene userScene = new Scene(layout, 400, 300);
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(userScene);
	    primaryStage.setTitle("Password Recovery Page");
	    primaryStage.show();
    	
    }
	
	private void verifyAnswers(String answer1, String answer2, String answer3) {
		try {
			System.out.println("Verifying answers: " + answer1 + ", " + answer2 + ", " + answer3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package application;

import databasePart1.DatabaseHelper;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * This page displays a simple welcome message for the user.
 */

public class InstructorHomePage {
	
	private final DatabaseHelper databaseHelper;

	 public InstructorHomePage(DatabaseHelper databaseHelper) {
	    	this.databaseHelper = databaseHelper;
		}

	public void show(Stage primaryStage) {
    	VBox layout = new VBox();
	    layout.setStyle("-fx-alignment: center; -fx-padding: 20;");
	    
	    // Label to greet Instructor
	    Label userLabel = new Label("Hello, Instructor!");
	    userLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	    Scene userScene = new Scene(layout, 800, 400);

	    // Set the scene to primary stage
	    primaryStage.setScene(userScene);
	    primaryStage.setTitle("Instructor Page");
	    
	 // Takes you to login page
	    Button logoutButton = new Button("Logout");
	    logoutButton.setOnAction(a -> {
	    	new UserLoginPage(databaseHelper).show(primaryStage);
	    });
	    layout.getChildren().addAll(userLabel,logoutButton);
 
    	
    }
}
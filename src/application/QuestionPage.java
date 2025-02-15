package application;

import databasePart1.DatabaseHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class QuestionPage {

    private Questions questions;

    public QuestionPage(DatabaseHelper databaseHelper) {
        this.questions = new Questions();  // Initialize a questions object to hold our question list
    }

    public void show(Stage primaryStage) {
        // Create answers for the question
        Answer answer1 = new Answer("CSE310", false);
        Answer answer2 = new Answer("CSE230", false);
        Answer answer3 = new Answer("CSE365", false);
        Answer answer4 = new Answer("CSE360", true);

        // Create a question with answers
        Question question = new Question("What class do you submit this homework for?", 
                Arrays.asList(answer1, answer2, answer3, answer4));

        // Add the question to the questions list (this is our "Create" operation)
        questions.addQuestion(question);

        // Layout to hold the question and multiple choice options
        VBox layout = new VBox(10);

        // Create a question label
        Label questionLabel = new Label(question.getQuestionText());

        // Create radio buttons for multiple choice answers
        RadioButton option1 = new RadioButton(question.getAnswers().get(0).getText());
        RadioButton option2 = new RadioButton(question.getAnswers().get(1).getText());
        RadioButton option3 = new RadioButton(question.getAnswers().get(2).getText());
        RadioButton option4 = new RadioButton(question.getAnswers().get(3).getText());

        // Group the radio buttons so only one can be selected at a time
        ToggleGroup optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);

        // Create a label to display whether the answer is correct or wrong
        Label resultLabel = new Label();

        // Button to submit the answer
        Button submitButton = new Button("Submit Answer");

        // Action when the button is clicked
        submitButton.setOnAction(e -> {
            // Check which radio button is selected and show feedback
            if (option4.isSelected() && question.getAnswers().get(3).isCorrect()) {
                resultLabel.setText("Correct!");
            } else {
                resultLabel.setText("Wrong! Try again.");
            }
        });

        // Button to update the question (Example of Update operation)
        Button updateButton = new Button("Update Question");
        updateButton.setOnAction(e -> {
            // Change the question text and the answers (Example of Update)
            question.update("Which class are you submitting homework for?", 
                Arrays.asList(new Answer("CSE110", false), new Answer("CSE230", true)));
            questionLabel.setText(question.getQuestionText());  // Update the question label
        });

        // Button to delete the question (Example of Delete operation)
        Button deleteButton = new Button("Delete Question");
        deleteButton.setOnAction(e -> {
            questions.deleteQuestion(0);  // Deleting the first question
            resultLabel.setText("Question deleted.");
        });

        // Add all components to the layout
        layout.getChildren().addAll(questionLabel, option1, option2, option3, option4, submitButton, resultLabel, updateButton, deleteButton);

        // Set up the scene and stage
        Scene userScene = new Scene(layout, 400, 300);
        primaryStage.setScene(userScene);
        primaryStage.setTitle("Question Page");
        primaryStage.show();
    }
}
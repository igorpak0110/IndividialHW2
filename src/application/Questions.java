package application;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private List<Question> questionList;

    // Constructor
    public Questions() {
        this.questionList = new ArrayList<>();
    }

    // Create; add a new question
    public void addQuestion(Question question) {
        questionList.add(question);
    }

    // Read; display all questions
    public void displayQuestions() {
        for (Question question : questionList) {
            question.read();
        }
    }

    // Update update an existing question
    public void updateQuestion(int index, String newQuestionText, List<Answer> newAnswers) {
        if (index >= 0 && index < questionList.size()) {
            questionList.get(index).update(newQuestionText, newAnswers);
        } else {
            System.out.println("Question not found.");
        }
    }

    // Delete a question
    public void deleteQuestion(int index) {
        if (index >= 0 && index < questionList.size()) {
            questionList.get(index).delete();
            questionList.remove(index);
        } else {
            System.out.println("Question not found.");
        }
    }
}
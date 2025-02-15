package application;

import java.util.ArrayList;
import java.util.List;

public class Answers {
    private List<Answer> answerList;

    // Constructor
    public Answers() {
        this.answerList = new ArrayList<>();
    }

    // Create; Add a new answer
    public void addAnswer(Answer answer) {
        answerList.add(answer);
    }

    // Read; Display all answers
    public void displayAnswers() {
        for (Answer answer : answerList) {
            answer.read();
        }
    }

    // Update an existing answer
    public void updateAnswer(int index, String newText, boolean newIsCorrect) {
        if (index >= 0 && index < answerList.size()) {
            answerList.get(index).update(newText, newIsCorrect);
        } else {
            System.out.println("Answer not found.");
        }
    }

    // Delete an answer
    public void deleteAnswer(int index) {
        if (index >= 0 && index < answerList.size()) {
            answerList.get(index).delete();
            answerList.remove(index);
        } else {
            System.out.println("Answer not found.");
        }
    }
}
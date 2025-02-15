package application;

import java.util.List;

public class Question {
    private String questionText;
    private List<Answer> answers;

    // Constructor
    public Question(String questionText, List<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    // Getters and Setters
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    // CRUD Operations
    public void create(String questionText, List<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public void read() {
        System.out.println("Question: " + questionText);
        for (Answer answer : answers) {
            answer.read();
        }
    }

    public void update(String newQuestionText, List<Answer> newAnswers) {
        this.questionText = newQuestionText;
        this.answers = newAnswers;
    }

    public void delete() {
        this.questionText = null;
        this.answers.clear();
    }
}
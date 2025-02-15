package application;

public class Answer {
    private String text;
    private boolean isCorrect;

    // Constructor
    public Answer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    // CRUD Operations
    public void create(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public void read() {
        System.out.println("Answer: " + text + " | Correct: " + isCorrect);
    }

    public void update(String newText, boolean newIsCorrect) {
        this.text = newText;
        this.isCorrect = newIsCorrect;
    }

    public void delete() {
        this.text = null;
        this.isCorrect = false;
    }
}
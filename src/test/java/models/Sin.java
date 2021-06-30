package models;

import enumerators.SinTag;

import java.util.List;

public class Sin {
    private String title;
    private String author;
    private String message;
    private List<SinTag> tags;
    private boolean forgive = false;

    public Sin(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public Sin(String title, String author, String message, List<SinTag> tags, boolean forgive) {
        this.title = title;
        this.author = author;
        this.message = message;
        this.tags = tags;
        this.forgive = forgive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SinTag> getTags() {
        return tags;
    }

    public void setTags(List<SinTag> tags) {
        this.tags = tags;
    }

    public boolean isForgive() {
        return forgive;
    }

    public void setForgive(boolean forgive) {
        this.forgive = forgive;
    }
}

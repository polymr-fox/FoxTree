package com.develop.loginov.fullstack.model;

public class Article {
    private final int id;
    private final int authorId;

    private String name;
    private String authorName;
    private String text;
    private int rate;
    private int countMessage;
    private String date;

    public Article(final int id, final int authorId, final String name, String authorName, final String text,
                   final int rate, int countMessage, final String date) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.authorName = authorName;
        this.text = text;
        this.rate = rate;
        this.countMessage = countMessage;
        this.date = date;
    }

    public static Article of(final String name,
                             final String text,
                             final String authorName,
                             final int rate,
                             final String date) {
        return new Article(0, 0, name, authorName, text, rate, 12, date);
    }

    public int getId() {
        return id;
    }

    public int getCountMessage() {
        return countMessage;
    }

    public void setCountMessage(int countMessage) {
        this.countMessage = countMessage;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

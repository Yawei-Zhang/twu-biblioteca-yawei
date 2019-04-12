package com.twu.biblioteca.models;

public class Book {
    private String name;
    private String author;
    private String publishYear;

    public Book(String bookName, String bookAuthor, String bookPublishYear) {
        name = bookName;
        author = bookAuthor;
        publishYear = bookPublishYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }
}

package com.twu.biblioteca.models;

public class Book {
    private String name;
    private String author;
    private String publishYear;
    private boolean isAvailable;

    public Book(String bookName, String bookAuthor, String bookPublishYear) {
        name = bookName;
        author = bookAuthor;
        publishYear = bookPublishYear;
        isAvailable = true;
    }

    public void handleCheckout() {
        this.isAvailable = false;
    }

    public void handleReturn() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.author + "\t" + this.publishYear;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (!(object instanceof Book))
            return false;

        Book book = (Book) object;

        return book.getName() == this.name &&
                book.getAuthor() == this.author &&
                book.getPublishYear() == this.publishYear;
    }

    public boolean isAvailable( ) {
        return this.isAvailable;
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

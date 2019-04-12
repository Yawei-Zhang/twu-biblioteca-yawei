package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;

public class BookManager {

    private ArrayList<Book> booklist;

    public BookManager() {
        booklist = new ArrayList<>();
    }

    public void listAllBooks() {
        booklist.stream().forEach(book -> System.out.println(book.getName()));
    }

    public void addBooks(String name, String author, String year) {
        booklist.add(new Book(name, author, year));
    }

    public void listAllBooksDetails() {
        booklist.stream().forEach(book -> {
            System.out.println(book.getName() + "\t" + book.getAuthor() + "\t" + book.getPublishYear());
        });
    }
}

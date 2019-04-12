package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;

public class BookManager {

    private ArrayList<Book> booklist;

    public BookManager() {
        booklist = new ArrayList<>();
        booklist.add(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        booklist.add(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));
    }

    public void listAllBooks() {
        booklist.stream().forEach(book -> System.out.println(book.getName()));
    }

    public void listAllBooksDetails() {
        booklist.stream().forEach(book -> {
            System.out.println(book.getName() + "\t" + book.getAuthor() + "\t" + book.getPublishYear());
        });
    }
}

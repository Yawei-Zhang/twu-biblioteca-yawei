package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookManager {

    private ArrayList<Book> booklist;

    public BookManager() {
        booklist = new ArrayList<>();
    }

    public ArrayList<String> getAllBooksNameList() {
        return (ArrayList<String>) this.booklist.stream().map(book -> book.getName()).collect(Collectors.toList());
    }

    public void addBooks(Book book) {
        this.booklist.add(book);
    }

    public ArrayList<Book> getBookList() {
        return this.booklist;
    }
}

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
        return (ArrayList<String>) this.booklist.stream()
                .filter(book -> book.isAvailable())
                .map(book -> book.getName())
                .collect(Collectors.toList());
    }

    public void addBooks(Book book) {
        this.booklist.add(book);
    }

    public ArrayList<Book> listAllBooksDetails() {
        return (ArrayList<Book>) this.booklist.stream()
                .filter(book -> book.isAvailable())
                .collect(Collectors.toList());
    }

    public boolean hasBook(String bookName) {
        return this.booklist.stream().filter(book -> bookName == book.getName()).count() != 0;
    }

    public boolean checkoutBook(String bookName) {
        if (this.hasBook(bookName)) {
            this.booklist.stream()
                    .filter(book -> bookName == book.getName())
                    .forEach(book -> book.checkOut());
            return true;
        }
        return false;
    }
}

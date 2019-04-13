package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookManager {

    private ArrayList<Book> booklist;

    public BookManager() {
        booklist = new ArrayList<>();
    }

    public ArrayList<String> listAllBooksName() {
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
                    .forEach(book -> book.handleCheckout());
            Printer.print("Thank you! Enjoy the Book.");
            return true;
        }
        Printer.print("Sorry, that book is not available");
        return false;
    }

    public boolean returnBook(String bookName) {
        Book book = this.getBookByName(bookName);
        if (book != null && !book.isAvailable()) {
            book.handleReturn();
            return true;
        }
        return false;
    }

    public Book getBookByName (String bookName) {
        if (this.hasBook(bookName)) {
            return this.booklist.stream().filter(book -> bookName == book.getName()).collect(Collectors.toList()).get(0);
        }
        return null;
    }
}

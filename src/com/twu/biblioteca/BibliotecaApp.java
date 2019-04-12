package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore");

        BookManager bookManager = new BookManager();
        bookManager.addBooks(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.addBooks(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));

    }

}

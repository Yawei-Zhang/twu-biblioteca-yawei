package com.twu.biblioteca;

import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Librarian {

    private BookManager bookManager;
    private String libraryNumber;
    private String password;
    private String status;

    public Librarian( BookManager bookManager, String libraryNumber, String password) {
        this.bookManager = bookManager;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.status = "logout";
    }

    public ArrayList<User> getAllUsersCheckoutBook() {
        ArrayList<User> users = (ArrayList<User>) this.bookManager.getBooklist().stream()
                .filter(book -> !book.isAvailable())
                .map(book -> book.getCheckoutUser())
                .collect(Collectors.toList());
        return users;
    }

    public boolean isLogin() {
        return this.status == "login";
    }

    public boolean login(String libraryNumber, String password) {
        if (this.isLogin()) {
            System.out.println("You've already login.");
            return true;
        }
        if(this.libraryNumber.equals(libraryNumber) && this.password.equals(password)) {
            this.status = "login";
            return true;
        }
        return false;
    }
}

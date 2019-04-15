package com.twu.biblioteca.models;

import java.util.ArrayList;

public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Book> checkoutBook;
    private String status;

    public User() {}

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkoutBook = new ArrayList<>();
        this.status = "logout";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (!(object instanceof User))
            return false;

        User user = (User) object;

        return user.getLibraryNumber() == this.libraryNumber &&
                user.getPassword() == this.password &&
                user.getName() == this.name &&
                user.getEmail() == this.email &&
                user.getPhoneNumber() == this.phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Book> getCheckoutBook() {
        return checkoutBook;
    }

    public void checkoutBook(Book book) {
        this.checkoutBook.add(book);
    }

    public void returnBook(Book book) {
        this.checkoutBook.remove(book);
    }

    public boolean login(String number, String password) {
        if (this.isLogin()) {
            System.out.println("You've already login.");
            return true;
        }
        if(this.libraryNumber.equals(number) && this.password.equals(password)) {
            this.status = "login";
            return true;
        }
        return false;
    }

    public boolean isLogin() {
        return this.status == "login";
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.email + "\t" + this.phoneNumber;
    }
}

package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Option;
import com.twu.biblioteca.models.User;

import java.util.Scanner;

public class BibliotecaApp {

    static String USER= "1";
    static String LIBRARIAN = "2";

    public static void main(String[] args) {
        Printer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore");

        BookManager bookManager = new BookManager();
        bookManager.addBooks(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.addBooks(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));

        User user1 = new User("1111","password", "Via", "via@gmail.com", "123");

        Librarian librarian = new Librarian(bookManager, "22", "password");
        Book book = new Book("1984", "George Orwell", "1949");
        User user2 = new User("3333","password", "Tina", "tina@gmail.com", "456");
        book.handleCheckout(user2);
        user2.checkoutBook(book);
        bookManager.addBooks(book);

        OptionManager optionManager = new OptionManager(bookManager);

        Scanner scanner = new Scanner(System.in);
        Printer.print("Login as:\n1.User\n2.Library");
        String identity = scanner.nextLine();
        buildOption(identity, optionManager);

        while (identity.equals(USER) && !user1.isLogin()) {
            Printer.print("Please input your library number:");
            String libraryNumber = scanner.nextLine();
            Printer.print("Please input your password:");
            String password = scanner.nextLine();
            user1.login(libraryNumber, password);
        }

        while (identity.equals(LIBRARIAN) && !librarian.isLogin()) {
            Printer.print("Please input your library number:");
            String libraryNumber = scanner.nextLine();
            Printer.print("Please input your password:");
            String password = scanner.nextLine();
            librarian.login(libraryNumber, password);
        }

        printOption(optionManager);

        String optionID = scanner.nextLine();

        if (identity.equals(USER)) {
            while (!optionID.equals(OptionManager.QUIT)) {
                if (optionManager.isValidOption(optionID))
                    optionManager.handleOption(optionID, user1);
                printOption(optionManager);
                optionID = scanner.nextLine();
            }
        } else if (identity.equals(LIBRARIAN)) {
            while (!optionID.equals(OptionManager.QUIT)) {
                if (optionManager.isValidOption(optionID))
                    optionManager.handleOption(optionID, librarian);
                printOption(optionManager);
                optionID = scanner.nextLine();
            }
        }
    }

    public static void printOption(OptionManager optionManager) {
        Printer.print("\n\nPlease choose an option in the following: ");
        Printer.print(optionManager.getOptionList());
    }

    public static void buildOption(String option, OptionManager optionManager) {
        if(option.equals(USER)) {
            optionManager.addOption(new Option("1", "List of books"));
            optionManager.addOption(new Option("2", "Checkout a book"));
            optionManager.addOption(new Option("3", "Return a book"));
            optionManager.addOption(new Option("0", "Quit"));
        }
        else if (option.equals(LIBRARIAN)) {
            optionManager.addOption(new Option("1", "List All users who checkout books"));
            optionManager.addOption(new Option("0", "Quit"));
        }
    }
}

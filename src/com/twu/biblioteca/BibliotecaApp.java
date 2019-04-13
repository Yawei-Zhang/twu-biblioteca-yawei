package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Option;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Printer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore");

        BookManager bookManager = new BookManager();
        bookManager.addBooks(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.addBooks(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));

        OptionManager optionManager = new OptionManager(bookManager);
        optionManager.addOption(new Option("1", "List of books"));
        optionManager.addOption(new Option("2", "Checkout a book"));
        optionManager.addOption(new Option("3", "Return a book"));
        optionManager.addOption(new Option("0", "Quit"));

        printOption(optionManager);

        Scanner scanner = new Scanner(System.in);
        String optionID = scanner.nextLine();

        while (!optionID.equals(OptionManager.QUIT)) {
            if (optionManager.isValidOption(optionID))
                optionManager.handleOption(optionID);
            printOption(optionManager);
            optionID = scanner.nextLine();
        }
    }

    public static void printOption(OptionManager optionManager) {
        Printer.print("\n\nPlease choose an option in the following: ");
        Printer.print(optionManager.getOptionList());
    }
}

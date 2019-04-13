package com.twu.biblioteca;

import com.twu.biblioteca.models.Option;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionManager {

    public static String QUIT = "0";
    private ArrayList<Option> optionList;
    private BookManager bookManager;

    public OptionManager() {
        this.optionList = new ArrayList<>();
    }

    public OptionManager(BookManager bookManager) {
        this.optionList = new ArrayList<>();
        this.bookManager = bookManager;
    }

    public ArrayList<Option> getOptionList() {
        return this.optionList;
    }

    public void addOption(Option option) {
        this.optionList.add(option);
    }

    public boolean isValidOption(String id) {
        return optionList.stream().anyMatch( option -> id.equals(option.getOptionID()));
    }

    public void handleOption (String id) {
        Scanner scanner = new Scanner(System.in);
        switch (id) {
            case "0":
                return;
            case "1":
                Printer.print(bookManager.listAllBooksDetails());
                break;
            case "2":
                Printer.print("Please input the book name: ");
                String bookNameCheckout = scanner.nextLine();
                bookManager.checkoutBook(bookNameCheckout);
                break;
            case "3":
                Printer.print("Please input the book name: ");
                String bookNameReturn = scanner.nextLine();
                bookManager.returnBook(bookNameReturn);
                break;
            default:
                Printer.print("Please select a valid option!");
        }
    }
}

package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookManagerTest {

    @Test
    public void should_list_all_books_when_list_all_books() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedBookList = "WHO MOVED MY CHEESE\n" + "THE LITTLE PRINCE\n";
        BookManager bookManager = new BookManager();
        bookManager.addBooks("WHO MOVED MY CHEESE", "Spencer Johnson", "1998");
        bookManager.addBooks("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943");
        bookManager.listAllBooks();
        assertEquals(expectedBookList, outContent.toString());
    }

    @Test
    public void should_list_all_books_details_when_list_all_books_details() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedBookList = "WHO MOVED MY CHEESE\tSpencer Johnson\t1998\n" +
                "THE LITTLE PRINCE\tAntoine de Saint-Exupéry\t1943\n";
        BookManager bookManager = new BookManager();
        bookManager.addBooks("WHO MOVED MY CHEESE", "Spencer Johnson", "1998");
        bookManager.addBooks("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943");
        bookManager.listAllBooksDetails();
        assertEquals(expectedBookList, outContent.toString());
    }
}
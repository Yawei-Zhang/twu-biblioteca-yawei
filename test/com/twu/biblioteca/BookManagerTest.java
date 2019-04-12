package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookManagerTest {

    @Test
    public void testListAllBooks() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedBookList = "WHO MOVED MY CHEESE\n" + "THE LITTLE PRINCE\n";
        BookManager bookManager = new BookManager();
        bookManager.listAllBooks();
        assertEquals(expectedBookList, outContent.toString());
    }

    @Test
    public void testListAllBooksDetails() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedBookList = "WHO MOVED MY CHEESE\tSpencer Johnson\t1998\n" +
                "THE LITTLE PRINCE\tAntoine de Saint-Exupéry\t1943\n";
        BookManager bookManager = new BookManager();
        bookManager.listAllBooksDetails();
        assertEquals(expectedBookList, outContent.toString());
    }
}
package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookManagerTest {
    private BookManager bookManager;

    @Before
    public void init() {
        bookManager = new BookManager();
        bookManager.addBooks(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.addBooks(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));
    }

    @Test
    public void should_get_all_books_name_when_list_all_books() {
        ArrayList<String> expectedBookList = new ArrayList<>();
        expectedBookList.add("WHO MOVED MY CHEESE");
        expectedBookList.add("THE LITTLE PRINCE");
        assertEquals(bookManager.getAllBooksNameList(), expectedBookList);
    }

    @Test
    public void should_get_all_books_details_when_list_all_books_details() {
        ArrayList<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        expectedBookList.add(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));
        assertEquals(bookManager.listAllBooksDetails(), expectedBookList);
    }

    @Test
    public void should_remove_the_book_when_the_book_is_checkouted() {
        ArrayList<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.checkoutBook("THE LITTLE PRINCE");
        assertEquals(expectedBookList, bookManager.listAllBooksDetails());
    }
}
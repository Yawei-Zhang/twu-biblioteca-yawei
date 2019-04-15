package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookManagerTest {
    private BookManager bookManager;
    private User user;

    @Before
    public void init() {
        bookManager = new BookManager();
        bookManager.addBooks(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.addBooks(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));

        user = new User("123-4567","password", "Via", "via@gmail.com", "123");
    }

    @Test
    public void should_get_all_books_name_when_list_all_books() {
        ArrayList<String> expectedBookList = new ArrayList<>();
        expectedBookList.add("WHO MOVED MY CHEESE");
        expectedBookList.add("THE LITTLE PRINCE");
        assertEquals(expectedBookList, bookManager.listAllBooksName());
    }

    @Test
    public void should_get_all_books_details_when_list_all_books_details() {
        ArrayList<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        expectedBookList.add(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));
        assertEquals(expectedBookList, bookManager.listAllBooksDetails());
    }

    @Test
    public void should_mark_the_book_not_available_when_checkout_the_book() {
        ArrayList<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        bookManager.checkoutBook("THE LITTLE PRINCE", user);
        assertEquals(expectedBookList, bookManager.listAllBooksDetails());
    }

    @Test
    public void should_mark_the_book_available_when_return_the_book() {
        ArrayList<Book> expectedBookList = new ArrayList<>();
        User user = new User("123-4567","password", "Via", "via@gmail.com", "123");
        expectedBookList.add(new Book("WHO MOVED MY CHEESE", "Spencer Johnson", "1998"));
        expectedBookList.add(new Book("THE LITTLE PRINCE", "Antoine de Saint-Exupéry", "1943"));
        bookManager.checkoutBook("THE LITTLE PRINCE", user);
        bookManager.returnBook("THE LITTLE PRINCE", user);
        assertEquals(expectedBookList, bookManager.listAllBooksDetails());
    }

    @Test
    public void should_get_the_user_when_the_user_checkout_the_book() {
        User expectedUser = new User("123-4567","password", "Via", "via@gmail.com", "123");
        assertTrue(bookManager.checkoutBook("THE LITTLE PRINCE", user));
        User checkoutUser = bookManager.getBookByName("THE LITTLE PRINCE").getCheckoutUser();
        assertEquals(expectedUser, checkoutUser);
    }
}
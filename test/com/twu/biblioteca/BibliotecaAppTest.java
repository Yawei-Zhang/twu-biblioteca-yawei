package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void testWelcome() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String welcomeSentence = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n";
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcome();
        assertEquals(welcomeSentence, outContent.toString());
    }
}

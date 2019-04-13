package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Option;

import java.util.ArrayList;

public class Printer {
    public static void print (String str) {
        System.out.println(str);
    }

    public static void print (ArrayList list) {
        list.stream().forEach(item -> System.out.println(item));
    }

}

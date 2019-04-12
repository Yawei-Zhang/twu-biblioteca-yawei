package com.twu.biblioteca;

import java.util.ArrayList;

public class Printer {
    public static void print (String str) {
        System.out.println(str);
    }

    public static void print (ArrayList<Object> list) {
        list.stream().forEach(item -> System.out.println(item));
    }
}

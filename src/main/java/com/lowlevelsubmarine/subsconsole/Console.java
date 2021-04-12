package com.lowlevelsubmarine.subsconsole;

import java.io.PrintStream;

public class Console {

    private static final PrintStream SO = System.out;

    public static void print(String string) {
        SO.print(string);
    }

    public static void print(Printable printable) {
        SO.print(printable.render());
    }

    public static void print(Object object) {
        SO.print(object.toString());
    }

    public static void print(String string, Color color) {
        SO.print(color + string + Color.RESET);
    }

    public static void print(Object object, Color color) {
       SO.print(color + object.toString() + Color.RESET);
    }

}

package com.lowlevelsubmarine.subsconsole;

public enum Color {

    RESET(0),
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    PURPLE(35),
    CYAN(36),
    WHITE(37);

    private static final String PREFIX = "\u001B[";
    private static final String SUFFIX = "m";

    private final String string;

    Color(int code) {
        this.string = PREFIX + code + SUFFIX;
    }

    public String tint(String string) {
        return this + string + Color.RESET;
    }

    @Override
    public String toString() {
        return this.string;
    }
}

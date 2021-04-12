package com.lowlevelsubmarine.subsconsole.utils;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.Printable;

public class AlignedString implements Printable {

    private static final Align DEFAULT_TEXT_ALIGN = Align.LEFT;

    private final Align align;
    private final String string;

    public AlignedString(String string) {
        this(string, DEFAULT_TEXT_ALIGN);
    }

    public AlignedString(String string, Align align) {
        this.string = string;
        this.align = align;
    }

    public String align(int length) {
        return this.align.align(this.string, length);
    }

    public String getString() {
        return this.string;
    }

    public Align getAlign() {
        return this.align;
    }

    public int getLength() {
        return this.string.length();
    }

    @Override
    public String render() {
        return getString();
    }

    @Override
    public String toString() {
        return this.string;
    }

}

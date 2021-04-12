package com.lowlevelsubmarine.subsconsole;

import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

public enum Align {

    LEFT (false, true), CENTER(true, true), RIGHT(true, false);

    private static final char DEFAULT_FILLER = ' ';

    private final boolean prefix;
    private final boolean suffix;

    Align(boolean prefix, boolean suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String align(String string, int length) {
        return align(string, length, DEFAULT_FILLER);
    }

    public String align(String string, int length, char filler) {
        if (string.length() > length) {
            return string.substring(length + 1);
        }
        int fillAmount = length - string.length();
        StringBuilder builder = new StringBuilder(string);
        for (int i = 0; i < fillAmount; i++) {
            if (this.suffix && (!this.prefix || i % 2 == 0)) {
                builder.append(filler);
            } else {
                builder.insert(0, filler);
            }
        }
        return builder.toString();
    }

    public AlignedString createString(String string) {
        return new AlignedString(string, this);
    }

}

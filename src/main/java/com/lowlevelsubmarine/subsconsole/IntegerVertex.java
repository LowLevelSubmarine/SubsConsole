package com.lowlevelsubmarine.subsconsole;

import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

import java.util.Collection;
import java.util.Comparator;

public class IntegerVertex {

    private AlignedString name;
    private int value;

    public IntegerVertex(String string, int value) {
        this(new AlignedString(string), value);
    }

    public IntegerVertex(AlignedString name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public AlignedString getName() {
        return this.name;
    }

    public static IntegerVertex longestName(Collection<IntegerVertex> vertices) {
        return vertices.stream().max(Comparator.comparingInt(vertex -> vertex.getName().getString().length())).get();
    }

    public static IntegerVertex highestValue(Collection<IntegerVertex> vertices) {
        return vertices.stream().max(Comparator.comparingInt(IntegerVertex::getValue)).get();
    }

}

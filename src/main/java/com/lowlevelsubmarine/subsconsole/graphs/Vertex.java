package com.lowlevelsubmarine.subsconsole.graphs;

public class Vertex <T> {

    private final String name;
    private final T value;

    public Vertex(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public T getValue() {
        return this.value;
    }

}

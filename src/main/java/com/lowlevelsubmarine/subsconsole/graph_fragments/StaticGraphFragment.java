package com.lowlevelsubmarine.subsconsole.graph_fragments;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.graphs.Vertex;
import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

public class StaticGraphFragment <T> implements GraphFragment <T> {

    private final AlignedString alignedString;

    public StaticGraphFragment(String string) {
        this(Align.LEFT.createString(string));
    }

    public StaticGraphFragment(AlignedString alignedString) {
        this.alignedString = alignedString;
    }

    @Override
    public AlignedString getLegend() {
        return this.alignedString;
    }

    @Override
    public AlignedString render(Vertex<T> vertex) {
        return this.alignedString;
    }

}

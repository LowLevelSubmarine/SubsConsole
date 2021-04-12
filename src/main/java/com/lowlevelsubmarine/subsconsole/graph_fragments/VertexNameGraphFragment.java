package com.lowlevelsubmarine.subsconsole.graph_fragments;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.graphs.Vertex;
import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

public class VertexNameGraphFragment <T> implements GraphFragment<T> {

    private final AlignedString legend;
    private final Align align;

    public VertexNameGraphFragment() {
        this(null, Align.LEFT);
    }

    public VertexNameGraphFragment(Align align) {
        this (null, align);
    }

    public VertexNameGraphFragment(AlignedString legend) {
        this(legend, Align.LEFT);
    }

    public VertexNameGraphFragment(AlignedString legend, Align align) {
        this.legend = legend;
        this.align = align;
    }

    @Override
    public AlignedString getLegend() {
        return this.legend;
    }

    @Override
    public AlignedString render(Vertex<T> vertex) {
        return new AlignedString(vertex.getName());
    }

}

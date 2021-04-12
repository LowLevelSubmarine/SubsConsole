package com.lowlevelsubmarine.subsconsole.graph_fragments;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.graphs.Vertex;
import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

public class VertexValueGraphFragment <T> implements GraphFragment<T> {

    private final AlignedString legend;
    private final Align align;

    public VertexValueGraphFragment() {
        this(Align.LEFT);
    }

    public VertexValueGraphFragment(AlignedString legend) {
        this(legend, Align.LEFT);
    }

    public VertexValueGraphFragment(Align align) {
        this(null, align);
    }

    public VertexValueGraphFragment(AlignedString legend, Align align) {
        this.legend = legend;
        this.align = align;
    }

    @Override
    public AlignedString getLegend() {
        return this.legend;
    }

    @Override
    public AlignedString render(Vertex<T> vertex) {
        return this.align.createString(vertex.getValue().toString());
    }

}

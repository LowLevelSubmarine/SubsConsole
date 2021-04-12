package com.lowlevelsubmarine.subsconsole.graph_fragments;

import com.lowlevelsubmarine.subsconsole.graphs.Vertex;
import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

public interface GraphFragment <T> {

    public AlignedString getLegend();
    public AlignedString render(Vertex<T> vertex);

}

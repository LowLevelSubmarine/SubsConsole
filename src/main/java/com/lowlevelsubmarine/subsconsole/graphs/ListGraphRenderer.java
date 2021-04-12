package com.lowlevelsubmarine.subsconsole.graphs;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.graph_fragments.BarGraphFragment;
import com.lowlevelsubmarine.subsconsole.graph_fragments.StaticGraphFragment;
import com.lowlevelsubmarine.subsconsole.graph_fragments.VertexNameGraphFragment;
import com.lowlevelsubmarine.subsconsole.graph_fragments.VertexValueGraphFragment;

public class ListGraphRenderer<T extends Number> extends GraphComposer<T> {
    
    public ListGraphRenderer(int barSize, double maxValue) {
        super(
                new StaticGraphFragment<>("|"),
                new VertexNameGraphFragment<>(Align.LEFT.createString("Name"), Align.LEFT),
                new VertexValueGraphFragment<>(Align.RIGHT.createString("Value"), Align.RIGHT),
                new StaticGraphFragment<>("|"),
                new BarGraphFragment<>(Align.CENTER.createString("Value"), barSize, maxValue, '=', '>', ' '),
                new StaticGraphFragment<>("|")
        );
    }

}

package com.lowlevelsubmarine.subsconsole.graph_fragments;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.graphs.Vertex;
import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

public class BarGraphFragment <T extends Number> implements GraphFragment<T> {

    private final AlignedString legend;
    private final int size;
    private final double maxValue;
    private final char fillChar;
    private final char edgeChar;
    private final char spaceChar;

    public BarGraphFragment(double maxValue) {
        this(null, maxValue);
    }

    public BarGraphFragment(AlignedString legend, double maxValue) {
        this(legend, 20, maxValue);
    }

    public BarGraphFragment(int size, double maxValue) {
        this(null, size, maxValue);
    }

    public BarGraphFragment(AlignedString legend, int size, double maxValue) {
        this(legend, size, maxValue, '#', ' ');
    }

    public BarGraphFragment(AlignedString legend, int size, double maxValue, char fillChar, char spaceChar) {
        this(legend, size, maxValue, fillChar, fillChar, spaceChar);
    }

    public BarGraphFragment(AlignedString legend, int size, double maxValue, char fillChar, char edgeChar, char spaceChar) {
        this.size = size;
        this.legend = legend;
        this.maxValue = maxValue;
        this.fillChar = fillChar;
        this.edgeChar = edgeChar;
        this.spaceChar = spaceChar;
    }

    @Override
    public AlignedString getLegend() {
        return this.legend;
    }

    @Override
    public AlignedString render(Vertex<T> vertex) {
        StringBuilder builder = new StringBuilder();
        long edge = Math.round(vertex.getValue().doubleValue() / this.maxValue * this.size);
        for (int i = 0; i < size; i++) {
            if (i < edge) {
                builder.append(this.fillChar);
            } else if (i == edge) {
                builder.append(this.edgeChar);
            } else {
                builder.append(this.spaceChar);
            }
        }
        return Align.LEFT.createString(builder.toString());
    }

}

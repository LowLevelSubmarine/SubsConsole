package com.lowlevelsubmarine.subsconsole.graphs;

import com.lowlevelsubmarine.subsconsole.Align;
import com.lowlevelsubmarine.subsconsole.Printable;
import com.lowlevelsubmarine.subsconsole.graph_fragments.GraphFragment;
import com.lowlevelsubmarine.subsconsole.utils.AlignedString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GraphComposer<T> implements Printable {

    private final GraphFragment<T>[] fragments;
    private List<Vertex<T>> vertices = new LinkedList<>();

    public GraphComposer(GraphFragment<T>... fragments) {
        this.fragments = fragments;
    }

    public void addVertex(Vertex<T> vertex) {
        this.vertices.add(vertex);
    }

    public void addVertices(Vertex<T>... vertices) {
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public void setVertices(Vertex<T>... vertices) {
        this.vertices = new LinkedList<>(Arrays.asList(vertices));
    }

    @Override
    public String render() {
        LinkedList<LinkedList<String>> columns = new LinkedList<>();
        for (GraphFragment<T> fragment : this.fragments) {
            LinkedList<AlignedString> fragments = new LinkedList<>();
            AlignedString legend = fragment.getLegend();
            if (legend != null) {
                fragments.add(fragment.getLegend());
            } else {
                fragments.add(Align.LEFT.createString(""));
            }
            for (Vertex<T> vertex : this.vertices) {
                fragments.add(fragment.render(vertex));
            }
            int maxFragmentLength = fragments.stream().max(Comparator.comparingInt(AlignedString::getLength)).get().getLength();
            LinkedList<String> column = new LinkedList<>();
            for (AlignedString alignedString : fragments) {
                column.add(alignedString.align(maxFragmentLength));
            }
            columns.add(column);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columns.getFirst().size(); i++) {
            for (LinkedList<String> column : columns) {
                builder.append(column.get(i));
            }
            if (i != columns.getFirst().size()-1) builder.append("\n");
        }
        return builder.toString();
    }

}

package testing;

import com.lowlevelsubmarine.subsconsole.Console;
import com.lowlevelsubmarine.subsconsole.graphs.ListGraphRenderer;
import com.lowlevelsubmarine.subsconsole.graphs.Vertex;

import java.util.Random;

public class Testing {

    public static void main(String[] args) {
        String[] names = {"Jonas Ehre", "Julians Ehre", "Johannas Ehre", "Luisas Ehre", "Flos Ehre"};
        ListGraphRenderer<Integer> ehrenGraph = new ListGraphRenderer<>(40, 50);
        Random random = new Random();
        for (int i = 0; i < names.length; i++) {
            ehrenGraph.addVertex(new Vertex<>(names[i], random.nextInt(51)));
        }
        Console.print(ehrenGraph);
    }

}

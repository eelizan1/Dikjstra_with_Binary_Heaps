package FinalDikjstra;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by eeliz_000 on 3/24/2017.
 *
 *  This class holds the algorithm to find the shortest path.
 *
 *  Main Components:
 *      ShortestPath map
 *      Binary Heap data structure
 *      Distance map to store the shortest distance
 */
public class DijkstraAlgorithm {

    // function takes in a graph and the source vertex
    // called from the main method
    public Map<Vertex<Integer>,Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {

        //heap + map data structure
        BinaryHeap<Vertex<Integer>> minHeap = new BinaryHeap<>();

        // stores shortest distance from root to every vertex
        Map<Vertex<Integer>, Integer> distance = new HashMap<>();

        //stores parent of every vertex in shortest distance
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

        //initialize all vertex with infinite distance from source vertex
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            minHeap.add(Integer.MAX_VALUE, vertex);
        }

        //set distance of source vertex to 0
        minHeap.decrease(sourceVertex, 0);

        //put it in map
        distance.put(sourceVertex, 0);

        //source vertex parent is null
        parent.put(sourceVertex, null);

        //iterate till heap is not empty
        while (!minHeap.empty()) {
            //get the min value from heap node which has vertex and distance of that vertex from source vertex.
            BinaryHeap<Vertex<Integer>>.Node heapNode = minHeap.getMinNode();
            Vertex<Integer> current = heapNode.key;

            //update shortest distance of current vertex from source vertex
            distance.put(current, heapNode.weight);

            //iterate through all edges of current vertex
            for (Edge<Integer> edge : current.getEdges()) {

                //get the adjacent vertex
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);

                //if heap does not contain adjacent vertex means adjacent vertex already has shortest distance from source vertex
                if (!minHeap.containsData(adjacent)) {
                    continue;
                }

                //add distance of current vertex to edge weight to get distance of adjacent vertex from source vertex
                //when it goes through current vertex
                int newDistance = distance.get(current) + edge.getEdgeCost();

                //see if this above calculated distance is less than current distance stored for adjacent vertex from source vertex
                if (minHeap.getWeight(adjacent) > newDistance) {
                    minHeap.decrease(adjacent, newDistance);
                    parent.put(adjacent, current);
                }
            }
        }
        return distance;
    }

    // Initialize vertex
    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getStartingVertex().equals(v) ? e.getEndingVertex() : e.getStartingVertex();
        }

}

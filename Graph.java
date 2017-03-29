package FinalDikjstra;

import java.util.*;

/*
 * Created by eeliz_000 on 3/24/2017.
 * This class uses Vertex and Edge class to construct the graph map
 * Graph will be called file class to construct graph from files
 *
 * Main Components:
 *      List of edges
 *      List of vertices
 */
public class Graph<T> {
    // all edges in the graph
    private List<Edge<T>> graphEdges;
    // all vertices in the graph through Hash Map
    private Map<Long, Vertex<T>> graphVertices;
    boolean graphDirected = false;

    // graph constructor
    public Graph(boolean graphDirected) {
        graphEdges = new ArrayList<Edge<T>>();
        graphVertices = new HashMap<Long, Vertex<T>>();
        // delcare if graph is directed or not during initialization
        this.graphDirected = graphDirected;
    }

    /*
        Utalizing Edge and Vertex class
     */

    // contructor to get vertex
    public Vertex<T> getVertex(long id) {
        return graphVertices.get(id);
    }

    // adds edge to the graph
    public void addEdge(long v1,long v2, int edgeCost) {
        Vertex<T> startvertex = null;
        if(graphVertices.containsKey(v1)){
            startvertex = graphVertices.get(v1);
        }else{
            startvertex= new Vertex<T>(v1);
            graphVertices.put(v1, startvertex);
        }
        Vertex<T> endvertex = null;
        if(graphVertices.containsKey(v2)){
            endvertex = graphVertices.get(v2);
        }else{
            endvertex = new Vertex<T>(v2);
            graphVertices.put(v2, endvertex);
        }

        // adds edge from starting vertex to ending vertex
        Edge<T> edge = new Edge<T>(startvertex,endvertex,graphDirected,edgeCost);
        graphEdges.add(edge);
        startvertex.addAdjacentVertex(edge, endvertex);
        if(!graphDirected){
            endvertex.addAdjacentVertex(edge, startvertex);
        }

    }

    public List<Edge<T>> getAllEdges(){
        return graphEdges;
    }

    public Collection<Vertex<T>> getAllVertex(){
        return graphVertices.values();
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getStartingVertex() + " " + edge.getEndingVertex() + " " + edge.getEdgeCost());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}




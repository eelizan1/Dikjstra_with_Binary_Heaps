package FinalDikjstra;

/*
 * Created by eeliz_000 on 3/24/2017.
 * Used by the graph class
 */
public class Edge<T> {
    private boolean graphDirected = false;
    // starting vertex
    private Vertex<T> startingVertex;
    // ending vertex
    private Vertex<T> endingVertex;
    private int edgeCost;

    // Edge constructor to initialize an edge from starting vertex to vertex 2
    Edge(Vertex<T> startingVertex, Vertex<T> endingVertex, boolean graphDirected, int edgeCost) {
        this.startingVertex = startingVertex;
        this.endingVertex = endingVertex;
        this.graphDirected = graphDirected;
        this.edgeCost = edgeCost;
    }

    //  getters for start and final vertex
    Vertex<T> getStartingVertex() {
        return startingVertex;
    }

    Vertex<T> getEndingVertex() {
        return endingVertex;
    }

    int getEdgeCost() {
        return edgeCost;
    }

    // OVERRIDE METHODS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((startingVertex== null) ? 0 : startingVertex.hashCode());
        result = prime * result + ((endingVertex == null) ? 0 : endingVertex.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (startingVertex == null) {
            if (other.startingVertex != null)
                return false;
        } else if (!startingVertex.equals(other.startingVertex))
            return false;
        if (endingVertex == null) {
            if (other.endingVertex != null)
                return false;
        } else if (!endingVertex.equals(other.endingVertex))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + graphDirected + ", vertex1=" + startingVertex
                + ", vertex2=" + endingVertex + ", weight=" + edgeCost + "]";
    }
}

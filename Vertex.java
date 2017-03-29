package FinalDikjstra;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by eeliz_000 on 3/24/2017.
 * Vertex class will be used by the graph class
 */
public class Vertex<T> {
    long id;
    private T data;

    // list of adjacent edges
    private List<Edge<T>> edgeList = new ArrayList<>();
    // list of adjacent vertices
    private List<Vertex<T>> adjacentVertices = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }
    // getters and setters of vertex class
    public long getId(){
        return id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString(){

        return String.valueOf(id);
    }

    public List<Edge<T>> getEdges(){

        return edgeList;
    }

    // adds adjacent vertex and puts in the adjaceny list
    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex) {
        edgeList.add(edge);
        adjacentVertices.add(vertex);
    }

    /****************************************************
     * Override methods
     ****************************************************/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

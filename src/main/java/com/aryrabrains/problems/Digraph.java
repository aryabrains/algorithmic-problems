package com.aryrabrains.problems;

import java.util.ArrayList;
import java.util.List;

class Digraph {
    private int numberOfVertices;
    private int numberOfEdges;
    private List<Integer>[] edges;

    public Digraph(int numberOfVertices) {
        if (numberOfVertices < 0) {
            throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        }
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        this.edges = (List<Integer>[]) new List[numberOfVertices];
    }

    /** Adds the directed edge v→w to this graph. */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if (edges[v] == null) {
            edges[v] = new ArrayList<Integer>();
        }
        edges[v].add(w);
        numberOfEdges++;
    }

    /** Returns the vertices adjacent to vertex {@code v}. */
    public Iterable<Integer> adjacent(int v) {
        validateVertex(v);
        if (edges[v] == null) {
            edges[v] = new ArrayList<Integer>();
        }
        return edges[v];
    }

    /** Returns the number of edges in this graph. */
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    /** Returns the number of vertices in this graph. */
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= numberOfVertices) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (numberOfVertices-1));
        }
    }
}

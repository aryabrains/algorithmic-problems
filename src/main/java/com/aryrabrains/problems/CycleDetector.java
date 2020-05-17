package com.aryrabrains.problems;

import java.util.Collections;
import java.util.Stack;

public class CycleDetector {
    private boolean[] marked;     // marked[v] = whether v has been visited
    private int[] edgeTo;         // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;    // onStack[v] = whether the vertex is on the stack
    private Stack<Integer> cycle;  // directed cycle (or null if no such cycle)
    private int numVertices;

    public CycleDetector(Digraph graph) {
        this.numVertices = graph.getNumberOfVertices();
        marked = new boolean[this.numVertices];
        onStack = new boolean[this.numVertices];
        edgeTo = new int[this.numVertices];
        for(int i=0; i < numVertices; i++) {
            if(!this.marked[i] && cycle == null)
                dfs(graph, i);
        }
    }

    private void dfs(Digraph graph, int v) {
        this.marked[v] = true;
        this.onStack[v] = true;
        for (int adjVertex : graph.adjacent(v)) {
            if(cycle != null) return;
            else if (!this.marked[adjVertex]) {
                edgeTo[adjVertex] = v;
                dfs(graph, adjVertex);
            } else if (onStack[adjVertex]) {
                cycle = new Stack<Integer>();
                for (int i = v; i != adjVertex; i = edgeTo[i]) {
                    System.out.println("i: " + i);
                    cycle.push(i);
                }
                cycle.push(adjVertex);
                cycle.push(v);
            }
        };
        this.onStack[v] = false;
    }

    private boolean check() {
        if (hasCycle()) {
            // verify cycle
            int firstVertex = -1;
            int lastVertex = -1;
            for (int v : cycle()) {
                if (firstVertex == -1) firstVertex = v;
                lastVertex = v;
            }
            if (firstVertex != lastVertex) {
                return false;
            }
        }
        return true;
    }

    /** Returns whether the directed graph contains a cycle. */
    public boolean hasCycle() {
        return cycle != null;
    }

    /** Returns the vertices of a directed cycle in the graph and null if there is no cycle */
    public Iterable<Integer> cycle() {
        Collections.reverse(cycle);
        return cycle;
    }


    public static void main(String[] args) {
        Digraph graph = new Digraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        CycleDetector detector = new CycleDetector(graph);
        for(Integer x : detector.cycle()) {
            System.out.println(x);
        }
    }
}

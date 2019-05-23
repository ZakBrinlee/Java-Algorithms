import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BreadthFirstPaths {
    private final int N; 	   //start vertex
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path

    public BreadthFirstPaths(SymbolGraph G, int start) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.N = start;
        bfs(G, start);

        //assert check(G, s);
    }

    // breadth-first search from a single source
    private void bfs(SymbolGraph G, int s) {

        Queue<Integer> queue = new LinkedList<Integer>();
        marked[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int v = queue.remove();
            for(int w : G.adjacent(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }//end of single source bfs


    public boolean hasPathTo(int v) {
        return marked[v];
    }//end of hasPathTo

    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<Integer>();

        for (int x = v; x != N; x = edgeTo[x])
            path.push(x);
        path.push(N);
        return path;
    }//end of Iterable

}//end of BreadthFirstPaths
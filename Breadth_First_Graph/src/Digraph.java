import java.util.Scanner;

public class Digraph {
    private final int V; //number of vertices
    private int E;       //number of edges
    private Bag<Integer>[] adj; //adjaceny list using Bag

    public Digraph(int V) {//creates array of empty list
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Digraph(Scanner input) {
        this(input.nextInt());    //first number in file is V
        int N = input.nextInt();  //second number in file is number of edges
        for(int i = 0; i < N; i++) {
            int n1 = input.nextInt(); //read first column vertex
            int n2 = input.nextInt(); //read second column vertex
            addEdge(n1, n2);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);//this will add w to v's list
        E++;//increase E number
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }
}
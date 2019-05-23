import java.util.*;
import java.io.*;

public class SymbolGraph {

    //testing with main
    public static void main(String[] args) throws FileNotFoundException {

        //code for assignment 7
//		String choice = "y";
//		SymbolGraph G = new SymbolGraph(new File("Routes.csv"));
//
//		Scanner sc = new Scanner(System.in);
//		while(choice.equalsIgnoreCase("y")){
//			System.out.print("Enter which airport you want to fly out of: ");
//			String start = sc.next().toUpperCase();
//			//Scanner input = new Scanner(in);
//			System.out.print("Enter which airport you want to fly to: ");
//			String end = sc.next().toUpperCase();
//
//			int airport1 = G.indexOf(start);
//			int airport2 = G.indexOf(end);
//			BreadthFirstPaths dfs = new BreadthFirstPaths(G, airport1);
//
//			System.out.println();
//
//	        if(dfs.hasPathTo(airport2)) {
//	        	System.out.println("This route is possible.");
//	        }
//	        else {
//	        	System.out.println("This route is not possible, drive!");
//	        }
//
//	        System.out.println("Test another flight? (y/n): ");
//	        choice = sc.next();
//		}//end of while loop
//
//        System.out.println("Bye!");
//		System.exit(0);
//		sc.close();


        //Code for assignment8
        String choice = "y";
        SymbolGraph G = new SymbolGraph(new File("Routes.csv"));
        int s = 1; // paths from 0
        Scanner sc = new Scanner(System.in);
        while(choice.equalsIgnoreCase("y")){
            System.out.print("Enter which airport you want to fly out of: ");
            String start = sc.next().toUpperCase();
            //Scanner input = new Scanner(in);
            System.out.print("Enter which airport you want to fly to: ");
            String end = sc.next().toUpperCase();

            int airport1 = G.indexOf(start);
            int airport2 = G.indexOf(end);
            BreadthFirstPaths dfs = new BreadthFirstPaths(G, airport2);

            System.out.println();

            if (dfs.hasPathTo(airport1)) {
                System.out.printf(start + " to " + end + ": ");
                for (int x : dfs.pathTo(airport1)) {
                    if(x == s) { System.out.print(G.nameOf(x)); }
                    else { System.out.print(G.nameOf(x) + "-"); }
                }//end of for
                System.out.println();//extra line for cleaner look
            }
            else {
                System.out.printf("%d to %d:  not connected\n", start, end);
            }

            System.out.print("Test another flight? (y/n): ");
            choice = sc.next();
        }//end of while loop

        System.out.println("Bye!");
        System.exit(0);
        sc.close();



//
//      System.out.println();//extra line for cleaner look
//
//      if(dfs.hasPathTo(s)) {
//      	System.out.println("Yes");
//      }
//      else {
//      	System.out.println("No");
//      }
//
//      System.out.println();//extra line for cleaner look
//
//      int test1 = G.indexOf("PDX");
//		  int test2 = G.indexOf("KZN");
//		  System.out.println(test1 + " " + test2);

    }//end of main


    private HashMap<String, Integer> graphMap;  // string -> index
    private String[] keys;           // index  -> string
    private Digraph G;


    public SymbolGraph(File filename) throws FileNotFoundException {

        graphMap = new HashMap<String, Integer>();

        Scanner sc1 = new Scanner(filename);
        // First pass builds the index by reading strings to associate
        // distinct strings with an index

        while(sc1.hasNextLine()) {
            String s = sc1.nextLine();
            Scanner input = new Scanner(s).useDelimiter(",");
            String skip = input.next();
            while(input.hasNext()) {
                String key = input.next();
                if(!graphMap.containsKey(key)) {
                    graphMap.put(key, graphMap.size());
                }
            }
        }

        System.out.println("Done reading " + filename);

        // inverted index to get string keys in an array
        keys = new String[graphMap.size()];
        for (String name : graphMap.keySet()) {
            keys[graphMap.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others

        G = new Digraph(graphMap.size());

        Scanner sc2 = new Scanner(filename);

        while (sc2.hasNextLine()) {
            String s2 = sc2.nextLine();
            Scanner input2 = new Scanner(s2).useDelimiter(",");
            String skip2 = input2.next();
            if(input2.hasNext()) {
                int v = graphMap.get(input2.next());

                while(input2.hasNext()) {
                    G.addEdge(v, graphMap.get(input2.next()));
                }//end of while
            }//end of if
        }//end of while
    }//end of constructor

    public int V() {
        return G.V();
    }

    public Iterable<Integer> adjacent(int v) {
        return G.adj(v);
    }

    public Digraph G() {
        return G;
    }

    public int E() {
        return G.E();
    }

    public int indexOf(String s) {
        return graphMap.get(s);
    }

    public String nameOf(int v) {
        return keys[v];
    }

}
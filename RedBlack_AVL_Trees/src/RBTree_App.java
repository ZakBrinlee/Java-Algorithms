import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RBTree_App {

    /*
     * AD325 - Program 5
     *
     * Write two programs.  The first one must utilize a red black tree; the second must utilize an AVL tree.
     * Include code necessary for timing of the load of the tree, the time to add nodes, and the time to delete nodes.
     * There are three files added to this assignment.  The first (SBT1.txt) is for the initial load of the tree.
     * The second (SBT2.txt) is for the addition of nodes.  The third (SBT3.txt) is for the deletion of nodes.
     *
     * It does not matter how you utilize the files since the timings should be places immediately adjacent
     *  to the code that either loads, add, or deletes nodes.
     *  Provide the code and a report (console print is fine) for the timings for the three functions for each of the two trees.
     */

    private Node root;

    private static class Node {
        private int key;
        private int balance;
        private int height;
        private Node left;
        private Node right;
        private Node parent;

        Node(int key, Node parent) {
            this.key = key;
            this.parent = parent;
        }
    }//end of class node

    public boolean insert(int key) {
        if (root == null) {
            root = new Node(key, null);
            return true;
        }

        Node n = root;
        while (true) {
            if (n.key == key)
                return false;

            Node parent = n;

            boolean goLeft = n.key > key;
            n = goLeft ? n.left : n.right;

            if (n == null) {
                if (goLeft) {
                    parent.left = new Node(key, parent);
                } else {
                    parent.right = new Node(key, parent);
                }
                rebalance(parent);
                break;
            }
        }
        return true;
    }//end of insert

    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                rebalance(parent);
            }
            return;
        }

        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.key = child.key;
            delete(child);
        }
    }//end of delete

    public void delete(int delKey) {
        if (root == null)
            return;

        Node child = root;
        while (child != null) {
            Node node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }//end of delete

    private void rebalance(Node n) {
        setBalance(n);

        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);

        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }//end of rebalance

    private Node rotateLeft(Node a) {

        Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null)
            a.right.parent = a;

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }//end of rotateLeft

    private Node rotateRight(Node a) {

        Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null)
            a.left.parent = a;

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }//end of rotateRight

    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }


    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        RBTree_App tree = new RBTree_App();

        Scanner s = new Scanner(new File("SBT1.txt"));
        int [] sbt1 = new int [25];
        int i = 0;
        while(s.hasNextInt()){
            sbt1[i++] = s.nextInt();
        }

        Scanner sc = new Scanner(new File("SBT2.txt"));
        int [] sbt2 = new int [6];
        int l = 0;
        while(sc.hasNextInt()){
            sbt2[l++] = sc.nextInt();
        }

        Scanner sca = new Scanner(new File("SBT3.txt"));
        int [] sbt3 = new int [6];
        int m = 0;
        while(sca.hasNextInt()){
            sbt3[m++] = sca.nextInt();
        }

        System.out.println(Arrays.toString(sbt1));
        System.out.println(Arrays.toString(sbt2));
        System.out.println(Arrays.toString(sbt3));

        System.out.println("Inserting values from SBT1");
        long startTime = System.nanoTime();
        for(int j = 0; j < sbt1.length; j++ ){
            tree.insert(sbt1[j]);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("SBT1 Insertion Timer: " + duration + " nanoseconds");



        System.out.println("Inserting values from SBT2");
        long startTime2 = System.nanoTime();
        for(int k = 0; k < sbt2.length; k++ ){
            tree.insert(sbt2[k]);
        }
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("SBT2 Insertion Timer: " + duration2 + " nanoseconds");


        System.out.println("Deleting file SB2 integers...");

        long startTime3 = System.nanoTime();
        for(int k = 0; k < sbt3.length; k++ ){
            tree.delete(sbt3[k]);
        }
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        System.out.println("SBT2 Deletion Timer: " + duration3 + " nanoseconds");
    }//end of main
}

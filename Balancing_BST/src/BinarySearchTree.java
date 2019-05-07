import java.util.Vector;

class BinarySearchTree {

    BSTNode root = new BSTNode(0);

    // Constructor
    BinarySearchTree() {
        root = null;
    }// end of constructor

    // This method calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }// end of insert

    // A recursive function to insert a new key in BST
    BSTNode insertRec(BSTNode root, int key) {

        // If the tree is empty, return a new node
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // return the (unchanged) node pointer
        return root;

    }// end of insertRecursively

    // This method calls InorderRec()
    void inorder() {
        inorderRec(root);
    }// end of inorder

    // A utility function to do inorder traversal of BST
    void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);

            System.out.println(root.key);

            inorderRec(root.right);
        }
    }// end of inorderRec

    /*
     * Helper function for getLevel(). It returns level of the data if data is
     * present in tree, otherwise returns 0.
     */
    int getLevelUtil(BSTNode root, int value, int level) {
        if (root == null)
            return 0;

        if (root.key == value)
            return level;

        int downlevel = getLevelUtil(root.left, value, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(root.right, value, level + 1);
        return downlevel;
    }

    // Returns level of given data value
    int getLevel(BSTNode root, int value) {
        return getLevelUtil(root, value, 1);
    }

    /*
     * This function traverse the unbalanced binary tree and stores its nodes pointers
     * in vector nodes[]
     */
    void storeBSTNodes(BSTNode root, Vector<BSTNode> nodes) {
        // Base case
        if (root == null)
            return;

        // Store nodes in Inorder (which is sorted order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    // Recursive function to construct binary tree
    BSTNode buildTreeUtil(Vector<BSTNode> nodes, int start, int end) {
        // base case
        if (start > end)
            return null;

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        BSTNode node = nodes.get(mid);

        /*
         * Using index in Inorder traversal, construct left and right subtress
         */
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    // This functions converts an unbalanced BST to a balanced BST
    BSTNode buildTree(BSTNode root) {
        // Store nodes of given BST in sorted order
        Vector<BSTNode> nodes = new Vector<BSTNode>();
        storeBSTNodes(root, nodes);

        // Constucts BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    // Function to do preorder traversal of tree
    void preOrder(BSTNode node)
    {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void searchTree(BinarySearchTree tree)
    {
        int[] searchNums = { 14, 95, 90, 35, 17, 63, 35, 62 };
        for (int x : searchNums) {
            int level = tree.getLevel(tree.root, x);
            if (level != 0)
                System.out.println("Level of " + x + " is " + tree.getLevel(tree.root, x));
            else
                System.out.println(x + " is not present in tree");
        } // end of for loop
    }
}// end of class
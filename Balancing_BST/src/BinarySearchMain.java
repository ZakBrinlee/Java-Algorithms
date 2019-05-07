
public class BinarySearchMain
{

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /*
         * Creating the following BST with 9.2 additions
         *
         * 							18
         * 	   					   /  \
         * 						 14    20
         * 								\
         * 							     22
         * 							    /  \
         * 							  21   36
         * 								  /  \
         * 								34     57
         * 								  \   /  \
         *                                35 37   61
         * 							             /  \
         * 									   60    79
         * 											/  \
         * 										  62    81
         * 											     \
         * 												  95
         * 												 /
         *  											90
         */
        tree.insert(18);
        tree.insert(14);
        tree.insert(20);
        tree.insert(22);
        tree.insert(36);
        tree.insert(57);
        tree.insert(61);
        tree.insert(21);
        tree.insert(79);
        tree.insert(60);
        tree.insert(81);
        tree.insert(95);
        tree.insert(90);

        // inserts from 9.2
        tree.insert(34);
        tree.insert(35);
        tree.insert(37);
        tree.insert(62);

        // print preOrder traversal of the BST
        System.out.println("Preorder traversal of un-balanced BST is :");
        tree.preOrder(tree.root);

        System.out.println();
        System.out.println();

        //rebuild tree to be balanced
        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);

        /*
         * BST after being balanced
         *
         * 						  ----37----
         * 	   				     /          \
         * 					    /            \
         * 					  21              62
         * 					/    \          /    \
         * 				  18      34      60      81
         * 				 /  \    /  \    /  \    /  \
         * 			   14	 20	22	 35	57  61  79  90
         * 							  \               \
         * 							  36               95
         */

        System.out.println();
        System.out.println();

        //method for searched numbers
        tree.searchTree(tree);
    }

}

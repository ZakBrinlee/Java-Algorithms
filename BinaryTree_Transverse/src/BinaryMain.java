public class BinaryMain {

    public static void main(String[] args)
    {
        char character = 0;
        char[] letters = { 'E', 'C', 'D', 'B', 'A', 'H', 'F', 'G', 'I' };

        BinaryTree tree = new BinaryTree(character);

        for(char i : letters)
        {
            tree.addNode(i);
        }

        System.out.print("PreOrder: ");
        tree.traversePreOrder();

        System.out.println();

        System.out.print("InOrder: ");
        tree.traverseInOrder();

        System.out.println();

        System.out.print("PostOrder: ");
        tree.traversePostOrder();
    }//end of main

}//end of class

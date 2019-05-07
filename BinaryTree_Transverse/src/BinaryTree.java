
public class BinaryTree {

    public char character;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(char letter) {
        this.character = letter;
        this.left = null;
        this.right = null;
    }// end of constructor

    // As a convention, if the key to be inserted is less than the key of root
    // node, then key is inserted in
    // left sub-tree; If key is greater, it is inserted in right sub-tree. If it
    // is equal, as a convention, it
    // is inserted in right sub-tree
    public void addNode(char letter)
    {
        Character.getNumericValue(letter);
        Character.getNumericValue(character);
        if (letter < this.character)
        {
            if (this.left != null)
            {
                this.left.addNode(letter);
            }
            else
            {
                this.left = new BinaryTree(letter);
            }

        }
        else
        {
            if (this.right != null)
            {
                this.right.addNode(letter);
            }
            else
            {
                this.right = new BinaryTree(letter);
            }

        }
    }//end of addNode

    // Visit the node first, then left and right sub-trees
    public void traversePreOrder()
    {
        System.out.print(this.character + " ");
        if (this.left != null)
        {
            this.left.traversePreOrder();
        }
        if (this.right != null)
        {
            this.right.traversePreOrder();
        }

    }//end of PreOrder

    public void traverseInOrder()
    {
        if (this.left != null)
        {
            this.left.traverseInOrder();
        }

        System.out.print(this.character + " ");

        if (this.right != null)
        {
            this.right.traverseInOrder();
        }
    }//end of InOrder

    // Visit left sub-tree, then right sub-tree and then the node
    public void traversePostOrder()
    {
        if (this.left != null)
        {
            this.left.traversePostOrder();
        }
        if (this.right != null)
        {
            this.right.traversePostOrder();
        }
        System.out.print(this.character + " ");
    }

}// end of BinaryTree class



package BinarySearchTree;

public class BinarySearchService {
    Node root;

    public void insert(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right =null;
        Node traverse = root;
        while(true)
        {
            if(traverse == null)
            {
                root = newNode;
                break;
            }
            else if(traverse.data < newNode.data)
            {
                if(traverse.right == null)
                {
                    traverse.right = newNode ;
                    break;
                }
                traverse = traverse.right;
            }
            else
            {
                if(traverse.left == null)
                {
                    traverse.left = newNode ;
                    break;
                }
                traverse = traverse.left;
            }
        }

    }
}

import java.util.Scanner;

public class BinaryTree {
    /*
        1. Binary Tree class has two members: Node root and int size
        2. Has a child class of type Node
        3. Node class has 3 members: Node left, Node right and int data
     */
    public class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node right, Node left){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    Node root;
    int size;
    BinaryTree() {
        this.size = 0;
        Scanner s = new Scanner(System.in);
        this.root = takeInput(s, null, false);
    }

    public Node takeInput(Scanner s, Node parent, boolean isLeft) {
        if(null == parent) {
            System.out.println("Enter data for root node");
        } else {
            if(isLeft) {
                System.out.println("Enter data for left child of "+ parent.data);
            } else {
                System.out.println("Enter data for right child of "+ parent.data);
            }
        }
        int nodeData = s.nextInt();
        Node node = new Node(nodeData, null, null);
        this.size++;

        boolean choice = false;
        System.out.println("Do you have left child of "+ node.data);
        choice = s.nextBoolean();
        if(choice) {
            node.left = takeInput(s, node, true);
        }

        choice = false;
        System.out.println("Do you have right child of "+ node.data);
        choice = s.nextBoolean();
        if(choice) {
            node.right = takeInput(s, node, false);
        }

        return node;
    }

    public void display(Node root) {
        String str = "";
        if(null != root.left) {
            str += root.left.data + " => ";
        } else {
            str += "NULL => ";
        }
        str += root.data;

        if(null != root.right) {
            str += " <= " + root.right.data;
        } else {
            str += " <= NULL";
        }
        System.out.println(str);

        if(null != root.left) {
            this.display(root.left);
        }

        if(null != root.right) {
            this.display(root.right);
        }
    }

    private int height(Node node) {
        if(null == node) {
            return -1;
        }

        int lHeight = this.height(node.left);
        int rHeight = this.height(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }
}

package Session26_Practicum_Module_4_Binary_tree;

import Session26_Practicum_Module_4_Binary_tree.Node;

public class BST {
    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    public Node search(Node root, int key) {
        if (root == null || root.data == key) return root;
        return key < root.data
                ? search(root.left, key)
                : search(root.right, key);
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}

package binarytree;

public class Main {
    public static void main(String[] args) {

        // === Binary Tree ===
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        System.out.print("Binary Tree Inorder: ");
        bt.inorder(bt.root);

        // === BST ===
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("\nBST Inorder: ");
        bst.inorder(bst.root);

        int key = 40;
        System.out.println(
                bst.search(bst.root, key) != null
                        ? "\nData ditemukan"
                        : "\nData tidak ditemukan"
        );
    }
}

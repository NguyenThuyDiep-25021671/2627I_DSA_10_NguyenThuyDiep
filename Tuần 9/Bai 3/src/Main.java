import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    public static Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }
    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        System.out.print("So luong đinh ban đau cua cay: ");
        int n = scanner.nextInt();
        if (n > 0) {
            System.out.println("Cac gia tri can chen:");
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                root = insertRecursive(root, val);
            }
        }
        System.out.print("Cay hien tai: ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("Them 1 gia tri moi đe chen thu: ");
        int newValue = scanner.nextInt();
        root = insertRecursive(root, newValue);
        System.out.print("Cay moi :");
        inorderTraversal(root);
        System.out.println();

        scanner.close();
    }
}
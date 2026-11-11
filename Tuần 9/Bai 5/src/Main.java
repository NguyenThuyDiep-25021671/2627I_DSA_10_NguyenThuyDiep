import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Main {
    public static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.print("So luong dinh: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.print("Cac gia tri: ");
            for (int i = 0; i < n; i++) {
                root = insert(root, sc.nextInt());
            }
        }
        System.out.println("Cay hien tai la BST? " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        if (root != null) {
            root.data = Integer.MIN_VALUE;
            System.out.println("Sau khi sua gia tri root de test loi, la BST? " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        }
        sc.close();
    }
}
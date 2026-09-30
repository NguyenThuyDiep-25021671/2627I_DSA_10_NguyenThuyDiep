import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); // So luong truy van

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                // Enqueue: Đay phan tu vao stack1
                int x = sc.nextInt();
                stack1.push(x);
            } else {
                // Chuan bi du lieu cho Dequeue hoac Print
                // Neu stack2 rong, trut toan bo du lieu tu stack1 sang
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }

                if (type == 2) {
                    // Dequeue: Lay phan tu o đau hang ra
                    stack2.pop();
                } else if (type == 3) {
                    // Print: In phan tu o đau hang đoi
                    System.out.println(stack2.peek());
                }
            }
        }
        sc.close();
    }
}
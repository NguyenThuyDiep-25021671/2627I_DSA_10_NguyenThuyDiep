import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int type = Integer.parseInt(input[0]);

            switch (type) {
                case 1: // Append: Them chuoi vào cuoi
                    history.push(s.toString()); // Luu trang thai truoc khi sua
                    s.append(input[1]);
                    break;

                case 2: // Delete: Xoa k ky tu o cuoi
                    history.push(s.toString());
                    int kDelete = Integer.parseInt(input[1]);
                    s.delete(s.length() - kDelete, s.length());
                    break;

                case 3: // Print: In ra ky tu thu k
                    int kPrint = Integer.parseInt(input[1]);
                    System.out.println(s.charAt(kPrint - 1));
                    break;

                case 4: // Undo: Khoi phục lai trang thai gan nhat
                    if (!history.isEmpty()) {
                        s = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
    }
}
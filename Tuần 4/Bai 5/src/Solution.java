import java.util.Scanner;

public class Solution {
    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int key = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j = j - 1;
            }
            ar[j + 1] = key;
            printArray(ar);
        }
    }
    public static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = scanner.nextInt();
            }
            insertionSortPart2(ar);
        }
        scanner.close();
    }
}
import java.util.Scanner;

public class Solution {
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            // Sua loi j > 0 thanh j >= 0
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        printArray(A);
    }
    public static void printArray(int[] A) {
        for (int n : A) {
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
            insertionSort(ar);
        }
        scanner.close();
    }
}
import java.util.*;

class Solution {
    public static int pairs(int k, List<Integer> arr) {
        Set<Long> set = new HashSet<>();
        for (int num : arr) {
            set.add((long) num);
        }

        int count = 0;
        for (int num : arr) {
            if (set.contains((long) num + k)) {
                count++;
            }
        }
        return count;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(Solution.pairs(k, arr));
        sc.close();
    }
}

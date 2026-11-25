import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

class Solution {
    static class Node implements Comparable<Node> {
        int val;
        int id;

        Node(int val, int id) {
            this.val = val;
            this.id = id;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();
        TreeSet<Node> set = new TreeSet<>();
        Node mid = null;

        for (int i = 0; i < a.size(); i++) {
            Node cur = new Node(a.get(i), i);
            set.add(cur);
            int sz = set.size();

            if (sz == 1) {
                mid = cur;
            } else if (sz % 2 == 0) {
                if (cur.compareTo(mid) < 0) {
                    mid = set.lower(mid);
                }
            } else {
                if (cur.compareTo(mid) > 0) {
                    mid = set.higher(mid);
                }
            }

            if (sz % 2 == 1) {
                result.add((double) mid.val);
            } else {
                Node nextMid = set.higher(mid);
                result.add(((long) mid.val + nextMid.val) / 2.0);
            }
        }

        return result;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(br.readLine().trim()));
        }

        List<Double> medians = Solution.runningMedian(a);
        StringBuilder sb = new StringBuilder();
        for (double m : medians) {
            sb.append(String.format(Locale.US, "%.1f%n", m));
        }
        System.out.print(sb.toString());
    }
}
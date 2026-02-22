import java.util.*;

public class insertinterval {

    // Merge overlapping intervals
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 >= s2) {
                e1 = Math.max(e1, e2);
            } else {
                ans.add(new int[]{s1, e1});
                s1 = s2;
                e1 = e2;
            }
        }

        ans.add(new int[]{s1, e1});

        return ans.toArray(new int[ans.size()][]);
    }

    // Insert new interval
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {

            if (!inserted && intervals[i][0] >= newInterval[0]) {
                ans.add(newInterval);
                inserted = true;
            }

            ans.add(intervals[i]);
        }

        if (!inserted) {
            ans.add(newInterval);
        }

        return merge(ans.toArray(new int[ans.size()][]));
    }

    // Main method for testing
    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = insert(intervals, newInterval);

        System.out.println("Result:");

        for (int[] arr : result) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
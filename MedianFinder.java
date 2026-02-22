import java.util.*;

public class MedianFinder {

    private PriorityQueue<Integer> left;   // Max Heap (smaller half)
    private PriorityQueue<Integer> right;  // Min Heap (larger half)

    // Constructor
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    // Add number into data structure
    public void addNum(int num) {

        // Step 1: Add to max heap
        left.offer(num);

        // Step 2: Move largest from left → right
        right.offer(left.poll());

        // Step 3: Balance heaps
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    // Find median
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();   // odd case
        }

        // even case
        return ((double) left.peek() + right.peek()) / 2;
    }

    // Main method for testing
    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        System.out.println("Median: " + mf.findMedian()); // 1.0

        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0

        mf.addNum(4);
        System.out.println("Median: " + mf.findMedian()); // 2.5
    }
}
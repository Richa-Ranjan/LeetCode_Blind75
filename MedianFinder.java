import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> left;   // Max Heap
    private PriorityQueue<Integer> right;  // Min Heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to max heap
        left.offer(num);
        
        // Step 2: Move largest from left to right
        right.offer(left.poll());
        
        // Step 3: Balance sizes
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();   // odd case
        }
        
        return (left.peek() + right.peek()) / 2.0; // even case
    }
}
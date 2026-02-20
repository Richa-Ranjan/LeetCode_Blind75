import java.util.*;

class topKFrequent {
    public int[] TopKFrequent(int[] nums, int k) {
        
        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create Min Heap based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        
        // Step 3: Add elements to heap and keep size k
        for (int num : freqMap.keySet()) {
            minHeap.offer(num);
            
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }
        
        // Step 4: Prepare result array
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll();
        }
        
        return result;
    }
}

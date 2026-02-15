public class MaxProdsubarr {

    public static int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If negative, swap
            if (num < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);

            result = Math.max(result, currMax);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, -4, -7, -8};

        int ans = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + ans);
    }
}

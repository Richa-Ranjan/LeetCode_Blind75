import java.util.Scanner;

public class Rotatedsortedarr {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than high, min is in right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // Otherwise min is in left half including mid
            else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findMin(arr);
        System.out.println("Minimum element: " + result);

        sc.close();
    }
}

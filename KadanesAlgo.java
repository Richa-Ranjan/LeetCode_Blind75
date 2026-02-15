import java.util.Scanner;
public class KadanesAlgo {

    public static int kadanesAlgo(int nums[]) {
        int sum = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int nums[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = kadanesAlgo(nums);
        System.out.println("Maximum Subarray Sum = " + result);
    }
}

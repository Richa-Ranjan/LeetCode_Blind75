import java.util.Arrays;
import java.util.Scanner;
public class containdublicate {
    public boolean containdublicate(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
            return false;
        

    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        containdublicate obj = new containdublicate();
        System.out.println(obj.containdublicate(nums));
    }
}
import java.util.Scanner;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        int s = 0;
        int temp = x;

        if (x < 0) return false;

        while (x > 0) {
            int rem = x % 10;
            s = (s * 10) + rem;
            x = x / 10;
        }

        return s == temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int x = sc.nextInt();

        boolean result = isPalindrome(x);

        System.out.println("Is palindrome: " + result);

        sc.close();
    }
}

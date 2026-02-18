// lengthOfLongestSubstring with repeating character
import java.util.*;

public class longestsubstringrep {

    public static int longestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // If duplicate found, shrink window
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "apple";

        int result = longestSubstring(s);

        System.out.println("Longest substring length: " + result);
    }
}

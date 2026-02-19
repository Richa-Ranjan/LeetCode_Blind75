// lengthOfLongestSubstring without repeating character
import java.util.*;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;
 
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If character already exists, move left pointer
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "apple";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Longest substring length: " + result);
    }
}

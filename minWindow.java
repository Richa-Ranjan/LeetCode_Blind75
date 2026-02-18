public class minWindow {

    public static String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0
                || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];

        // Store frequency of characters from t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0;
        int end = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        char[] arr = s.toCharArray();

        while (end < arr.length) {

            // If character needed
            if (map[arr[end]] > 0) {
                count--;
            }

            map[arr[end]]--;
            end++;

            // When valid window found
            while (count == 0) {

                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }

                map[arr[start]]++;

                if (map[arr[start]] > 0) {
                    count++;
                }

                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return new String(arr, startIndex, minLen);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);

        System.out.println("Minimum Window Substring: " + result);
    }
}


public class  CharacterReplacement{

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];   // frequency of characters
        int left = 0;
        int maxCount = 0;           // count of most frequent char in window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            freq[current - 'A']++;

            // update most frequent character count
            maxCount = Math.max(maxCount, freq[current - 'A']);

            // if replacements needed > k → shrink window
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k)); // Output: 4
    }
}

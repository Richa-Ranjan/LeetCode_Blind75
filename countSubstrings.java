class Solution {
    public int countSubstrings(String S) {
        int len = S.length();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            int j = i - 1;
            int k = i;

            // Step 1: Handle consecutive duplicate characters
            while (k < len - 1 && S.charAt(k) == S.charAt(k + 1)) {
                k++;
            }

            // Step 2: Count palindromes formed by duplicates
            ans += (k - j) * (k - j + 1) / 2;

            // Step 3: Move i to end of duplicate block
            i = k;
            k++;

            // Step 4: Expand around center
            while (j >= 0 && k < len && S.charAt(j) == S.charAt(k)) {
                ans++;
                j--;
                k++;
            }
        }

        return ans;
    }
}

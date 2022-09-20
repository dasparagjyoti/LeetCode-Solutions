class Solution {
    
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Check for empty nums1 or nums2. If any is 0, then there won't be any repeated subarray.
        if (m == 0 || n == 0) {
            return 0;
        }

        // Dynamic Programming using 2D Matrix.
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        // Traverse both nums2 for every numbers in nums1, to check if same number.
        // If same, then we increase the count of dp[i][j] by 1.
        // If there are already matching number previously dp[i+1][j+1], we add the count.
        // Then update max.
	    // Example:
        // nums1 = [1,2,3,4]
        // nums2 = [4,2,3,4]
        // i = 3, [[1,0,0,1,0]  (nums[i] = 4), max = 1
        // i = 2,  [0,0,2,0,0]  (nums[i] = 3), max = 2
        // i = 1,  [0,3,0,0,0]  (nums[i] = 2), max = 3
        // i = 0,  [0,0,0,0,0]] (nums[i] = 1), max = 3
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
					max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
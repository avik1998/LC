// Given a binary array nums, return the maximum number of consecutive 1s in the array.



// A binary array is an array that contains only 0s and 1s.


// Example 1
// Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
// Output: 3
// Explanation: The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s

// Example 2
// Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]
// Output: 0
// Explanation: No 1s are present in nums, thus we return 0


// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.

// Note:
// Follow up: What if you were asked to return the maximum consecutive 1 or 0, whichever is more?




// Intuition
// To find the number of maximum consecutive 1s, the idea is to count the number of 1s each time we encounter them and update the maximum number of 1s. 
// On encountering any 0, reset the count to 0 again so as to count the next consecutive 1s.

// Approach 
// Initialize two variables, count and max_count to 0. Traverse the array and if the current element is 1, increment the count by 1.
// Update max_count if count is greater than max_count.
// If the current element is 0, reset the count variable to 0 and at last return max_count.

import java.util.*;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /* Initialize count and max_count 
               to track current and maximum consecutive 1s */
        int cnt = 0;
        int maxi = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If the current element is 1, increment the count
            if (nums[i] == 1) {
                cnt++;

                // Update maxi if current count is greater than maxi
                maxi = Math.max(maxi, cnt);

            } else {
                // If the current element is 0, reset the count
                cnt = 0;
            }
        }
        // Return the maximum count of consecutive 1s
        return maxi;
    }

    public static void main(String[] args) {
     
        int[] nums = {1, 1, 0, 1, 1, 1};

        // Create an instance of the Solution class
        Solution sol = new Solution();

        // Find and print the maximum consecutive 1s
        int ans = sol.findMaxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive 1's are " + ans);
    }
}

// Complexity Analysis 
// Time Complexity: O(N), as there is single traversal of the array .Here N is the number of elements in the array.
// Space Complexity: O(1), as no additional space is used .
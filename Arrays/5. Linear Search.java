// Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1.


// Example 1
// Input: nums = [2, 3, 4, 5, 3], target = 3
// Output: 1
// Explanation: The first occurence of 3 in nums is at index 1

// Example 2
// Input: nums = [2, -4, 4, 0, 10], target = 6
// Output: -1
// Explanation: The value 6 does not occur in the array, hence output is -1

// Example 3
// Input: nums = [1, 3, 5, -4, 1], target = 1
// Output : 0

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// -104 <= target <= 104



// Intuition:
// Lets break the problem statement into an example to understand it better. Imagine having a long shelf filled with books, 
// and each book has a unique number written on its spine. The ask is to look for the first book with a specific number, 
// let's say 2.

// To achieve this we will simply start scanning each book and once a book with number 2 is got, stop the scan procedure.

// Approach 
// Traverse through the array, similar to the idea of scanning each book serially.
// Check if the current element of array is equal to the target element. If so, return the index and stop scanning further.
// In case target value is not found, return -1 marking that the target element missing.


import java.util.*;
class Solution {
// Linear Search Function
    public int linearSearch(int[] nums, int target) {
        // Traverse the entire array
        for (int i = 0; i < nums.length; i++) {

            // Check if current element is target
            if (nums[i] == target) {

                // Return if target found
                return i;

            }
        }
        // If target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 4;

        // Create an instance of the Solution class
        Solution sol = new Solution();

         // Call the linearSearch method
        int result = sol.linearSearch(nums, target);
        
        System.out.println(result);
    }
}

// Complexity Analysis 

// Time Complexity: O(N), in worst case entire array will be traversed, taking a time of N where N is size of the array.
// Space Complexity: O(1), as no additional space is used apart from the input array, the space complexity stays constant.
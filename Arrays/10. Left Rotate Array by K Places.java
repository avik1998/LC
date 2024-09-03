// Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.


// Example 1
// Input: nums = [1, 2, 3, 4, 5, 6], k = 2
// Output: nums = [3, 4, 5, 6, 1, 2]
// Explanation: rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
// rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

// Example 2
// Input: nums = [3, 4, 1, 5, 3, -5], k = 8
// Output: nums = [1, 5, 3, -5, 3, 4]
// Explanation: rotate 1 step to the left: [4, 1, 5, 3, -5, 3]

// rotate 2 steps to the left: [1, 5, 3, -5, 3, 4]

// rotate 3 steps to the left: [5, 3, -5, 3, 4, 1]

// rotate 4 steps to the left: [3, -5, 3, 4, 1, 5]

// rotate 5 steps to the left: [-5, 3, 4, 1, 5, 3]

// rotate 6 steps to the left: [3, 4, 1, 5, 3, -5]

// rotate 7 steps to the left: [4, 1, 5, 3, -5, 3]

// rotate 8 steps to the left: [1, 5, 3, -5, 3, 4]


// Note: Fill the answer in the same format as in Example 1 and 2, make sure to add commas, and spaces.

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 0 <= k <= 105

// Note:
// Can this be done in-place, without using extra space?



// Intuition
// The most optimal solution works based on the properties of reversing sections of the array. This involves reversing different parts of the array to achieve the desired rotation.

// Why does this solution work?
// Reversal Property: Reversing a segment of the array changes the order but keeps the elements intact. By reversing the segments first and then the entire array, 
// you rearrange the elements correctly without needing extra space.
// Maintaining Order: Each reversal step preserves the order of the elements within that segment, ensuring the elements that need to stay together remain so.
// Approach 
// Reverse the first k elements of the array.
// On reversing the first k elements, you are essentially reversing the order of the elements that will be moved to the back of the array. This prepares them to be placed at the end after the rotation.
// Reverse the last N - K elements of the array.
// Reversing the remaining elements (from position k to the end of the array) ensures that these elements maintain their relative order after the rotation. They will come before the first k elements in the final arrangement.
// Reverse the entire array.
// Finally, on reversal of the entire array, it combines the two previously reversed sections into the correct order. The first k elements (which were reversed first) are now at the end, 
// and the last n-k elements (which were reversed second) are at the front, effectively achieving the left rotation.

import java.util.*;

class Solution {
    // Function to reverse the array
    public void reverseArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    // Function to rotate the array to the left by k positions
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;

        // Reverse the first k elements
        reverseArray(nums, 0, k - 1);

        // Reverse the last n-k elements
        reverseArray(nums, k, n - 1);

        // Reverse the whole array
        reverseArray(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        //Create an instance of the Solution class
        Solution sol = new Solution();

        // Call the function to rotate the array
        sol.rotateArray(arr, k);

        System.out.println("After rotating the elements to the left: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

// Complexity Analysis: 
// Time Complexity: O(N), as each element in the array is reversed three times. Here N is the length of the array.
// Space Complexity: O(1) as no extra space is used .
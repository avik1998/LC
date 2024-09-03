// Given an array of integers nums, return the value of the largest element in the array.


// Example 1
// Input: nums = [3, 3, 6, 1]
// Output: 6

// Explanation: The largest element in array is 6
// Example 2
// Input: nums = [3, 3, 0, 99, -40]
// Output: 99

// Explanation: The largest element in array is 99
// Example 3
// Input: nums = [-4, -3, 0, 0, -8]
// Output : 0

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// nums may contain duplicate elements.



// Intuition
// Imagine being a teacher having a list of marks obtained by your students in a recent test. The ask is to find out which student scored the highest marks.

// Now to find the highest marks in the list, keep track of the marks encountered so far in a variable, let's say maxi. 
// Starting value of maxi will be the first marksheet's marks as initially that will the maximum.

// Then go checking each marksheet one by one and keep comparing and updating maxi as and when a marks greater than current marks stored in maxi is found. 
// This will ensure that once we have all the marksheets checked we will have maximum marks stored in the variable maxi.

// Approach 
// Create a max variable and initialize it with arr[0], as in the beginning the first element should be maximum.
// Iterate in the array and compare it with other elements to update the maximum.
// If any element is greater than the max value, update max value with the element’s value and at last return the max.

import java.util.*;

class Solution {
    public int largestElement(int[] nums) {
        // Initialize max as the first element
        int max = nums[0];

        // Traverse the entire array
        for (int i = 1; i < nums.length; i++) {

            /* If current element is greater
            than max, update max*/
            if (nums[i] > max) {
                max = nums[i];
            }

        }
        // Return the largest element found
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,2};

        // Create an instance of the Solution class
        Solution sol = new Solution();

        // Find and print the largest element in the array
        System.out.println("The largest element in the array is: " + sol.largestElement(nums));
    }
}

// Complexity Analysis 
// Time Complexity: O(N) , since there is linear traversal of the array, where N is the length of the array.
// Space Complexity: O(1), as no additional space is used.
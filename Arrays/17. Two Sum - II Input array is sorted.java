// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
// The tests are generated such that there is exactly one solution. You may not use the same element twice.
// Your solution must use only constant extra space.

// Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

// Example 2:
// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

// Example 3:
// Input: numbers = [-1,0], target = -1
// Output: [1,2]
// Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

// Constraints:
// 2 <= numbers.length <= 30,000
// -1000 <= numbers[i] <= 1000
// numbers is sorted in non-decreasing order.
// -1000 <= target <= 1000
// The tests are generated such that there is exactly one solution.




// Intuition
// Since the array is already sorted in non-decreasing order, we can use the two-pointer technique to find the pair of numbers
// that sum up to the target. Start with two pointers: one at the beginning and one at the end of the array. 
// Move the pointers based on the sum of the values they point to. This method is efficient because it leverages the sorted property of the array.

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // Initialize the left pointer at the start of the array
        int right = numbers.length - 1; // Initialize the right pointer at the end of the array
        
        // Iterate until the two pointers meet
        while (left < right) {
            int sum = numbers[left] + numbers[right]; // Calculate the sum of elements at the two pointers
            
            if (sum > target) {
                right--; // If sum is greater than target, move the right pointer leftwards to decrease the sum
            } else if (sum < target) {
                left++; // If sum is less than target, move the left pointer rightwards to increase the sum
            } else {
                // If the sum equals the target, return the 1-indexed positions
                return new int[]{left + 1, right + 1};
            }
        }
        
        // If no valid pair is found, though the problem guarantees exactly one solution
        return new int[]{-1, -1};
    }
}

// Complexity Analysis
// Time Complexity: O(N), where N is the length of the array. The algorithm makes a single pass through the array using two pointers.
// Space Complexity: O(1), as we are only using a constant amount of extra space for the pointers and sum calculation.

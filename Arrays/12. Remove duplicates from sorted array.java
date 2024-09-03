// Remove duplicates from sorted array


// Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once. Return the number of unique elements in the array.



// If the number of unique elements be k, then,

// Change the array nums such that the first k elements of nums contain the unique values in the order that they were present originally.
// The remaining elements, as well as the size of the array does not matter in terms of correctness.


// An array sorted in non-decreasing order is an array where every element to the right of an element in either equal to or greater in value than that element.


// Example 1
// Input: nums = [0, 0, 3, 3, 5, 6]
// Output: [0, 3, 5, 6, _, _]
// Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.

// Example 2
// Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]
// Output: [-2, 2, 4, 5, _, _, _, _]
// Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.

// Example 3
// Input: nums = [-30, -30, 0, 0, 10, 20, 30, 30]
// Output : [-30, 0, 10, 20, 30, _, _, _]

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.

// Note:
// Food for thought: Can we use the bitwise XOR operator to solve this problem?



// Intuition
// Imagine you have a shelf where you keep your favorite books, and these books are sorted in alphabetical order. Over time, you notice that some books are repeated multiple times, and you want to organize the shelf so that each book title appears only once. Additionally, you don't want to change the order of the unique books on your shelf.

// Here's what you would do:

// Start at the beginning of the shelf and pick the first book. Look at the next book, if it's the same as the one just picked, then move on to the next book. If the next book is different, keep it next to the first book that is picked. Repeat this process for all books on the shelf.

// Once all the books are checked, the first part of the shelf will have all the unique books in their original order. The rest of the books on the shelf don't matter, so ignore them.

// Approach 
// Initialize 2 variables i as 0 and variable j as 1, where i will track the position of the last unique element found and j will iterate through the array to find new unique elements.
// Iterate in array using j from second element to the end of the array.
// If the element at position j is different from the element at position i, it means a new unique element is found. This is because the array is sorted in non-decreasing order, so any new element that is different from the previous one must be unique.
// When a new unique element is found, increment i to move to the next position for storing unique elements. Copy the element at position j to the new position at i. This ensures that the first i + 1 elements of the array are all unique.
// Continue comparing elements and updating the array until j has iterated through the entire array. Once the loop completes, the value of i + 1 represents the number of unique elements in the array.

import java.util.*;

class Solution {
    // Function to remove duplicates from the array
    public int removeDuplicates(int[] nums) {
        // Edge case: if array is empty
        if (nums.length == 0) {
            return 0;
        }
        
        // Initialize pointer for unique elements
        int i = 0;
        
        // Iterate through the array
        for (int j = 1; j < nums.length; j++) {
            /*If current element is different 
            from the previous unique element*/
            if (nums[i] != nums[j]) {
                /* Move to the next position in 
                the array for the unique element*/
                i++;
                /* Update the current position 
                   with the unique element*/
                nums[i] = nums[j];
            }
        }
        
        // Return the number of unique elements
        return i + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Call removeDuplicates to remove duplicates from nums
        int k = solution.removeDuplicates(nums);
        
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

// Complexity Analysis 
// Time Complexity: O(N), for single traversal of the array, where N is the size of the array.
// Space Complexity: O(1), not using any extra space.
// Given an integer array nums, return a list of all the leaders in the array.



// A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.


// Example 1
// Input: nums = [1, 2, 5, 3, 1, 2]

// Output: [5, 3, 2]

// Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

// Example 2
// Input: nums = [-3, 4, 5, 1, -4, -5]

// Output: [5, 1, -4, -5]

// Explanation: -5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]

// Example 3
// Input: nums = [-3, 4, 5, 1, -30, -10]

// Output : [5, 1, -10]

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104



// Intuition
// Think of a parade where each person in a line holds a flag with a number on it, representing their importance. You start observing the parade from the last person, moving towards the front. Initially, the last person is the most important (since there's no one else behind them).

// As you move forward, compare each person's flag number to the highest flag number seen so far. If someone's flag number is higher than the highest that is seen, they stand out as a leader because they have a higher number than anyone behind them.

// Approach 
// Set a variable max to the last element of the array (nums[sizeOfArray - 1]), as the last element is always a leader.
// Create an empty list ans to store the leader elements and add the last element of the array to this list initially, as it is always a leader.
// Start from the second last element (index = sizeOfArray - 2) and move towards the first element (index = 0)
// For each element, compare it with the max variable. If the current element is greater than max, add this element to the ans list and update max to the current element.
// The ans list now contains all the leader elements in the order they appear in the array.

import java.util.ArrayList;

class Solution {
    //Function to find the leaders in an array.
    public int[] leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (nums.length == 0) {
            return nums; // Return an empty array if nums is empty
        }
        
        // Last element of the array is always a leader
        int max = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);
        
        // Check elements from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        
        /* Convert ArrayList<Integer> to
         int[] in reverse order*/
        int[] result = new int[ans.size()];
        for (int i = ans.size() - 1; i >= 0; i--) {
            result[ans.size()- 1 - i] = ans.get(i);
        }
        
        // Return the result array
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        
        // Create an instance of the Solution class
        Solution finder = new Solution();
        
        // Get leaders using class method
        int[] ans = finder.leaders(nums);
      
        System.out.print("Leaders in the array are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

// Complexity Analysis 
// Time Complexity:O(N), for single traversal of array , where N is the length of that array.
// Space Complexity: O(1), as extra space to store answer is not considered.

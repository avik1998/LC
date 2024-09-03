// Given an integer array nums, rotate the array to the left by one.


// Example 1
// Input: nums = [1, 2, 3, 4, 5]
// Output: [2, 3, 4, 5, 1]
// Explanation: Initially, nums = [1, 2, 3, 4, 5]
// Rotating once to left -> nums = [2, 3, 4, 5, 1]

// Example 2
// Input: nums = [-1, 0, 3, 6]
// Output: [0, 3, 6, -1]
// Explanation: Initially, nums = [-1, 0, 3, 6]
// Rotating once to left -> nums = [0, 3, 6, -1]

// Example 3
// Input: nums = [7, 6, 5, 4]
// Output : [6, 5, 4, 7]

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

// Note:
// Can a solution with O(n) time and O(1) space complexity be achieved?



// Intuition
// To rotate an array by one position to the right, consider that the last element of the array will move to the first position, 
// while all other elements shift one position to the right. The thought process involves first capturing the value of the first element in a temporary variable. 
// Next, iterate through the array starting from the second element and shift each element to the position of its predecessor. 
// Finally, place the initially captured value into the last position of the array. This approach ensures that the array is rotated by one position effectively.

// Approach
// Store the value of the first element of the array in a temporary variable.
// Iterate through the array starting from the second element.
// Shift each element one position to the left by assigning the current element to the position of its predecessor.
// After completing the iteration, place the value from the temporary variable into the last position of the array.

class Solution {
    public void rotateArrayByOne(int[] nums) {
        // Store the first element in a temporary variable
        int temp = nums[0];
        
        // Shift elements to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // Place the first element at the end
        nums[nums.length - 1] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};

        solution.rotateArrayByOne(nums);

        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

// Complexity Analysis
// Time Complexity: O(N), where N is the number of elements in the array. Each element is visited once during the iteration.
// Space Complexity: O(1). The space used does not depend on the size of the input array and remains constant.
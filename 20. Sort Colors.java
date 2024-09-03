// Given an array nums with n objects colored red, white, or blue, sort them in-place 
// so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// Example 1
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Explanation: Initially, nums = [2,0,2,1,1,0]
// Sorting colors -> nums = [0,0,1,1,2,2]

// Example 2
// Input: nums = [2,0,1]
// Output: [0,1,2]
// Explanation: Initially, nums = [2,0,1]
// Sorting colors -> nums = [0,1,2]

// Constraints:
// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.

// Note:
// The solution must be achieved with O(n) time complexity and O(1) space complexity.

// Intuition
// To solve this problem efficiently, we use a three-pointer technique. We need to partition the array into three segments:
// 1. Segment for 0s (red)
// 2. Segment for 1s (white)
// 3. Segment for 2s (blue)
// We use three pointers: 'low' to track the boundary of the 0s segment, 'mid' to scan through the array, and 'high' to track the boundary of the 2s segment. 
// By processing each element and moving the pointers accordingly, we ensure that all 0s are placed at the beginning, followed by 1s, and then 2s at the end.

// Approach
// Initialize three pointers: 'low' at the start, 'mid' at the start, and 'high' at the end of the array.
// Iterate through the array using the 'mid' pointer:
// - If nums[mid] is 0, swap it with nums[low] and increment both 'low' and 'mid'.
// - If nums[mid] is 1, just move 'mid' to the next position.
// - If nums[mid] is 2, swap it with nums[high] and decrement 'high'. Do not increment 'mid' in this case as we need to recheck the element at the 'mid' position after swapping.

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;     // Pointer for the next position of 0
        int mid = 0;     // Pointer for the current element
        int high = nums.length - 1;  // Pointer for the next position of 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }        
    }

    // Utility method to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};

        solution.sortColors(nums);

        // Output the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

// Complexity Analysis
// Time Complexity: O(N), where N is the number of elements in the array. Each element is processed at most once.
// Space Complexity: O(1). The space used does not depend on the size of the input array and remains constant.

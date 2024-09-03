// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
// i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

// Constraints:
// 3 <= nums.length <= 3000
// -10^5 <= nums[i] <= 10^5




// Intuition
// To find all unique triplets that sum up to zero, we can use a combination of sorting and the two-pointer technique. 
// First, sort the array to enable efficient searching of pairs using two pointers. 
// For each element, treat it as the first element of the triplet and use the two-pointer technique to find pairs that sum up to the negative of that element.

// Approach
// 1. Sort the input array. This helps in efficiently finding the triplets and avoiding duplicates.
// 2. Iterate through the array, treating each element as the potential first element of a triplet.
// 3. For each element, use the two-pointer technique to find pairs in the remaining array that sum up to the negative of the current element.
// 4. Skip duplicate elements to ensure that the result contains only unique triplets.
// 5. Return the list of unique triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array to use two-pointer technique
        int n = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        
        if (n < 2) {
            return result; // Return empty list if there are less than 3 elements
        }
        
        // Iterate through the array
        for (int i = 0; i <= n - 2; i++) {
            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int target = -nums[i]; // The target sum for the remaining two elements
            twoSum(nums, target, i + 1, n, result); // Find pairs that sum up to the target
        }
        
        return result;
    }

    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> result) {
        while (start < end) {
            int sum = nums[start] + nums[end];
            
            if (sum > target) {
                end--; // Decrease the sum by moving the end pointer left
            } else if (sum < target) {
                start++; // Increase the sum by moving the start pointer right
            } else {
                // Found a triplet
                result.add(Arrays.asList(-target, nums[start], nums[end]));
                
                // Skip duplicate elements
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                
                start++;
                end--;
            }
        }
    }
}

// Complexity Analysis
// Time Complexity: O(N^2), where N is the length of the array. Sorting the array takes O(N log N) and finding triplets takes O(N^2) due to the nested loops.
// Space Complexity: O(1) for extra space used excluding the output. The result list is the only extra space used, and its size is proportional to the number of unique triplets.

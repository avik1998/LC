// Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.



// Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in non-decreasing order.


// Example 1
// Input: nums = [1, 6, 2, 10, 3], target = 7

// Output: [0, 1]

// Explanation: nums[0] + nums[1] = 1 + 6 = 7

// Example 2
// Input: nums = [1, 3, 5, -7, 6, -3], target = 0

// Output: [1, 5]

// Explanation: nums[1] + nums[5] = 3 + (-3) = 0


// Note: Fill the answer in the same format as in Example 1 and 2, make sure to add commas, and spaces.

// Constraints:
// 2 <= nums.length <= 105
// -104 <= nums[i] <= 104
// -105 <= target <= 105
// Only one valid answer exists.



//Optimal-I (If index is asked and the array is unsorted)
// Intuition
// The idea is to traverse the array and use a HashMap to check if for each element, an element in the HashMap exists, such that sum of both of the elements is equal to the target. This method trims down the search space and provides a better time complexity.

// Approach 
// Iterate in array from 0 to last index of the array (lets call this variable i).
// Then check if the other required element(i.e. target-arr[i]) exists in the hashMap.
// If that element exists, then return the current index i.e. i, and the index of the element found using map.
// If that element does not exist, then just store the current element in the hashMap along with its index. Because in the future, the current element might be a part of our answer.
// If at the end we have traversed whole array and no pair is found, that means that the target is unachievable. In this case, return {-1, -1}.

import java.util.*;

class Solution {
    /* Function to find two indices in the array `nums`
       such that their elements sum up to `target`.
    */
    public int[] twoSum(int[] nums, int target) {
        
        // Map to store (element, index) pairs
        Map<Integer, Integer> mpp = new HashMap<>();
        
        // Size of the nums array
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Current number in the array
            int num = nums[i];
            
            // Number needed to reach the target
            int moreNeeded = target - num;

            // Check if the complement exists in map
            if (mpp.containsKey(moreNeeded)) {
                /* Return the indices of the two
                numbers that sum up to target*/
                return new int[]{mpp.get(moreNeeded), i};
            }

            // Store current number and its index in map
            mpp.put(num, i);
        }

        // If no such pair found, return {-1, -1}
        return new int[]{-1, -1};
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;

        // Create an instance of Solution class
        Solution sol = new Solution();
        
        // Call the twoSum method from Solution class
        int[] ans = sol.twoSum(nums, target);

        // Print the result
        System.out.println("Indices of the two numbers that sum up to " + target + " are: [" + ans[0] + ", " + ans[1] + "]");
    }
}

// Complexity Analysis 
// Time Complexity:O(N), where N is the size of the array. The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).

// Note:In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.

// Space Complexity: O(N) for using the map data structure.




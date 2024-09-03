// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow up: Could you solve the problem in linear time and in O(1) space?

// It's same as majority element 1 

// The observation is:

// If the size of the array is n -> Max 1 n/2 element exists
// If the size of the array is n -> Max 2 n/3 element exists
// If the size of the array is n -> Max 3 n/4 element exists
// and so on..
// n/k ==> Max (k-1) element exists



import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Step 1: Initialize variables for two potential majority elements and their counts
        int count1 = 0, count2 = 0;
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;

        // Step 2: Iterate through the array to find the potential majority elements
        for (int i = 0; i < nums.length; i++) {
            // If count1 is 0, assign the current number to num1 and reset count1
            // Or if the current number is equal to num1 and not equal to num2
            if ((count1 == 0 || nums[i] == num1) && nums[i] != num2) {
                num1 = nums[i];
                count1++;
            }
            // If count2 is 0, assign the current number to num2 and reset count2
            // Or if the current number is equal to num2 and not equal to num1
            else if ((count2 == 0 || nums[i] == num2) && nums[i] != num1) {
                num2 = nums[i];
                count2++;
            } 
            // If neither condition is met, decrease both counts
            else {
                count1--;
                count2--;
            }
        }

        // Step 3: Reset counts to verify the actual occurrence of num1 and num2
        count1 = 0;
        count2 = 0;

        // Count occurrences of num1 and num2 in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1)
                count1++;
            else if (nums[i] == num2)
                count2++;
        }

        // Step 4: Prepare the result list based on the counts
        List<Integer> result = new ArrayList<>();
        int minimumOccurance = (nums.length / 3);

        // Add num1 to the result if it appears more than n/3 times
        if (count1 > minimumOccurance)
            result.add(num1);

        // Add num2 to the result if it appears more than n/3 times
        if (count2 > minimumOccurance)
            result.add(num2);

        return result;
    }
}


// Time Complexity: 
// O(n)
// Space Complexity: 
// O(1)
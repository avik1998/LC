// Find missing number


// Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range.


// Example 1
// Input: nums = [0, 2, 3, 1, 4]

// Output: 5

// Explanation: nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]

// Example 2
// Input: nums = [0, 1, 2, 4, 5, 6]

// Output: 3

// Explanation: nums contains 0, 1, 2, 4, 5, 6 thus leaving 3 as the only missing number in the range [0, 6]

// Example 3
// Input: nums = [1, 3, 6, 4, 2, 5]

// Output : 0

// Constraints:
// n == nums.length
// 1 <= n <= 104
// 0 <= nums[i] <= n
// All the numbers of nums are unique.

// Note: Can a solution with O(1) extra space and O(n) runtime be achieved?



// Optimal-I 
// Intuition
// The optimal is based on simple mathematics, where addition and summation of series is involved.

// Ideally while solving this problem, if you think of calculating the sum of natural numbers from 0 to N and also compute the sum of all elements in the array separately. Then, just by subtracting the two results, we can easily identify the missing number. This missing number would not have been included in the sum of all elements of the given array.

// Approach 
// Calculate the summation of first N natural numbers(i.e. 1 to N) using the formula (N*(N+1))/2 and store in variable sum1
// Then add all the array elements by iterating in the array and store it in variable sum2
// Finally, consider the difference between the sum1and sum2, return it.

import java.util.*;

class Solution {
    // Function to find the missing number
    public int missingNumber(int[] nums) {
        // Calculate N from the length of nums
        int N = nums.length;
        
        // Summation of first N natural numbers
        int sum1 = (N * (N + 1)) / 2;
        
        // Summation of all elements in nums
        int sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }
        
        // Calculate the missing number
        int missingNum = sum1 - sum2;
        
        // Return the missing number
        return missingNum;
    }

    public static void main(String[] args) {
        // Example array with missing number
        int[] nums = {0,1, 2, 4};
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        /* Call the missingNumber method 
        to find the missing number*/
        int ans = solution.missingNumber(nums);
        
        System.out.println("The missing number is: " + ans);
    }
}

// Complexity Analysis
// Time Complexity: O(N) where N is size of array, to compute the sum of the array elements.
// Space Complexity: O(1) as no extra space is used.



// Optimal-II
// Intuition
// Another optimal approach, uses the below property of XOR to find the missing number.

// XOR of two same numbers is 0.
// The XOR of a number with 0 is the number itself
// Understand that on calculating the XOR of all numbers from 1 to N we make sure that each number is included. After that on calculating the XOR of all the elements in the array & then performing XOR these two results, all the numbers present in the final result will appear twice expect for the one which is missing. Hence the number occurring twice turn out 0 satisfying first condition, and then followed by 0 ^ missing number, leaving the missing number itself.

// Approach 
// Initialize two variables xor1, xor2 as 0. xor1 variable will calculate the XOR of 1 to N
// Calculate the XOR of all the elements in the array by xor2 = xor2 ^ arr[i]..
// Finally, the answer will be the XOR of xor1 and xor2.

import java.util.*;
class Solution {
    // Function to find missing number in array
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;

        // Calculate XOR of all array elements
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1); // XOR up to [1...N]
            xor2 = xor2 ^ nums[i]; // XOR of array elements
        }

        // XOR of xor1 and xor2 gives missing number
        return (xor1 ^ xor2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};

        // Create an instance of the Solution class
        Solution solution = new Solution();

        /* Call the missingNumber method
        to find the missing number*/
        int ans = solution.missingNumber(nums);

        System.out.println("The missing number is: " + ans);
    }
}

// Complexity Analysis
// Time Complexity: O(N) for getting the sum of the array elements, where N is the size of the array.
// Space Complexity: O(1) as no extra space is used.
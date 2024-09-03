// Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.


// Example 1
// Input: nums = [8, 8, 7, 6, 5]
// Output: 7
// Explanation: The largest value in nums is 8, the second largest is 7

// Example 2
// Input: nums = [10, 10, 10, 10, 10]
// Output: -1
// Explanation: The only value in nums is 10, so there is no second largest value, thus -1 is returned

// Example 3
// Input: nums = [7, 7, 2, 2, 10, 10, 10]
// Output : 7

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// nums may contain duplicate elements.



// Intuition
// To find the second-largest element in an array more efficiently, the idea is to perform the operation in a single traversal by making smart comparisons. 
// This approach uses two variables to keep track of the largest and the second-largest elements while iterating through the array. 
// This will help to find the second-largest element with just one pass throughout the array.

// What if there are fewer than 2 elements?
// When there are fewer than 2 elements in an array, there would not be any second largest element, so return -1.

// Approach 
// Initialize two variables: largest, and secondLargest. Initialize largest and secondLargest to INT_MIN as initially none of them should be holding any values.
// If the current element is larger than largest, update secondLargest and largest.
// Else if the current element is larger than secondLargest and not equal to largest, update secondLargest.
// Traverse the entire array to update the second largest element in declared variable i.e, secondLargest.

import java.io.*;

class Solutions {
    // Method for second largest element in the array
    public int secondLargestElement(int[] nums) {

        // Check if the array has less than 2 elements
        if (nums.length < 2) {
            // If true, return -1 there is no second largest element
            return -1;
        }

        / Initialize variables to store the 
        largest and second largest elements*/
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        /*Single traversal to find thelargest 
       and second largest elements*/
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } 
            else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }

        }

        // Return the second largest element
        return secondLargest == Integer.MIN_VALUE ?  -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 7, 5};

       //Creating the instance of the Solution class
        Solutions sol=new Solutions();

        int n = nums.length;

        /* Call the method to find
        the second largest element*/
        int sL = sol.secondLargestElement(nums);

        System.out.println("Second largest is " + sL);
    }
}

// Complexity Analysis 

// Time Complexity: O(N), because the solution involves a single traversal, where N is the length of the array,
// Space Complexity: O(1) as no additional space is required.
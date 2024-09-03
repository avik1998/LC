// Given an array arr of size n, the task is to find the sum of all the elements in the array.


// Example 1
// Input: n=5, arr = [1,2,3,4,5]
// Output: 15
// Explanation: Sum of all the elements is 1+2+3+4+5 = 15

// Example 2
// Input: n=6, arr = [1,2,1,1,5,1]
// Output: 11
// Explanation: Sum of all the elements is 1+2+1+1+5+1 = 11

// Example 3
// Input: n=3, arr = [2,1,1]
// Output : 4

// Constraints:
// 1 <= n <= 105
// 1 <= arr[i] <= 104



// Intuition:
// To sum an array, begin by initializing the sum to zero, 
// representing the starting point with no accumulated value. Then, 
// sequentially add each element of the array to this sum. This approach ensures that, 
// by the end of the process, the sum reflects the total value of all elements in the array.

// Approach:
// Initialize a variable sum to 0. This variable will hold the total sum of the array elements.
// Iterate through each element in the array using a loop. For each element, add it to the sum variable.
// After the loop ends, the sum variable will contain the total sum of all the elements in the array.

class Solution {
    public int sum(int[] arr, int n) {
        // Initialize sum to 0
        int sum = 0;
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Add each element to the sum
            sum += arr[i];
        }
        return sum;
    }
   // The main method
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        System.out.println("Sum of array elements: " + sol.sum(arr, n));
    }
}


// Time Complexity: O(N) – Array with N elements is traversed, once

// Space Complexity: O(1) – A single variable is used to store the sum, regardless of the array size.
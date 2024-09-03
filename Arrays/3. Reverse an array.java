// Given an array arr of n elements. The task is to reverse the given array. The reversal of array should be inplace.


// Example 1
// Input: n=5, arr = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]

// Example 2
// Input: n=6, arr = [1,2,1,1,5,1]
// Output: [1,5,1,1,2,1]
// Explanation: The reverse of the array [1,2,1,1,5,1] is [1,5,1,1,2,1].

// Example 3
// Input: n=3, arr = [1,2,1]
// Output : [1,2,1]

// Constraints:
// 1 <= n <= 104
// 1 <= arr[i] <= 105



// Intuition:
// To reverse an array, the objective is to reorder the elements such that the last element becomes the first and the second last becomes the second, 
// and so forth. The straightforward approach involves creating a new array of the same size and populating it by iterating through the input array from end to start, 
// thereby storing elements in reverse order.

// Approach:
// Declare a new array having the same size as the input array.
// Iterate through the input array from the end to the beginning and for each element in the input array, store it in the corresponding position in the new array.
// After the loop ends, the new array will contain the reversed elements.
// Copy the elements back to the original array to get the reversed array.

import java.util.Arrays;
 
class Solution {
    // Function to reverse array using an auxiliary array
    public void reverse(int arr[], int n) {
        int[] ans = new int[n];
        
        /* Fill new array with elements of 
        original array in reverse order */
        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = arr[i];
        }
        
        // Copy the elements back to the original array
        for(int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
        
        // Return
        return;
    }
}
 
class Main {
    // Function to print array
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5, 4, 3, 2, 1};
        
        // Creating instance of Solution class
        Solution solution = new Solution();
        System.out.print("Original array: ");
        printArray(arr, n);
        
        // Function call to reverse the array 
        solution.reverse(arr, n); 
        System.out.print("Reversed array: ");
        printArray(arr, n);
    }
}

// Complexity Analysis:
// Time Complexity: O(N), A single-pass of the array with N elements is being done to reverse the array.

// Space Complexity: O(N), for the extra array of the same size used.
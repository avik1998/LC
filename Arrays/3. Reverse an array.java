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
// To reverse an array in place without additional space, employ a swapping technique utilizing two pointers: 
// one starting from the beginning of the array and the other from the end. By exchanging the elements at these pointers and progressively moving them toward the center, 
// the array can be reversed efficiently within the same memory allocation. This method is both space-efficient and effective.

// Approach:
// Initialize a pointer p1 at the first index and another pointer p2 at the last index of the array.
// Swap the elements pointed by p1 and p2 and increment p1 by 1 while decrementing p2 by 1 simultaneously.
// Repeat the process for the first n/2 elements, where n is the length of the array.

import java.util.Arrays;
 
class Solution {
    // Function to reverse array using two pointers
    public void reverse(int[] arr, int n) {
        int p1 = 0, p2 = n - 1;
        /* Swap elements pointed by p1 and 
        p2 until they meet in the middle */
        while (p1 < p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
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
// Time Complexity: O(N), A single-pass of the array with N elements is being done to reverse the array

// Space Complexity: O(1), no extra data structure is being used so no extra space.
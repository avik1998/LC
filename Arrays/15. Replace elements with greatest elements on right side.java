// Given an array arr, replace every element in that array with the greatest element among the elements to its right,
// and replace the last element with -1. After doing so, return the array.

// Example 1:
// Input: arr = [17,18,5,4,6,1]
// Output: [18,6,6,6,1,-1]
// Explanation: 
// - index 0 --> the greatest element to the right of index 0 is index 1 (18).
// - index 1 --> the greatest element to the right of index 1 is index 4 (6).
// - index 2 --> the greatest element to the right of index 2 is index 4 (6).
// - index 3 --> the greatest element to the right of index 3 is index 4 (6).
// - index 4 --> the greatest element to the right of index 4 is index 5 (1).
// - index 5 --> there are no elements to the right of index 5, so we put -1.

// Example 2:
// Input: arr = [400]
// Output: [-1]
// Explanation: There are no elements to the right of index 0.

// Constraints:
// 1 <= arr.length <= 10^4
// 1 <= arr[i] <= 10^5




// Intuition
// Imagine you are looking at a line of numbers from right to left. 
// The last number is always replaced with -1 because there are no numbers to its right.
// As you move leftwards, keep track of the maximum number you have seen so far.
// For each number, replace it with this maximum number (the largest number seen to its right).

// Approach
// 1. Initialize a variable `max` to -1. This will keep track of the largest number seen so far.
// 2. Traverse the array from right to left.
// 3. For each element, temporarily store the current element in `temp`.
// 4. Replace the current element with the `max` value.
// 5. Update `max` to be the maximum of `temp` and the current `max`.
// 6. Continue this until the start of the array is reached.
// 7. The last element is automatically set to -1.

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1; // Initialize max as -1 because the last element should be -1.
        
        // Traverse the array from the end to the beginning
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i]; // Temporarily store the current element
            arr[i] = max;      // Replace the current element with the maximum value seen so far
            max = Math.max(temp, max); // Update max with the maximum of the current element and the previous max
        }
        
        return arr; // Return the modified array
    }
}

// Complexity Analysis
// Time Complexity: O(N), where N is the length of the array. We traverse the array only once.
// Space Complexity: O(1), as we only use a few extra variables and do not require additional space proportional to the input size.

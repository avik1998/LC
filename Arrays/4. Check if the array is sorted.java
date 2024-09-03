// Given an array arr of size n, the task is to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order. 
// If the array is sorted then return True, else return False.


// Example 1
// Input: n = 5, arr = [1,2,3,4,5]
// Output: True
// Explanation: The given array is sorted i.e Every element in the array is smaller than or equals to its next values, 
// So the answer is True.

// Example 2
// Input: n = 5, arr = [5,4,6,7,8]
// Output: False
// Explanation: The given array is Not sorted i.e Every element in the array is not smaller than or equal to its next values, 
// So the answer is False. Here element 5 is not smaller than or equal to its future elements.

// Example 3
// Input: n = 5, arr = [5,4,3,2,1]
// Output :
// False

// Constraints:
// 1 ≤ n ≤ 106
// - 109 ≤ arr[i] ≤ 109
// Note:
// Two consecutive equal values are considered to be sorted




// Intuition:
// A more efficient approach to verify if an array is sorted leverages a single pass through the array. 
// By comparing each element directly with the next one, it's possible to immediately detect any deviation from the desired order. 
// This method minimizes unnecessary comparisons and quickly identifies whether the array is sorted, as encountering just one instance where 
// an element is greater than the next confirms that the array is not sorted. This approach is both time-efficient and straightforward.

// Approach:
// Start from the first element. Compare each element with the next element in the array.
// If at any point the current element is greater than the next element, return False (the array is not sorted).
// If all comparisons are valid (the current element is less than or equal to the next element), continue to the next pair. 
// If the end of the array is reached without finding any out-of-order elements, return True.

class Solution {
    // Function to check if an array is sorted
    public boolean arraySortedOrNot(int[] arr, int n) {
        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            
            // Compare each element with the next one
            if (arr[i] > arr[i + 1]) {
                
                /* If any element is greater than the next 
                one, the array is not sorted */
                return false; 
            }
        }
        return true; // If no such pair is found, array is sorted
    }
    
    // Main method 
    public static void main(String[] args) {
        // Creating an instance of solution class
        Solution solution = new Solution();
        
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        
        // Function call to check if the array is sorted
        boolean sorted = solution.arraySortedOrNot(arr, n);
        
        if (sorted) {
            System.out.println("Array is sorted.");
        } else {
            System.out.println("Array is not sorted.");
        }
    }
}

// Complexity Analysis:

// Time Complexity: O(N)
// Perform a single traversal through the array, making a constant-time comparison for each element.

// Space Complexity: O(1)
// A constant amount of extra space for variables is used, independent of the input size.
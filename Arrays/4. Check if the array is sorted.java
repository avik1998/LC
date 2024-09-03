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
// The simplest method to verify if an array is sorted involves comparing each element with its subsequent neighbor. 
// If any element is found to be greater than the one that follows it, the array is determined to be unsorted.

// Approach:
// Start by focusing on the element at the first index. Compare this element with every subsequent element in the array.
// If this element is greater than any of the following elements, the array is not sorted.
// If the element is smaller than or equal to all subsequent elements, proceed to the next element.
// Continue this process for every element in the array. If all the elements are in proper order, the array can be said sorted.

// Edge Cases:
// If the array has zero or one element (N = 0 or N = 1), it's sorted. Return True.

class Solution {
    public boolean arraySortedOrNot(int[] arr, int n) {
        // Iterate through each element
        for (int i = 0; i < arr.length - 1; i++) {
            
            // Compare with every subsequent element
            for (int j = i + 1; j < arr.length; j++) {
                
                // If any element is out of order, return false
                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        return true; // All elements are in order
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

// Time Complexity: O(N²)
// Compare each element with all the elements that come after it. 
// This involves a nested loop: the outer loop runs N times (traversing every single element of the array with N elements) and the inner the loop runs up to N-1 times.

// Space Complexity: O(1)
// A constant amount of extra space is used because no additional data structures is needed.
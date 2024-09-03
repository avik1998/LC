// Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same. This must be done in place, without making a copy of the array.


// Example 1
// Input: nums = [0, 1, 4, 0, 5, 2]
// Output: [1, 4, 5, 2, 0, 0]
// Explanation: Both the zeroes are moved to the end and the order of the other elements stay the same

// Example 2
// Input: nums = [0, 0, 0, 1, 3, -2]
// Output: [1, 3, -2, 0, 0, 0]
// Explanation: All 3 zeroes are moved to the end and the order of the other elements stay the same

// Example 3
// Input: nums = [0, 20, 0, -20, 0, 20]
// Output : [20, -20, 20, 0, 0, 0]

// Constraints:
// 1 <= nums.length <= 105
// -104 <=nums[i] <= 104



// Intuition
// Imagine having a row of empty(represented by 0) and non empty(espresented by non zero number) boxes on a conveyor belt. Given a task to move all the empty boxes to the end of the conveyor belt while keeping the order of the boxes with items intact.

// To achieve this efficiently, you decide to use two workers (pointers) who will work together to sort the boxes. Here's how they do it:

// Worker 1 starts at the beginning of the conveyor belt and is responsible for finding the empty boxes.
// Worker 2 also starts at the beginning and will be used to keep track of where the next non-empty box should go. The process goes like this :
// Worker 1 moves along the conveyor belt, checking each box. When Worker 1 finds a non-empty box, they swap it with the box at Worker 2's position.
// After the swap, Worker 2 moves to the next position, ready to receive the next non-empty box.
// Worker 1 continues to move down the conveyor belt, repeating the process until they have checked all the boxes.
// By the end of this process, all the non-empty boxes will have been moved to the front of the conveyor belt in their original order, and all the empty boxes will have been moved to the end.

// Approach 
// Start by taking two pointers, i and j & initialize j to -1. The pointer j will be used to track the position of the first zero in the array that we encounter.
// Use a loop to move through the array and place the pointer j at the index of the first zero. If the array does not contain any zeros, exit early as no further steps are needed.
// Set the pointer i to j + 1. This positions i right after the first zero found by j. From here, i will start moving through the rest of the array to find non-zero elements.
// Now move non zero elements:
// Continue looping through the array with i.
// Whenever i encounters a non-zero element, swap the elements at positions i and j. This effectively moves the non-zero element to the position of the first zero.
// After the swap, update j to point to the next zero in the array. This is done by incrementing j by 1.
// Repeat the process until i has traversed the entire array. By the end of the loop, all non-zero elements will have been moved to the front of the array in their original order, and all zeros will be moved to the end.


import java.util.*;

class Solution {
    public int[] moveZeroes(int[] nums) {
     # Initialize j to -1
        int j = -1;
       // length of nums
        int n = nums.length; 
        
        // place the pointer j:
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // no non-zero elements:
        if (j == -1) return nums;

        /*Move the pointers i and 
        j and swap accordingly*/
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        
        // Create instance of Solution class
        Solution solution = new Solution();
        
        int[] ans = solution.moveZeros(arr);
        
        // Print the elements
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}

// Complexity Analysis 
// Time Complexity: O(N), where N is size of the array, as we are traversing the array once.
// Space Complexity: O(1) , as no use of any extra space is done to solve this problem.
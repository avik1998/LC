// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow-up: Could you solve the problem in linear time and in O(1) space?



// Intuition 
// Imagine you are at a large party, and you want to determine which dish is the most popular. Each guest has brought a dish, and some dishes are brought by more guests than others. The party is large enough that one dish is guaranteed to be the majority dish, meaning it was brought by more than half of the guests.

// Initial observation is as we move around the party, you decide to start keeping track of the dishes in a specific way. Begin with no specific dish in mind and no count. On seeing each dish, do the following:

// If you don’t have a dish you’re tracking yet, start tracking the current dish and set its count to 1.
// If the current dish matches the one you’re tracking, increase its count by 1.
// If the current dish doesn’t match the one you’re tracking, decrease the count by 1. If the count drops to zero, stop tracking that dish and start tracking the next dish.
// The idea is that at any point where the count of tracked dishes drops to zero, it means up to that point, the popularity of different dishes has balanced out. This reset allows you to focus on potentially more popular dishes as you continue through the party. At the end check which dish you ended up tracking last. This dish is your candidate for the most popular dish. To confirm if this dish is indeed the majority dish, recount its appearances to see if it indeed makes up more than half of all dishes at the party. If it does, then you have found your majority dish. If it doesn’t, there was an error in the process, but for this scenario, we assume the party is large enough to guarantee one majority dish.

// Approach 
// Initialize 2 variables: countfor tracking the count of elements and element for keeping a track of the element we are counting.
// Traverse through the given array. If count is 0 then store the current value of the array as element .
// If the current array value andelement are the same increase the count by 1. If they are different decrease the count by 1. The integer present in element should be the result expected.

import java.util.*;

class Solution {
    // Function to find the majority element in an array
    public int majorityElement(int[] nums) {
        // Size of the given array
        int n = nums.length;
        
        // Count
        int cnt = 0;
        
        // Element
        int el = 0;
        
        // Applying the algorithm
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        /* Checking if the stored element
         is the majority element*/
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        
        // Return element if it is a majority element
        if (cnt1 > (n / 2)) {
            return el;
        }
        
        // Return -1 if no such element found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        int ans = sol.majorityElement(arr);
        
        // Print the majority element found
        System.out.println("The majority element is: " + ans);
    }
}

// Complexity Analysis 
// Time Complexity: O(N) + O(N), where N is size of the given array. The first O(N) is to calculate the count and find the expected majority element. The second one is to check if the expected element is the majority one or not.
// Space Complexity: O(1) no extra space used.
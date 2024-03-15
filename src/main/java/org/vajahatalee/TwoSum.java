package org.vajahatalee;

import java.util.Arrays;
import java.util.Hashtable;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

        Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/

public class TwoSum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 7, 11, 15};
        //int[] outputArray = new TwoSum().twoSumBruteForce(inputArray, 9);
        int[] outputArray = new TwoSum().twoSumHashMap(inputArray, 9);
        //should return 2,7
        Arrays.stream(outputArray).forEach(System.out::println);
    }

    //via Brute force, complexity O(n2)
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }


    //via HashMap approach, complexity O(n), fast
    public int[] twoSumHashMap(int[] nums, int target) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < numsLength; i++) {
            int complement = target - nums[i];
            if (map.contains(complement) && map.get(complement) != i) {
                return new int[]{complement, nums[i]};
            }
        }
        return new int[]{};
    }
}
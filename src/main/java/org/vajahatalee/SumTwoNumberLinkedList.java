package org.vajahatalee;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/

public class SumTwoNumberLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);

        LinkedList<Integer> l11 = l1.reversed();
        final StringBuffer concat1= new StringBuffer();
        l11.forEach(concat1::append);
        System.out.println(concat1);

        LinkedList<Integer> l22=l2.reversed();
        final StringBuffer concat2= new StringBuffer();
        l22.forEach(concat2::append);
        System.out.println(concat2);
        String outputS = String.valueOf(Long.parseLong(concat1.toString()) + Long.parseLong(concat2.toString()));
        System.out.println("outputS"+outputS);
        LinkedList<Integer> outputL = new LinkedList<>();
        for(int s = 0; s<outputS.length();s++){
            System.out.println("outputS.charAt(s): "+outputS.charAt(s));
            outputL.add(Integer.parseInt(String.valueOf(outputS.charAt(s))));
        }

        outputL.reversed().forEach(System.out::println);

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
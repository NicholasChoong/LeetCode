/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package jav.easy._21_merge_two_sorted_lists;

import java.util.*;
// import java.easy._21_merge_two_sorted_lists.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode pointer = new ListNode();
        ListNode head = pointer;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.val = list1.val;
                list1 = list1.next;
            } else {
                pointer.val = list2.val;
                list2 = list2.next;
            }
            if (list1 != null && list2 != null) {
                pointer.next = new ListNode();
                pointer = pointer.next;
            }
        }
        if (list1 == null && list2 != null)
            pointer.next = list2;
        else
            pointer.next = list1;
        return head;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode pointer = new ListNode();
        ListNode head = pointer;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        if (list1 == null && list2 != null)
            pointer.next = list2;
        else
            pointer.next = list1;
        return head.next;
    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            head.next = mergeTwoListsRecursion(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeTwoListsRecursion(list1, list2.next);
        }
        return head;
    }

    public ListNode array2ListNode(int[] array) {
        ListNode pointer = new ListNode();
        ListNode head = pointer;
        if (array.length == 0)
            return head;
        for (int i = 0; i < array.length; i++) {
            pointer.val = array[i];
            if (i != array.length - 1) {
                pointer.next = new ListNode();
                pointer = pointer.next;
            }
        }
        return head;
    }

    public ArrayList<Integer> listNode2Array(ListNode list) {
        ArrayList<Integer> numArray = new ArrayList<>();
        int i = 0;
        while (list != null) {
            numArray.add(i, list.val);
            list = list.next;
            i++;
        }
        return numArray;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array1 = new int[] { 1, 2, 4, 7, 9 };
        int[] array2 = new int[] { 1, 3, 4 };
        ListNode list1 = sol.array2ListNode(array1);
        ListNode list2 = sol.array2ListNode(array2);
        var result = sol.mergeTwoListsRecursion(list1, list2);
        ArrayList<Integer> array = sol.listNode2Array(result);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        // int[] array11 = sol.listNode2Array(list1, array1.length);
        // for (int i = 0; i < array11.length; i++) {
        // System.out.println(array11[i]);
        // }
        // int[] array22 = sol.listNode2Array(list2, array2.length);
        // for (int i = 0; i < array22.length; i++) {
        // System.out.println(array22[i]);
        // }
    }
}
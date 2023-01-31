from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:
        if list1 is None and list2 is None:
            return None
        elif list1 is None:
            return list2
        elif list2 is None:
            return list1
        pointer = ListNode()
        head = pointer
        while list1 is not None or list2 is not None:
            if list1 is None:
                pointer.next = list2
                break
            elif list2 is None:
                pointer.next = list1
                break
            if list1.val <= list2.val:
                pointer.val = list1.val
                list1 = list1.next
            else:
                pointer.val = list2.val
                list2 = list2.next
            if list1 is not None and list2 is not None:
                pointer.next = ListNode()
                pointer = pointer.next
        return head

    def mergeTwoListsLeetCode(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:
        cur = dummy = ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
        if list1 or list2:
            cur.next = list1 or list2

        return dummy.next


def list2linked(numbers: list[int]) -> Optional[ListNode]:
    if not numbers:
        return None
    linked_list = ListNode()
    head = linked_list
    for i, number in enumerate(numbers):
        linked_list.val = number
        if i != len(numbers) - 1:
            linked_list.next = ListNode()
            linked_list = linked_list.next
    return head


def linked2list(head: Optional[ListNode]) -> list[int]:
    numbers_list = []
    while head is not None:
        numbers_list.append(head.val)
        head = head.next
    return numbers_list


if __name__ == "__main__":
    sol = Solution()
    list1 = []
    list2 = [0]
    list1 = [1, 2, 4]
    list2 = [1, 3, 5, 6]
    # list1 = ListNode(1, ListNode(2, ListNode(4)))
    # list2 = ListNode(1, ListNode(3, ListNode(5, ListNode(6))))
    print(
        linked2list(sol.mergeTwoListsLeetCode(list2linked(list1), list2linked(list2)))
    )

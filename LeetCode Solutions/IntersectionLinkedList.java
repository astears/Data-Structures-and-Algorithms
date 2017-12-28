/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// get length of two lists, then advance longer list (if there is one) so that it is same
// length as shorter list. Then traverse through both lists simultaneously and see
// if one of their nodes match. Make sure not to compare null values at end of list
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA, lenB;

        if (headA == null || headB == null) {
            return null;
        }

        lenA = getListLength(headA);
        lenB = getListLength(headB);

        if (lenA > lenB) {
            headA = advanceKNodes(headA, lenA - lenB);
        }
        else if (lenB > lenA) {
            headB = advanceKNodes(headB, lenB - lenA);
        }

        while (headA != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }

    public int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public ListNode advanceKNodes(ListNode head, int diff) {
        while (diff != 0) {
            head = head.next;
            diff--;
        }
        return head;
    }
}

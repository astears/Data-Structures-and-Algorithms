// iterative solution
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev, next;
        prev = null;
        next = head;

        while (head != null) {
            // store the next node in orig list
            next = head.next;
            // reverse the link
            head.next = prev;
            // update prev
            prev = head;
            // traverse fwd
            head = next;
        }

        // at this point my head is null, but prev has my new 1st node, return it

        return prev;
    }
}

// recursive solution
/*class Solution {
    public ListNode reverseList(ListNode head) {

        return reverseListUtil(head, null);
    }

    public ListNode reverseListUtil(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev; // return the new head once it has all been re arranged
        }
        ListNode next = curr.next; // store next node in orig list before we modify it
        curr.next = prev;          // reverse the link

        return reverseListUtil(next, curr);

    }
}*/

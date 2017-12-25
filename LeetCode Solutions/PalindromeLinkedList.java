// O(n) time, 0(1) space
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        // break list into two halves
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;       // If even, slow will be at beginning of second half :  1->1->1->1->null
        }

        if (fast != null) { // odd: slow will be at mid, make it null, no need to compare : 1->1->2->1->1->null
            ListNode mid = slow;
            slow = slow.next;
            mid = null;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev, next;
        next = head;
        prev = null;

        while (head != null) {
            next = head.next; // store next node in orig list
            head.next = prev; // move link backwards
            prev = head; // update prev node
            head = next; // traverse node fwd
        }
        head = prev;
        return head;
    }
}
// O(n) time, O(n) space
/*class Solution {
    public boolean isPalindrome(ListNode head) {
        int counter = 0;
        ListNode temp = head;
        Stack st = new Stack();

        // move head to the end of the list
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        while (head != null) {
            if (head.val != (int)st.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}*/

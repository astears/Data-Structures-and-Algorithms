class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow, prev;
        fast = slow = prev = head;
        int counter = 0;

        if (head == null) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            if (counter++ >= n) {
                prev = slow;
                slow = slow.next;
            }
        }

        // if at the beginning, advance my head one node.
        if (slow == head) {
            head = head.next; // if there is no node next, i will get null, if there is.. i eliminate myself from list
        }
        // if I am in the middle or end, make my prev.next skip me.
        else {
            prev.next = slow.next;
        }

        return head;

    }
}

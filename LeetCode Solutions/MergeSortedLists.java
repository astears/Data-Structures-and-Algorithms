
class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);// Pointer to start of new list, used to easily reference head of merged list
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1; // make the connection to next node
                l1 = l1.next; // if we already connnected this node, increment it to compare next val in list
            }
            else {
                prev.next = l2; // make the connection to the next node
                l2 = l2.next; // if we already connnected this node, increment it to compare next val in list
            }
            prev = prev.next; // this is what is making our connections as we go so lets increment it once we have made one
        }

        // if one of the lists hasn't been fully processed, lets concatenate its remaining nodes to the merged list
        if (l1 == null) {
            prev.next = l2;
        }
        else {
            prev.next = l1;
        }
        // preHead is like a double ptr, it maintains reference to the head of the merged list through it's next field
        return preHead.next;
    }
}

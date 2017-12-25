public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode walker, runner;
        walker = runner = head;

        if (head == null) {return false;}

        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (runner == walker) {
                return true;
            }
        }

        return false;
    }
}

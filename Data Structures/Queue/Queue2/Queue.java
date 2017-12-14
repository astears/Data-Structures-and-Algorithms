public class Queue {
  // FIFO behavior.. append to the head
  // 1
  // 1 2
  // 1 2 3
  // remove from the tail
  // 1 2 3
  // 2 3
  // 3

  Node head = null;
  Node tail = null;

  private class Node {
    int data;
    Node next;

    private Node(int data) {
      this.data = data;
    }
  }

  private void add(int data) {
    // If list is empty, create the head
    // At this point, the head will equal the tail
    if (head == null) {
      head = new Node(data);
      tail = head;
    }
    // Otherwise, the head will stay the same
    // and we will add to the tail
    else {
      // loop to the end of the tail and add the new node there
      while (tail.next != null) {
        tail = tail.next;
      }
      tail.next = new Node(data);
    }
  }

  private Object remove() {
    if (head == null) {
      return null;
    }
    else {
      int val = head.data;
      head = head.next;
      return val;
    }
  }

  private boolean isEmpty() {
    return head == null;
  }

  private Object peek() {
    if (head == null) {
      return null;
    }
    return head.data;
  }

  public void print() {
    	Node temp = head;
    	while (temp != null) {
    		System.out.print(temp.data + " ");
    		temp = temp.next;
    	}
      System.out.println();
  }

  public static void main (String[] args) {
		Queue myQueue = new Queue();
		System.out.println("Peek: " + myQueue.peek());
		myQueue.add(1);
		System.out.println("remove: " + myQueue.remove());
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		myQueue.print();
		System.out.println("remove: " + myQueue.remove());
		System.out.println("remove: " + myQueue.remove());
		System.out.println("remove: " + myQueue.remove());
		System.out.println("remove: " + myQueue.remove());
		//myQueue.add(2);
		myQueue.print();
		//System.out.println("Peek: " + myQueue.peek());

	}

}

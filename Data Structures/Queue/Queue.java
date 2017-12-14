public class Queue {

	private Node head = null;
	private Node tail = null;

	private class Node {
		int data;
		Node next;
		Node (int data) {
			this.data = data;
		}
	}

	// returns true if the queue is empty
	public boolean isEmpty() {
		return head == null;
	}
	// returns the value at the head of the queue
	public Object peek() {
		if (head == null) {
			return null;
		}
		return head.data;
	}
	// adds a node to the tail of the queue
	public void add (int data) {
		if (head == null) {
			head = new Node(data);
			head.next = null;
			tail = head;
			return;
		}
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = new Node(data);
	}
	// removes a node from the head of the queue
	public Object remove () {
		int val;
		if (head == null) {
			return null;
		}

		val = head.data;
		head = head.next;
		if (head == tail) {
			tail = null;
		}

		return val;
	}

	public void print() {
    	Node temp = head;
    	while (temp != null) {
    		System.out.println(temp.data);
    		temp = temp.next;
    	}
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

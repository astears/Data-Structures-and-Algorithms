// A stack is an abstract data type: a data type defined by its semantics (behavior)
// Implements a LIFO behavior.
// It is maintained by a linked list of nodes.
public class Stack {

	Node head = null;

	private class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Object peek(int data) {

		if (head == null) {
			return null;
		}

		return head.data;

	}

	public void push(int data) {
		
		if (head == null) {
			head = new Node(data);
			head.next = null;
			return;
		}

		Node temp;
		temp = head;
		head = new Node(data);
		head.next = temp;
	}

	public Object pop() {
		int val;
		if (head == null) {
			return null;
		}
		val = head.data;
		head = head.next;
		return val;
	}

	public void print() {
    	Node temp = head;
    	while (temp != null) {
    		System.out.println(temp.data);
    		temp = temp.next;
    	}
    }

	public static void main(String[] args) {

		Stack stack = new Stack();
		stack.push(1);
		System.out.println("peek: " + stack.pop());
		stack.push(2);
		System.out.println("pop: " + stack.pop());
		stack.push(3);
		stack.push(4);
		stack.print();
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
	}

}
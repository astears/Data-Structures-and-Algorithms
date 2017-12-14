public class Stack  {

  Node head = null;

  private class Node {
    int data;
    Node next;
    public Node (int data) {
      this.data = data;
    }
  }

  private void push(int data) {
    if (head == null) {
      head = new Node(data);
    }
    else {
      Node temp = head;
      head = new Node(data);
      head.next = temp;
    }
  }

  private Object pop() {
    if (head == null) {
      return null;
    }
    else {
      int val = head.data;
      head = head.next;
      return val;
    }
  }

  private Object peek() {
    if (head == null) {
      return null;
    }
    else {
      return head.data;
    }
  }

  private boolean isEmpty() {
    return head == null;
  }

  private void print() {
    for (Node temp = head; temp != null; temp = temp.next) {
      System.out.print(temp.data + " ");
    }
    System.out.println();
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

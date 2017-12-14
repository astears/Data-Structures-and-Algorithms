

// A Linkedlist is a dynamic (resizable) linear data structure. It is a collection of nodes connected to eachother via Node ptrs
// A linked list often isnt represented contiguously in memory since nodes are added dynamically.
// A common singly-linked list node contains some data and a ptr to the next node or null if there isnt another node in the lst
// A Linked list is better than an array when the size of an array isn't know before compilation and insertion and deletion of nodes is essential
// Common LinkedList methods are:
// 1. Add - add an element E to the end of the list
// 2. insertAt - to insert an element somewhere other than the end of the array
// 3. delete - deletes an element from the list


public class LinkedList {

	Node head = null;
	int size = 0;

	private class Node {
    	int data;
    	Node next;
    	Node (int d) {
    		data = d;
    		size++;
    	}
 	}

    public void add (int data) {

    	Node temp = this.head;
    	if (this.head == null) {
    		head = new Node(data);
    		return;
    	}

    	while (temp.next != null) {
    		temp = temp.next;
    		//System.out.println("adding node after head " + data);
    	}
    	temp.next = new Node(data);
    	temp.next.next = null;

    }

    public void delete(int value) {
    	Node temp = head;
    	Node prev = temp;

    	if (value == head.data) {
    		head = head.next;
    		this.size--;
    		return;
    	}

    	while (temp != null) {
    		if (temp.data == value) {
    			prev.next = temp.next;
    			this.size--;
    			return;
    		}
    		prev = temp;
    		temp = temp.next;
    	}
    }

    public void print() {
    	Node temp = head;
    	while (temp != null) {
    		System.out.println(temp.data);
    		temp = temp.next;
    	}
    }

    public static void main(String[] args) {

    	LinkedList list = new LinkedList();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.print();
    	System.out.println("size of list:" + list.size);
    	System.out.println("After Deleting 1");
    	list.delete(1);
    	list.print();
    	System.out.println("size of list:" + list.size);
    	

    }

}

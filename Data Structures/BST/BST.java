// A Binary search tree is a tree data structure where each parent Node
// has no more than two children nodes, a left child and a right child.
// The parent node of each subtree must be greater than or equal to
// (if duplicates are allowed) it's left child
// and less than it's right child.
//
//                8    <-- Root
//              /  \
//             3   10
//           / \     \
//          1  6     14
//            / \    /
//           4   7  13  <--- leaves because they have no children


import java.util.LinkedList;

public class BST {

	private Node root;

	private class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	// This is the method that the user calls
	private void insert(int data) {
		// a helper function is used so that way the user doesn't have to pass
		// in the root to each call
		this.root = insertRec(this.root, data);
	}

	private Node insertRec(Node root, int data) {

		// once we have recurred to the appropriate leaf, create the node
		// and return a reference to it so that way it's parent can link to it
		if (root == null) {
			root = new Node(data);
			return root;	// we must return root so that way it's reference isn't lost
		}
		// if data is greater than current parent node, recur down right subtree
		else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}
		// if data is less than current parent node, than recur down left subtree
		else if (data < root.data) {
			root.left = insertRec(root.left, data);
		}

		return root;
	}
	// Time & space complexity: worst - O(h) = O(logn)
	private void search(int data) {

		if (searchRec(this.root, data)) {
			System.out.println("Found: " + data);
		}
		else {
			System.out.println("Did not find: " + data);
		}
	}

	private boolean searchRec(Node root, int data) {

		if (root == null) {
			return false;
		}

		if (data < root.data) {
			boolean found = searchRec(root.left, data);
			return found;
		}
		else if (data > root.data) {
			boolean found = searchRec(root.right, data);
			return found;
		}
		else {
			return true;
		}
	}

	private void delete(int data) {
		deleteRec(this.root, data);
	}

	private Node deleteRec(Node root, int data) {
		// Didn't find the node
		if (root == null) {
			return root;
		}
    // find the node first!
		if (data > root.data) {
			// I am potentially reassigning the address of root.right to some other value
			// in the call to deleteRec. If i don't return that new address when I return
			// from deleteRec then root.right will still refer to the OLD root.right address
			root.right = deleteRec(root.right, data);
		}
		else if (data < root.data) {
			root.left = deleteRec(root.left, data);
		}
		// found the node!
		else {
			// case 1: Node to be deleted has NO CHILDREN
			if (root.left == null && root.right == null) {
				root = null;
			}
			// case 2: Node to be deleted has ONE CHILD
			else if (root.left == null) { // I only have a right child
				root = root.right; // reassign my address to my only child
			}
			else if (root.right == null) {
				root = root.left;
			}
			// case 3: Node to be deleted has TWO CHILDREN
			else {
				// Find the MIN data val in the right subtree and assign it
				// to the val of the node to be deleted.
				// then delete that min node from the right subtree
				Node min = findMin(root.right);
				root.data = min.data;
				root.right = deleteRec(root.right, min.data);
			}

		}

		return root;
	}

	private Node findMin(Node root) {
		// found min value
		if (root.left == null) {
			return root;
		}
		return findMin(root.left);
	}

	// Traversal algorithms:
	// DFS - Preorder, Inorder, PostOrder
	// 			 DFS is recursive so memory (stack) grows proportional to recursive calls
	// 			 Time Complexity: 	All cases - O(n)... has to visit all nodes every time
	//       Space Complexity: 	Best/Avg - O(logn) .. tree is balanced
  //												  Worst - O(n) .. tree is linear
	// BFS - levelOrder
	//       BFS keeps a queue of univisited nodes and visits nodes at each
	//       level before moving to next level
	//
	//       Time Complexity:   All cases: O(n) .. has to visit all nodes
	//       Space Complexity:  "Best case": O(1).. tree is a linked list and only
	//																						one element is kept in queue
	//                          Avg/Worst: O(n)
	private void printInOrder() {
		printInOrderRec(this.root);
	}

	private void printInOrderRec(Node root) {
		if (root != null) {
			printInOrderRec(root.left);
			System.out.println(root.data);
			printInOrderRec(root.right);
		}
	}

	private void printPreOrder() {
		printPreOrderRec(this.root);
	}

	private void printPreOrderRec(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printPreOrderRec(root.left);
			printPreOrderRec(root.right);
		}
	}

	private void printPostOrder() {
		printPostOrderRec(this.root);
	}

	private void printPostOrderRec(Node root) {
		if (root != null) {
			printPostOrderRec(root.left);
			printPostOrderRec(root.right);
			System.out.println(root.data);
		}
	}


	public void levelOrder() {
		java.util.LinkedList<Node> queue = new java.util.LinkedList<Node>();

		if (this.root != null) {
			queue.add(this.root);
		}

		while (queue.size() != 0) {
			Node current = queue.remove();
			if (current.left != null) {queue.add(current.left);}
			if (current.right != null) {queue.add(current.right);}
			System.out.println(current.data);
		}

	}

	public static void main(String[] args) {
		BST tree = new BST();

		tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    //tree.insert(60);
    tree.insert(80);

		tree.delete(40);
		tree.printInOrder();

	}

}

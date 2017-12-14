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

public class BST {

	public Node root;

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

		if (root == null) {
			root = new Node(data);
			return root;	// we must return root so that way it's reference isn't lost
		}
		else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}
		else if (data < root.data) {
			root.left = insertRec(root.left, data);
		}
		return root;
	}
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

	public static void main(String[] args) {
		BST tree = new BST();

		tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

		tree.printInOrder();

	}

}

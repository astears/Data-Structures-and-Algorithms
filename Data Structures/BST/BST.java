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

	public static void main(String[] args) {
		BST tree = new BST();

		tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

		tree.printPreOrder();

	}

}

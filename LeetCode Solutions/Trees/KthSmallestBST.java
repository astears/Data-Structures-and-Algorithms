/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }

                 7
             5    9
           3   6  8  11
 * }
 *      Idea: traverse down to the smallest element. When I reach the bottom, go back up k spots and save that value.
 */


class kthSmallestBST {
    public int val = -1;
    public int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverseToSmallest(root, k);
        return val;
    }

    public void traverseToSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverseToSmallest(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
        }

        traverseToSmallest(root.right, k);
    }
}

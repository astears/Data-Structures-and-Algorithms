/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
        Idea: Need to know the HEIGHT of the tree. Count how many levels there are using BFS
 */
class MaxDepthBST {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 0;
        if (root == null) {
            return 0;
        }

        queue.add(root);

        while (queue.size() > 0) {
            int nodesAtCurrLevel = queue.size();
            while (nodesAtCurrLevel-- > 0) {
                TreeNode currNode = queue.remove();
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            count++;
        }

        return count;
    }
}

class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return preOrderTraversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean preOrderTraversal(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return (preOrderTraversal(root.left, min, root.val) &&
        preOrderTraversal(root.right, root.val, max));
    }
}

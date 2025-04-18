import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

//TC: O(n)
//SC:: O(h)

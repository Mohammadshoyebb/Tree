/**
 * 965. Univalued Binary Tree
 * Solved
 * Easy
 * Topics: Binary Tree, Depth-First Search
 * 
 * A binary tree is uni-valued if every node in the tree has the same value.
 * 
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 * 
 * Example 1:
 * 
 * Input: root = [1,1,1,1,1,null,1]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: root = [2,2,2,5,2]
 * Output: false
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * 0 <= Node.val < 100
 * 
 * Solution:
 * We can solve this problem using a depth-first search (DFS) approach. The idea is to traverse the tree 
 * and check if all nodes have the same value as the root node.
 * 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 public class UnivaluedBinaryTree {
    
    // Method to check if a binary tree is univalued
    public boolean isUnivalTree(TreeNode root) {
        // If the tree is empty, it is considered univalued
        if (root == null) {
            return true;
        }
        // Start the DFS traversal and check for univalued property
        return dfs(root, root.val);
    }
    
    // Helper method for DFS traversal
    private boolean dfs(TreeNode node, int value) {
        // If we reach a null node, return true
        if (node == null) {
            return true;
        }
        // If the current node's value does not match the given value, return false
        if (node.val != value) {
            return false;
        }
        // Recursively check left and right subtrees
        return dfs(node.left, value) && dfs(node.right, value);
    }
    
    public static void main(String[] args) {
        // Example 1: root = [1,1,1,1,1,null,1]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        UnivaluedBinaryTree solution1 = new UnivaluedBinaryTree();
        System.out.println(solution1.isUnivalTree(root1)); // Output: true

        // Example 2: root = [2,2,2,5,2]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(2);
        UnivaluedBinaryTree solution2 = new UnivaluedBinaryTree();
        System.out.println(solution2.isUnivalTree(root2)); // Output: false
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

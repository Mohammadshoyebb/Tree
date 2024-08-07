/**
 * 257. Binary Tree Paths
 * Solved
 * Easy
 * Topics: Binary Tree, Depth-First Search
 * 
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * 
 * Example 2:
 * 
 * Input: root = [1]
 * Output: ["1"]
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



import java.util.*;
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>(); // Initialize the result list
        if (root == null) {
            return result; // If the tree is empty, return an empty list
        }
        dfs(root, "", result); // Perform depth-first search to find all root-to-leaf paths
        return result; // Return the result list
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            // If the current node is a leaf node, add the path to the result list
            result.add(path + node.val);
            return;
        }
        // If the current node has a left child, recursively explore the left subtree
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", result);
        }
        // If the current node has a right child, recursively explore the right subtree
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", result);
        }
    }

    public static void main(String[] args) {
        // Example 1: root = [1,2,3,null,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        BinaryTreePaths solution1 = new BinaryTreePaths();
        System.out.println(solution1.binaryTreePaths(root1)); // Output: ["1->2->5","1->3"]

        // Example 2: root = [1]
        TreeNode root2 = new TreeNode(1);
        BinaryTreePaths solution2 = new BinaryTreePaths();
        System.out.println(solution2.binaryTreePaths(root2)); // Output: ["1"]
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

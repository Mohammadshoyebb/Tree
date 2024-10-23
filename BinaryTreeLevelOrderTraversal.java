

/**
 * 102. Binary Tree Level Order Traversal
 * Solved
 * Medium
 * Topics: Binary Tree, Breadth-First Search, Queue
 * 
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * 
 * Example 2:
 * 
 * Input: root = [1]
 * Output: [[1]]
 * 
 * Example 3:
 * 
 * Input: root = []
 * Output: []
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
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

 import java.util.*;
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        if (root == null) {
            return result; // If the tree is empty, return an empty list
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Create a queue to perform level-order traversal
        queue.offer(root); // Add the root node to the queue

        while (!queue.isEmpty()) { // Continue until the queue is empty
            int levelSize = queue.size(); // Get the size of the current level
            List<Integer> currentLevel = new ArrayList<>(); // Initialize a list to store nodes at the current level

            for (int i = 0; i < levelSize; i++) { // Traverse all nodes at the current level
                TreeNode node = queue.poll(); // Remove the front node from the queue
                currentLevel.add(node.val); // Add the value of the current node to the current level list

                // Add the children of the current node to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel); // Add the current level list to the result list
        }

        return result; // Return the result list after traversal
    }

    public static void main(String[] args) {
        // Example 1: root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversal solution1 = new BinaryTreeLevelOrderTraversal();
        System.out.println(solution1.levelOrder(root1)); // Output: [[3],[9,20],[15,7]]

        // Example 2: root = [1]
        TreeNode root2 = new TreeNode(1);
        BinaryTreeLevelOrderTraversal solution2 = new BinaryTreeLevelOrderTraversal();
        System.out.println(solution2.levelOrder(root2)); // Output: [[1]]

        // Example 3: root = []
        TreeNode root3 = null;
        BinaryTreeLevelOrderTraversal solution3 = new BinaryTreeLevelOrderTraversal();
        System.out.println(solution3.levelOrder(root3)); // Output: []
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

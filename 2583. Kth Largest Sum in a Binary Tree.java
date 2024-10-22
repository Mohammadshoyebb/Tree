/**
 * 2583. Kth Largest Sum in a Binary Tree
 * 
 * You are given the root of a binary tree and a positive integer k.
 * 
 * The level sum in the tree is the sum of the values of the nodes that are on the same level.
 * 
 * Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer 
 * than k levels in the tree, return -1.
 * 
 * Note that two nodes are on the same level if they have the same distance from the root.
 * 
 * Example 1:
 * Input: root = [5,8,9,2,1,3,7,4,6], k = 2
 * Output: 13
 * Explanation:
 * - Level 1: 5.
 * - Level 2: 8 + 9 = 17.
 * - Level 3: 2 + 1 + 3 + 7 = 13.
 * - Level 4: 4 + 6 = 10.
 * The 2nd largest level sum is 13.
 * 
 * Example 2:
 * Input: root = [1,2,null,3], k = 1
 * Output: 3
 * Explanation: The largest level sum is 3.
 * 
 * Constraints:
 * - The number of nodes in the tree is n.
 * - 2 <= n <= 10^5
 * - 1 <= Node.val <= 10^6
 * - 1 <= k <= n
 */

import java.util.*;

public class KthLargestSumInBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
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

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        // Use a priority queue (min-heap) to keep track of the largest sums.
        Queue<Long> pq = new PriorityQueue<>();
        
        // Perform level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;

            // Sum all nodes in the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Add the current level sum to the min-heap
            pq.offer(levelSum);

            // Maintain only the k largest sums in the heap
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // If we have fewer than k levels, return -1
        return pq.size() == k ? pq.peek() : -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        KthLargestSumInBinaryTree solution = new KthLargestSumInBinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(6);
        System.out.println(solution.kthLargestLevelSum(root1, 2)); // Output: 13

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        System.out.println(solution.kthLargestLevelSum(root2, 1)); // Output: 3
    }
}

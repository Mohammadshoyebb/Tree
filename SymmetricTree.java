/**
 * 101. Symmetric Tree
 * Solved
 * Easy
 * Topics: Binary Tree, Depth-First Search, Breadth-First Search
 * 
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 
 * Example 1:
 * 
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * 
 * Follow up: Could you solve it both recursively and iteratively?
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



//  Explanation:
// Class and Method Descriptions: The class and method descriptions provide an overview of what each part of the code does.

// Recursive Approach:

// The isSymmetricRecursive method calls the isMirror helper method to check if the left and right subtrees are mirrors of each other.
// The isMirror method checks if two trees are mirrors:
// Both trees are null: return true.
// One tree is null and the other is not: return false.
// Both trees are non-null and their values are equal: recursively check the left subtree of the first tree with the right subtree of the second tree, and the right subtree of the first tree with the left subtree of the second tree.
// Iterative Approach:

// The isSymmetricIterative method uses a queue to perform a level-by-level check.
// Initially, add the left and right children of the root to the queue.
// While the queue is not empty, check pairs of nodes for symmetry:
// Both nodes are null: continue.
// One node is null and the other is not: return false.
// Both nodes are non-null and their values are equal: add their children to the queue in the order required to check symmetry.
// Main Method: The main method provides example test cases to demonstrate how the solution can be tested.


import java.util.*;
public class SymmetricTree {

    // Recursive approach to check if the tree is symmetric
    public boolean isSymmetricRecursive(TreeNode root) {
        // A null tree is symmetric by definition
        if (root == null) return true;
        // Start the recursive check from the root's left and right children
        return isMirror(root.left, root.right);
    }

    // Helper method to recursively check if two subtrees are mirrors of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both nodes are null, so they are symmetric
        if (t1 == null && t2 == null) return true;
        // One node is null but the other is not, so they are not symmetric
        if (t1 == null || t2 == null) return false;
        // Both nodes have the same value and their subtrees are mirrors of each other
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    // Iterative approach to check if the tree is symmetric
    public boolean isSymmetricIterative(TreeNode root) {
        // A null tree is symmetric by definition
        if (root == null) return true;
        // Queue to hold nodes for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the left and right children of the root to the queue
        queue.add(root.left);
        queue.add(root.right);
        // Process the queue until it's empty
        while (!queue.isEmpty()) {
            // Remove two nodes from the queue
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            // Both nodes are null, continue to the next pair
            if (t1 == null && t2 == null) continue;
            // One node is null but the other is not, they are not symmetric
            if (t1 == null || t2 == null) return false;
            // The values of the nodes are different, they are not symmetric
            if (t1.val != t2.val) return false;
            // Add children of the nodes to the queue in the correct order
            // Add left child of t1 and right child of t2
            queue.add(t1.left);
            queue.add(t2.right);
            // Add right child of t1 and left child of t2
            queue.add(t1.right);
            queue.add(t2.left);
        }
        // All nodes matched symmetrically
        return true;
    }

    public static void main(String[] args) {
        // Example 1: root = [1,2,2,3,4,4,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        SymmetricTree solution1 = new SymmetricTree();
        System.out.println(solution1.isSymmetricRecursive(root1)); // Output: true
        System.out.println(solution1.isSymmetricIterative(root1)); // Output: true

        // Example 2: root = [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        SymmetricTree solution2 = new SymmetricTree();
        System.out.println(solution2.isSymmetricRecursive(root2)); // Output: false
        System.out.println(solution2.isSymmetricIterative(root2)); // Output: false
    }
}

// Definition for a binary tree node
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
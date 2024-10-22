/*
 145. Binary Tree Postorder Traversal
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 */

 import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreePostorderTraversal {

    // Recursive approach
    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }

    // Main iterative approach (Shash Code's Provided Approach)
    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            }

            // Check the right child of the top node in the stack
            if (!stack.isEmpty() && stack.peek().right != null) {
                currentNode = stack.peek().right;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);

                // Process the nodes that are right children
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    result.add(temp.val);
                }
            }
        }
        return result;
    }

    // Slow iterative approach
    public static List<Integer> postorderTraversalSlow(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }

    // Main method to test all approaches
    public static void main(String[] args) {
        // Test case 1: root = [1, null, 2, 3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        System.out.println("Recursive Approach Output: " + postorderTraversalRecursive(root1)); // Output: [3, 2, 1]
        System.out.println("Main Iterative Approach Output: " + postorderTraversalIterative(root1)); // Output: [3, 2, 1]
        System.out.println("Slow Iterative Approach Output: " + postorderTraversalSlow(root1)); // Output: [3, 2, 1]

        // Test case 2: root = []
        TreeNode root2 = null;

        System.out.println("Recursive Approach Output: " + postorderTraversalRecursive(root2)); // Output: []
        System.out.println("Main Iterative Approach Output: " + postorderTraversalIterative(root2)); // Output: []
        System.out.println("Slow Iterative Approach Output: " + postorderTraversalSlow(root2)); // Output: []

        // Test case 3: root = [1]
        TreeNode root3 = new TreeNode(1);

        System.out.println("Recursive Approach Output: " + postorderTraversalRecursive(root3)); // Output: [1]
        System.out.println("Main Iterative Approach Output: " + postorderTraversalIterative(root3)); // Output: [1]
        System.out.println("Slow Iterative Approach Output: " + postorderTraversalSlow(root3)); // Output: [1]
    }
}

/**
 * 145. Binary Tree Postorder Traversal
 * Solved
 * Easy
 * Topics: Binary Tree, Depth-First Search, Stack
 * 
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example 1:
 * 
 * Input: root = [1, null, 2, 3]
 * Output: [3, 2, 1]
 * 
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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

// The postorderTraversalRecursive method initializes a list to store the traversal result and calls the helper method postorderHelper.
// The postorderHelper method:
// Base Case: If the node is null, return.

// Recursive Case:
// Recursively call postorderHelper on the left subtree.
// Recursively call postorderHelper on the right subtree.
// Add the value of the current node to the result list.



// Iterative Approach:

// The postorderTraversalIterative method initializes a list to store the traversal result, a stack to manage nodes,
// and a pointer lastVisited to keep track of the last visited node.
// The main loop continues until there are nodes in the stack or the current node is not null.
// If current is not null:
// Push current to the stack.
// Move to the left child of current.
// If current is null:
// Peek the top node from the stack without removing it.
// If the right child of the peeked node exists and has not been visited:
// Move to the right child.
// Otherwise:
// Pop the stack, visit the node, and mark it as the last visited node by adding it to the result list.
// Main Method: The main method provides example test cases to demonstrate how the solution can be tested.
// Each test case prints the result of both the recursive and iterative approaches to verify correctness.




import java.util.*;
public class BinaryTreePostorderTraversal {

    // Recursive approach to postorder traversal
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result); // Helper method to perform the recursion
        return result; // Return the result list after traversal
    }

    // Helper method for the recursive approach
    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        // Recursively visit the left subtree
        postorderHelper(node.left, result);
        // Recursively visit the right subtree
        postorderHelper(node.right, result);
        // Add the value of the current node to the result list
        result.add(node.val);
    }

    // Iterative approach to postorder traversal
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // If the tree is empty, return an empty list
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null; // To keep track of the last visited node
        TreeNode current = root;

        // Iterate while there are nodes to be processed
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                // Push current node to the stack and move to its left child
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = stack.peek(); // Look at the top node without removing it from the stack
                // If the right child exists and is not the last visited node, move to the right child
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    // Visit the node and mark it as the last visited
                    stack.pop();
                    result.add(peekNode.val);
                    lastVisited = peekNode;
                }
            }
        }
        return result; // Return the result list after traversal
    }

    public static void main(String[] args) {
        // Example 1: root = [1, null, 2, 3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        BinaryTreePostorderTraversal solution1 = new BinaryTreePostorderTraversal();
        System.out.println(solution1.postorderTraversalRecursive(root1)); // Output: [3, 2, 1]
        System.out.println(solution1.postorderTraversalIterative(root1)); // Output: [3, 2, 1]

        // Example 2: root = []
        TreeNode root2 = null;
        BinaryTreePostorderTraversal solution2 = new BinaryTreePostorderTraversal();
        System.out.println(solution2.postorderTraversalRecursive(root2)); // Output: []
        System.out.println(solution2.postorderTraversalIterative(root2)); // Output: []

        // Example 3: root = [1]
        TreeNode root3 = new TreeNode(1);
        BinaryTreePostorderTraversal solution3 = new BinaryTreePostorderTraversal();
        System.out.println(solution3.postorderTraversalRecursive(root3)); // Output: [1]
        System.out.println(solution3.postorderTraversalIterative(root3)); // Output: [1]
    }
}

// Definition for a binary tree node.
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

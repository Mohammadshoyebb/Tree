// Binary Tree Preorder Traversal
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Definition for a binary tree node.
import java.util.*;
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

public class BinaryTreePreorderTraversal {

    // Recursive approach
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val); // Visit the root
        preorderHelper(root.left, result); // Traverse left subtree
        preorderHelper(root.right, result); // Traverse right subtree
    }

    // Iterative approach using stack
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val); // Visit the root

            if (node.right != null) {
                stack.push(node.right); // Push right child to stack
            }
            if (node.left != null) {
                stack.push(node.left); // Push left child to stack
            }
        }
        return result;
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();

        // Create test cases
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(solution.preorderTraversal(root1)); // Output: [1, 2, 3]
        System.out.println(solution.preorderTraversalIterative(root1)); // Output: [1, 2, 3]

        TreeNode root2 = null;
        System.out.println(solution.preorderTraversal(root2)); // Output: []
        System.out.println(solution.preorderTraversalIterative(root2)); // Output: []

        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.preorderTraversal(root3)); // Output: [1]
        System.out.println(solution.preorderTraversalIterative(root3)); // Output: [1]
    }
}

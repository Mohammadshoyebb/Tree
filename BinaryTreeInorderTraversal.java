// Binary Tree Inorder Traversal
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Example:
// Input: root = [1,null,2,3]
// Output: [1,3,2]

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

public class BinaryTreeInorderTraversal {

    // Recursive approach
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, result); // Traverse left subtree
        result.add(root.val); // Visit the root
        inorderHelper(root.right, result); // Traverse right subtree
    }

    // Iterative approach using stack
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val); // Visit the root
            current = current.right;
        }

        return result;
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

        // Create test cases
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(solution.inorderTraversal(root1)); // Output: [1, 3, 2]
        System.out.println(solution.inorderTraversalIterative(root1)); // Output: [1, 3, 2]

        TreeNode root2 = null;
        System.out.println(solution.inorderTraversal(root2)); // Output: []
        System.out.println(solution.inorderTraversalIterative(root2)); // Output: []

        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.inorderTraversal(root3)); // Output: [1]
        System.out.println(solution.inorderTraversalIterative(root3)); // Output: [1]
    }
}

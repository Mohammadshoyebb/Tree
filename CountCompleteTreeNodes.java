/**
 * 222. Count Complete Tree Nodes
 * Solved
 * Easy
 * Topics: Binary Tree, Depth-First Search
 * 
 * Given the root of a complete binary tree, return the number of nodes in the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.
 * 
 * Design an algorithm that runs in less than O(n) time complexity.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * 
 * Example 2:
 * 
 * Input: root = []
 * Output: 0
 * 
 * Example 3:
 * 
 * Input: root = [1]
 * Output: 1
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5 * 10^4].
 * 0 <= Node.val <= 5 * 10^4
 * The tree is guaranteed to be complete.
 * 
 * Solution:
 * We can solve this problem using a binary search approach to count the number of nodes efficiently.
 * Since the tree is complete, we can take advantage of its properties to reduce the complexity.
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

// Counting Nodes:
// If the tree is empty (root == null), return 0.
// Calculate the depth of the left and right subtrees.
// If the left and right depths are the same, the left subtree is a perfect binary tree.
// Use bit shifting (1 << leftDepth) to calculate the number of nodes in the left subtree.
// Recursively count the nodes in the right subtree.
// If the left and right depths are not the same, the right subtree is a perfect binary tree of height leftDepth - 1.
// Use bit shifting (1 << rightDepth) to calculate the number of nodes in the right subtree.
// Recursively count the nodes in the left subtree.
// Depth Calculation: The getDepth method calculates the depth of the tree by traversing the leftmost path.
// Main Method: The main method provides example test cases to demonstrate how the solution can be tested.







 public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // Left subtree is a perfect binary tree
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // Right subtree is a perfect binary tree of height leftDepth - 1
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        // Example 1: root = [1,2,3,4,5,6]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        CountCompleteTreeNodes solution1 = new CountCompleteTreeNodes();
        System.out.println(solution1.countNodes(root1)); // Output: 6

        // Example 2: root = []
        TreeNode root2 = null;
        CountCompleteTreeNodes solution2 = new CountCompleteTreeNodes();
        System.out.println(solution2.countNodes(root2)); // Output: 0

        // Example 3: root = [1]
        TreeNode root3 = new TreeNode(1);
        CountCompleteTreeNodes solution3 = new CountCompleteTreeNodes();
        System.out.println(solution3.countNodes(root3)); // Output: 1
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
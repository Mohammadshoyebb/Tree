/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * 
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree 
 * such that every key of the original BST is changed to the original key 
 * plus the sum of all keys greater than the original key in BST.
 * 
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 
 * Example 2:
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * 0 <= Node.val <= 100
 * All the values in the tree are unique.
 */

 import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeToGreaterSumTree {
    private int sum = 0; // Instance variable to maintain the running sum

    public TreeNode bstToGst(TreeNode root) {
        // Base case: if the node is null, simply return null
        if (root == null) {
            return null;
        }

        // Traverse the right subtree first (reverse in-order traversal)
        bstToGst(root.right);

        // Update the sum and the current node's value
        sum += root.val;
        root.val = sum;

        // Traverse the left subtree
        bstToGst(root.left);

        // Return the root of the transformed tree
        return root;
    }

    // Method to print the tree for verification in level-order traversal
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        
        // Remove trailing nulls
        while (sb.length() > 1 && sb.substring(sb.length() - 5).equals("null,")) {
            sb.delete(sb.length() - 5, sb.length());
        }

        sb.deleteCharAt(sb.length() - 1); // Remove last comma
        sb.append("]");
        System.out.println(sb.toString());
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(4, 
            new TreeNode(1, 
                new TreeNode(0), 
                new TreeNode(2, null, new TreeNode(3))
            ), 
            new TreeNode(6, 
                new TreeNode(5), 
                new TreeNode(7, null, new TreeNode(8))
            )
        );

        // Example 2
        TreeNode root2 = new TreeNode(0, 
            null, 
            new TreeNode(1)
        );

        BinarySearchTreeToGreaterSumTree solution = new BinarySearchTreeToGreaterSumTree();
        root1 = solution.bstToGst(root1);
        root2 = solution.bstToGst(root2);

        System.out.print("Example 1 Output: ");
        printTree(root1); // Should output the transformed tree in level-order traversal

        System.out.print("Example 2 Output: ");
        printTree(root2); // Should output the transformed tree in level-order traversal
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
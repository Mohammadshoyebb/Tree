/**
 * 1325. Delete Leaves With a Given Value
 * Solved
 * Medium
 * Topics: Binary Tree, Depth-First Search
 * 
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 * 
 * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node
 * and has the value target, it should also be deleted (you need to continue doing that until you cannot).
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left). 
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 * 
 * Example 2:
 * 
 * Input: root = [1,3,3,3,2], target = 3
 * Output: [1,3,null,null,2]
 * 
 * Example 3:
 * 
 * Input: root = [1,2,null,2,null,2], target = 2
 * Output: [1]
 * Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3000].
 * 1 <= Node.val, target <= 1000
 */

 

public class DeleteLeavesWithGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null; // If the root is null, return null (base case)
        }
        
        // Recursively process left and right subtrees
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        
        // Check if the current node is a leaf node and has the target value
        if (root.left == null && root.right == null && root.val == target) {
            return null; // If so, remove the leaf node by returning null
        }
        
        return root; // Otherwise, return the current node
    }

    public static void main(String[] args) {
        // Example 1: root = [1,2,3,2,null,2,4], target = 2
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(2);
        root1.left.right = null;
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);
        int target1 = 2;
        DeleteLeavesWithGivenValue solution1 = new DeleteLeavesWithGivenValue();
        TreeNode result1 = solution1.removeLeafNodes(root1, target1);
        printTree(result1); // Output: [1,null,3,null,4]

        // Example 2: root = [1,3,3,3,2], target = 3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(2);
        int target2 = 3;
        DeleteLeavesWithGivenValue solution2 = new DeleteLeavesWithGivenValue();
        TreeNode result2 = solution2.removeLeafNodes(root2, target2);
        printTree(result2); // Output: [1,3,null,null,2]

        // Example 3: root = [1,2,null,2,null,2], target = 2
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = null;
        root3.left.left = null;
        root3.left.right = new TreeNode(2);
        root3.left.right.left = null;
        root3.left.right.right = new TreeNode(2);
        int target3 = 2;
        DeleteLeavesWithGivenValue solution3 = new DeleteLeavesWithGivenValue();
        TreeNode result3 = solution3.removeLeafNodes(root3, target3);
        printTree(result3); // Output: [1]

    }

    // Helper method to print the tree (for visualization)
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
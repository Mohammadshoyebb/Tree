/**
 * 2331. Evaluate Boolean Binary Tree
 * Solved
 * Easy
 * Topics: Binary Tree, Depth-First Search
 * 
 * You are given the root of a full binary tree with the following properties:
 * 
 * Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
 * Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
 * The evaluation of a node is as follows:
 * 
 * If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
 * Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
 * Return the boolean result of evaluating the root node.
 * 
 * A full binary tree is a binary tree where each node has either 0 or 2 children.
 * A leaf node is a node that has zero children.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3,null,null,0,1]
 * Output: true
 * Explanation: The above diagram illustrates the evaluation process.
 * The AND node evaluates to False AND True = False.
 * The OR node evaluates to True OR False = True.
 * The root node evaluates to True, so we return true.
 * 
 * Example 2:
 * 
 * Input: root = [0]
 * Output: false
 * Explanation: The root node is a leaf node and it evaluates to false, so we return false.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 3
 * Every node has either 0 or 2 children.
 * Leaf nodes have a value of 0 or 1.
 * Non-leaf nodes have a value of 2 or 3.
 */

 

public class EvaluateBooleanBinaryTree {

    public boolean evaluateBooleanBinaryTree(TreeNode root) {
        // If the root is null, return false
        if (root == null) {
            return false;
        }
        
        // Evaluate the root node
        return evaluateNode(root);
    }
    
    // Method to evaluate a node
    private boolean evaluateNode(TreeNode node) {
        // If the node is a leaf node, return its value
        if (node.left == null && node.right == null) {
            return node.val == 1;
        }
        
        // Evaluate the left and right subtrees recursively
        boolean leftValue = evaluateNode(node.left);
        boolean rightValue = evaluateNode(node.right);
        
        // Apply the boolean operation based on the node's value
        if (node.val == 2) { // OR operation
            return leftValue || rightValue;
        } else { // AND operation
            return leftValue && rightValue;
        }
    }

    public static void main(String[] args) {
        // Example 1: root = [2,1,3,null,null,0,1]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(1);
        EvaluateBooleanBinaryTree solution1 = new EvaluateBooleanBinaryTree();
        System.out.println(solution1.evaluateBooleanBinaryTree(root1)); // Output: true

        // Example 2: root = [0]
        TreeNode root2 = new TreeNode(0);
        EvaluateBooleanBinaryTree solution2 = new EvaluateBooleanBinaryTree();
        System.out.println(solution2.evaluateBooleanBinaryTree(root2)); // Output: false
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

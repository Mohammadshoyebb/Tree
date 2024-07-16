/**
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * Solved
 * Medium
 * Topics
 * Companies
 * 
 * Hint:
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. 
 * You are also given an integer startValue representing the value of the start node s, and a different 
 * integer destValue representing the value of the destination node t.
 * 
 * Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of 
 * such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates 
 * a specific direction:
 * 
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * 
 * Return the step-by-step directions of the shortest path from node s to node t.
 * 
 * Example 1:
 * Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * Output: "UURL"
 * Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
 * 
 * Example 2:
 * Input: root = [2,1], startValue = 2, destValue = 1
 * Output: "L"
 * Explanation: The shortest path is: 2 → 1.
 * 
 * Constraints:
 * The number of nodes in the tree is n.
 * 2 <= n <= 105
 * 1 <= Node.val <= n
 * All the values in the tree are unique.
 * 1 <= startValue, destValue <= n
 * startValue != destValue
 */

/**
 * Definition for a binary tree node.
 */
/**
 * Definition for a binary tree node.
 */
class BinaryTreeDirections {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder path1 = new StringBuilder();
        getPath(lca, startValue, path1);
        StringBuilder path2 = new StringBuilder();
        getPath(lca, destValue, path2);
        path1.reverse();
        return "U".repeat(path1.length()) + path2.toString();
    }

    private TreeNode findLCA(TreeNode node, int start, int dest) {
        if (node == null) {
            return null;
        }
        if (node.val == start || node.val == dest) {
            return node;
        }
        TreeNode left = findLCA(node.left, start, dest);
        TreeNode right = findLCA(node.right, start, dest);
        return left!= null && right!= null? node : left!= null? left : right;
    }

    private boolean getPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == target) {
            return true;
        }
        path.append('L');
        if (getPath(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        if (getPath(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinarySearchTreeDirections {
    public static void main(String[] args) {
        BinaryTreeDirections solution = new BinaryTreeDirections();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(4);
        System.out.println(solution.getDirections(root1, 3, 6)); // Output: "UURL"

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        System.out.println(solution.getDirections(root2, 2, 1)); // Output: "L"
    }
}
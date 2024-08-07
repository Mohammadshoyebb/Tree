/**
 * 979. Distribute Coins in Binary Tree
 * Solved
 * Medium
 * Topics: Binary Tree, Depth-First Search
 * 
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. 
 * There are n coins in total throughout the whole tree.
 * 
 * In one move, we may choose two adjacent nodes and move one coin from one node to another. 
 * A move may be from parent to child, or from child to parent.
 * 
 * Return the minimum number of moves required to make every node have exactly one coin.
 * 
 * Example 1:
 * 
 * Input: root = [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 * 
 * Example 2:
 * 
 * Input: root = [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].
 * Then, we move one coin from the root of the tree to the right child.
 * 
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= n <= 100
 * 0 <= Node.val <= n
 * The sum of all Node.val is n.
 * 
 * Solution:
 * We can solve this problem using a depth-first search (DFS) approach. The idea is to perform a post-order traversal of the tree.
 * For each node, we calculate the number of excess coins in the left and right subtrees, and then adjust the number of moves required accordingly.
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

 public class DistributeCoinsInBinaryTree {
    int moves; // To keep track of the total number of moves required

    public int distributeCoins(TreeNode root) {
        moves = 0; // Initialize the move counter
        dfs(root); // Start the DFS traversal
        return moves; // Return the total number of moves required
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0; // If the node is null, return 0
        }
        
        // Recursively compute the number of excess coins in the left and right subtrees
        int leftChildMove = dfs(root.left);
        int rightChildMove = dfs(root.right);

        // The number of moves is the absolute value of excess coins at this node.
        moves += Math.abs(leftChildMove) + Math.abs(rightChildMove);

        // Return the number of excess coins at this node.
        // root.val is the number of coins at this node,
        // leftChildMove is the net excess coins from the left subtree,
        // rightChildMove is the net excess coins from the right subtree,
        // -1 is because the node itself needs one coin.
        return root.val + leftChildMove + rightChildMove - 1;
    }

    public static void main(String[] args) {
        // Example 1: root = [3,0,0]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(0);
        DistributeCoinsInBinaryTree solution1 = new DistributeCoinsInBinaryTree();
        System.out.println(solution1.distributeCoins(root1)); // Output: 2

        // Example 2: root = [0,3,0]
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(0);
        DistributeCoinsInBinaryTree solution2 = new DistributeCoinsInBinaryTree();
        System.out.println(solution2.distributeCoins(root2)); // Output: 3
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

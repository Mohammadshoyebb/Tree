/**
 * 1530. Number of Good Leaf Nodes Pairs
 * Solved
 * Medium
 * 
 * You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.
 * 
 * Return the number of good leaf node pairs in the tree.
 * 
 * Example 1:
 * Input: root = [1,2,3,null,4], distance = 3
 * Output: 1
 * Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
 * 
 * Example 2:
 * Input: root = [1,2,3,4,5,6,7], distance = 3
 * Output: 2
 * Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
 * 
 * Example 3:
 * Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * Output: 1
 * Explanation: The only good pair is [2,5].
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 210].
 * 1 <= Node.val <= 100
 * 1 <= distance <= 10
 */

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

public class GoodLeafPairs {
    int res = 0;
    
    public int[] dfs(TreeNode root, int distance) {
        int leafDistance[] = new int[11];
        if (root == null) {
            return leafDistance;
        } else if (root.left == null && root.right == null) {
            leafDistance[1] = 1;
            return leafDistance;
        }
        int leftDist[] = dfs(root.left, distance);
        int rightDist[] = dfs(root.right, distance);

        for (int d1 = 1; d1 <= distance; d1++) {
            for (int d2 = 1; d2 <= distance; d2++) {
                if (d1 + d2 <= distance) {
                    res += leftDist[d1] * rightDist[d2];
                }
            }
        }
        for (int d = 1; d < 11; d++) {
            leafDistance[d] = leftDist[d - 1] + rightDist[d - 1];
        }
        return leafDistance;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }
    
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        GoodLeafPairs solution1 = new GoodLeafPairs();
        int result1 = solution1.countPairs(root1, 3);
        System.out.println("Example 1 - Number of good leaf node pairs: " + result1); // Output: 1

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        GoodLeafPairs solution2 = new GoodLeafPairs();
        int result2 = solution2.countPairs(root2, 3);
        System.out.println("Example 2 - Number of good leaf node pairs: " + result2); // Output: 2

        // Example 3
        TreeNode root3 = new TreeNode(7);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(4);
        root3.left.left = new TreeNode(6);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(3);
        root3.right.right.left = new TreeNode(2);

        GoodLeafPairs solution3 = new GoodLeafPairs();
        int result3 = solution3.countPairs(root3, 3);
        System.out.println("Example 3 - Number of good leaf node pairs: " + result3); // Output: 1
    }
}

/*
 * 2196. Create Binary Tree From Descriptions
Solved
Medium
Topics
Companies
Hint
You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

 

Example 1:


Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.
Example 2:


Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.
 

Constraints:

1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.
 */


import java.util.HashMap;
import java.util.HashSet;

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


public class BinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int[] nums : descriptions) {
            // Adding Parent Node
            if (!map.containsKey(nums[0])) {
                map.put(nums[0], new TreeNode(nums[0]));
            }
            // Adding Child Node
            if (!map.containsKey(nums[1])) {
                map.put(nums[1], new TreeNode(nums[1]));
            }
            if (nums[2] == 1) {
                map.get(nums[0]).left = map.get(nums[1]);
            } else {
                map.get(nums[0]).right = map.get(nums[1]);
            }
            set.add(nums[1]);
        }

        for (int[] nums : descriptions) {
            if (!set.contains(nums[0])) {
                return map.get(nums[0]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeFromDescriptions solution = new BinaryTreeFromDescriptions();
        
        int[][] descriptions1 = { {20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1} };
        int[][] descriptions2 = { {1, 2, 1}, {2, 3, 0}, {3, 4, 1} };

        TreeNode root1 = solution.createBinaryTree(descriptions1);
        TreeNode root2 = solution.createBinaryTree(descriptions2);
        
        // Outputs are not directly printable as tree structure; 
        // they need to be traversed and printed accordingly.
        printTree(root1); // Expected: [50,20,80,15,17,19]
        printTree(root2); // Expected: [1,2,null,null,3,4]
    }

    // Helper method to print tree (in-order traversal for simplicity)
    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}

/*
 * class Solution {
    public TreeNode createBinaryTree(final int[][] descriptions) {
        final TreeNode[] nodes = new TreeNode[100001];
        final boolean[] children = new boolean[100001];

        for(final int[] description : descriptions) {
            if(nodes[description[0]] == null)
                nodes[description[0]] = new TreeNode(description[0]);

            if(nodes[description[1]] == null)
                nodes[description[1]] = new TreeNode(description[1]);

            if(description[2] == 0)
                nodes[description[0]].right = nodes[description[1]];
            else
                nodes[description[0]].left = nodes[description[1]];

            children[description[1]] = true;
        }

        for(final int[] description : descriptions)
            if(!children[description[0]])
                return nodes[description[0]];

        return null;
    }
}
 */

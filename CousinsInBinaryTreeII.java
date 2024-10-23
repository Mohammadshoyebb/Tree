/**
 * 2641. Cousins in Binary Tree II
 * 
 * Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * 
 * Return the root of the modified tree.
 * 
 * Note that the depth of a node is the number of edges in the path from the root node to it.
 * 
 * Example 1:
 * Input: root = [5,4,9,1,10,null,7]
 * Output: [0,0,0,7,7,null,11]
 * Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
 * - Node with value 5 does not have any cousins so its sum is 0.
 * - Node with value 4 does not have any cousins so its sum is 0.
 * - Node with value 9 does not have any cousins so its sum is 0.
 * - Node with value 1 has a cousin with value 7 so its sum is 7.
 * - Node with value 10 has a cousin with value 7 so its sum is 7.
 * - Node with value 7 has cousins with values 1 and 10 so its sum is 11.
 * 
 * Example 2:
 * Input: root = [3,1,2]
 * Output: [0,0,0]
 * Explanation: 
 * - Node with value 3 does not have any cousins so its sum is 0.
 * - Node with value 1 does not have any cousins so its sum is 0.
 * - Node with value 2 does not have any cousins so its sum is 0.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^5].
 * 1 <= Node.val <= 10^4
 */

 import java.util.*;

 class CousinsInBinaryTreeII {
     
     // Function to replace node values with cousin sums
     public TreeNode replaceCousinSum(TreeNode root) {
         if (root == null) return null;
 
         int currentLevelSum = root.val;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         root.val *= -1;
 
         while (!queue.isEmpty()) {
             int size = queue.size();
             int newLevelSum = 0;
 
             for (int i = 0; i < size; i++) {
                 TreeNode currentNode = queue.poll();
                 int childSum = 0;
 
                 if (currentNode.left != null) childSum += currentNode.left.val;
                 if (currentNode.right != null) childSum += currentNode.right.val;
                 
                 newLevelSum += childSum;
                 
                 if (currentNode.left != null) currentNode.left.val = -childSum;
                 if (currentNode.right != null) currentNode.right.val = -childSum;
                 
                 currentNode.val += currentLevelSum;
                 
                 if (currentNode.left != null) queue.offer(currentNode.left);
                 if (currentNode.right != null) queue.offer(currentNode.right);
             }
             currentLevelSum = newLevelSum;
         }
         return root;
     }
 
     // Helper function to print tree as array
     public List<Integer> printTreeAsArray(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         if (root == null) return result;
 
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
 
         while (!queue.isEmpty()) {
             TreeNode currentNode = queue.poll();
 
             if (currentNode != null) {
                 result.add(currentNode.val);
                 queue.offer(currentNode.left);
                 queue.offer(currentNode.right);
             } else {
                 result.add(null);
             }
         }
 
         // Remove trailing nulls for cleaner output
         while (result.size() > 0 && result.get(result.size() - 1) == null) {
             result.remove(result.size() - 1);
         }
         return result;
     }
 
     public static void main(String[] args) {
         CousinsInBinaryTreeII obj = new CousinsInBinaryTreeII();
 
         // Example 1
         TreeNode root1 = new TreeNode(5);
         root1.left = new TreeNode(4);
         root1.right = new TreeNode(9);
         root1.left.left = new TreeNode(1);
         root1.left.right = new TreeNode(10);
         root1.right.right = new TreeNode(7);
 
         root1 = obj.replaceCousinSum(root1);
         List<Integer> result1 = obj.printTreeAsArray(root1);
         System.out.println("Modified Tree (Example 1): " + result1);
 
         // Example 2
         TreeNode root2 = new TreeNode(3);
         root2.left = new TreeNode(1);
         root2.right = new TreeNode(2);
 
         root2 = obj.replaceCousinSum(root2);
         List<Integer> result2 = obj.printTreeAsArray(root2);
         System.out.println("Modified Tree (Example 2): " + result2);
     }
 }
 
 // TreeNode class definition
 class TreeNode {
     int val;
     TreeNode left, right;
     TreeNode(int x) { val = x; }
 }
 
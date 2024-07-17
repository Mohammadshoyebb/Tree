/**
 * 1110. Delete Nodes And Return Forest
 * Medium
 * 
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * Example 2:
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 * 
 * Constraints:
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */

 import java.util.*;

 public class DeleteNodesAndReturnForest {
 
     public static class TreeNode {
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
 
     public TreeNode dfs(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> forest) {
         if (root == null) {
             return null;
         }
         root.left = dfs(root.left, to_delete, forest);
         root.right = dfs(root.right, to_delete, forest);
 
         if (to_delete.contains(root.val)) {
             if (root.left != null) {
                 forest.add(root.left);
             }
             if (root.right != null) {
                 forest.add(root.right);
             }
             return null; // delete this node
         }
         return root;
     }
 
     public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
         HashSet<Integer> set = new HashSet<>();
         for (int to_be_deleted : to_delete) {
             set.add(to_be_deleted);
         }
         List<TreeNode> forest = new ArrayList<>();
         root = dfs(root, set, forest);
         if (root != null) {
             forest.add(root);
         }
         return forest;
     }
 
     public static void main(String[] args) {
         // Create a sample tree
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(3);
         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);
         root.right.left = new TreeNode(6);
         root.right.right = new TreeNode(7);
 
         // Values to delete
         int[] to_delete = {3, 5};
 
         DeleteNodesAndReturnForest solution = new DeleteNodesAndReturnForest();
         List<TreeNode> forest = solution.delNodes(root, to_delete);
 
         // Print the forest as lists
         System.out.println("Forest after deletion:");
         for (TreeNode treeRoot : forest) {
             List<Integer> treeList = treeToList(treeRoot);
             System.out.println(treeList);
         }
     }
 
     // Convert tree to list in level order traversal
     public static List<Integer> treeToList(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         if (root == null) {
             return result;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
             TreeNode current = queue.poll();
             if (current != null) {
                 result.add(current.val);
                 queue.add(current.left);
                 queue.add(current.right);
             } else {
                 result.add(null);
             }
         }
         // Remove trailing nulls
         while (result.get(result.size() - 1) == null) {
             result.remove(result.size() - 1);
         }
         return result;
     }
 }
 

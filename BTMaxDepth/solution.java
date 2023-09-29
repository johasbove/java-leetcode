/**
 * Definition for a binary tree node.
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
class Solution {
    public static int walk(TreeNode curr, int length, int maxLength) {
      if (curr == null) {
        return length;
      }

      // pre
      length++;
      if(length > maxLength) {
        maxLength = length;
      }

      if (curr.left == null && curr.right == null) {
        return maxLength;
      }

      //recursion
      if (curr.left != null) {
        maxLength = walk(curr.left, length, maxLength);
      }
      if (curr.right != null) {
        maxLength = walk(curr.right, length, maxLength);
      }

      // post
      length--;
      return maxLength;
    }

  public int maxDepth(TreeNode root) {
    return walk(root, 0, 0);
  }
}
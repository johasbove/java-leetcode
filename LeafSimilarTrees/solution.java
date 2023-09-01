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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leavesValues1 = new ArrayList<Integer> ();
        ArrayList<Integer> leavesValues2 = new ArrayList<Integer> ();

        walkNodes(root1, leavesValues1);
        walkNodes(root2, leavesValues2);

        return leavesValues1.equals(leavesValues2);
    }

    public boolean walkNodes(TreeNode currentNode, ArrayList<Integer> leavesValues) {
        if (currentNode == null) {
            return false;
        }

        if(currentNode.left == null && currentNode.right == null) {
            leavesValues.add(currentNode.val);

            return true;
        }

        walkNodes(currentNode.left, leavesValues);
        walkNodes(currentNode.right, leavesValues);

        return false;
    }
}
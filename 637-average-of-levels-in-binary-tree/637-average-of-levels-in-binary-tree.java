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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            double sum = 0;
            for(int i=0;i<n;i++){
                TreeNode t = q.poll();
                
                sum+= t.val;
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
            list.add(sum/n);
        }
        
        return list;
    }
}
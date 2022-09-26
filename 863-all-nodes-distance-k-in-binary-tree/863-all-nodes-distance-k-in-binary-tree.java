class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1. Map child-parent to make an indirected graph (since we can't really access to the parent)
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildGraph(root, null, map);
        
        // 2. keep track of visited nodes in a set
        Set<TreeNode> set = new HashSet<>();
        
        // 3. use Queue for bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        set.add(target);
        
        // 4. as long as queue is not empty
        while (queue.size() > 0) {
            if (k == 0) {
                List<Integer> list = new ArrayList<>();
                for (TreeNode n : queue) {
                    list.add(n.val);
                }
                return list;
            }
            int size = queue.size();
            
            // 5. add parent, left child, right child to the queue and keep track of these nodes in the set
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !set.contains(node.left)) {
                    queue.add(node.left);   
                    set.add(node.left);
                }
                if (node.right != null && !set.contains(node.right)) {
                    queue.add(node.right);   
                    set.add(node.right);
                }
                if (map.get(node) != null && !set.contains(map.get(node))) {
                    queue.add(map.get(node));
                    set.add(map.get(node));
                }
            }
            k--;
        }
        
        return new ArrayList<>();
    }
    
    // make an indirected graph by mapping child-parent nodes
    public void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        
        map.put(node, parent);
        buildGraph(node.left, node, map);
        buildGraph(node.right, node, map);
    }
}
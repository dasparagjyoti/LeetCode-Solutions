​
**Approach 1:-**
//T.C = O(nlogk)
//S.C = O(k)
import java.util.*;
public class Solution {
public int[] topKFrequent(int[] nums, int k) {
Map<Integer, Integer> map = new HashMap<>();
for(int n: nums){
map.put(n, map.getOrDefault(n,0)+1);
}
PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
for(Map.Entry<Integer,Integer> entry: map.entrySet()){
maxHeap.add(entry);
}
List<Integer> res = new ArrayList<>();
while(res.size()<k){
Map.Entry<Integer, Integer> entry = maxHeap.poll();
res.add(entry.getKey());
}
return res.stream().mapToInt(i->i).toArray();
}
}
​
**Approach 2**
O(N) Time Complexity
https://leetcode.com/problems/top-k-frequent-elements/discuss/1667819/Java-O(n)-explained-with-pictures
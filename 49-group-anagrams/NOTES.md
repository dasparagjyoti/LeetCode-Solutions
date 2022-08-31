class Solution {
public List<List<String>> groupAnagrams(String[] strs) {
HashMap<String,List<String>> map=new HashMap<>();
for(int i=0;i<strs.length;i++){
String s1=strs[i];
char[] arr=s1.toCharArray();
Arrays.sort(arr);
String str=new String(arr);
if(map.containsKey(str)){
map.get(str).add(s1);
}else{
map.put(str,new ArrayList<>());
map.get(str).add(s1);
}
}
return new ArrayList<>(map.values());
}
}
Time Complexity: O(n * klog(k)) since we are sorting k characters n times in the loop.
public List<List<String>> groupAnagrams(String[] strs) {
if (strs == null || strs.length == 0) return new ArrayList<>();
Map<String, List<String>> map = new HashMap<>();
for (String s : strs) {
char[] ca = s.toCharArray();
Arrays.sort(ca);
String keyStr = String.valueOf(ca);
if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
map.get(keyStr).add(s);
}
return new ArrayList<>(map.values());
}
Instead of sorting, we can also build the key string in this way. Thanks @davidluoyes for pointing this out.
​
public List<List<String>> groupAnagrams(String[] strs) {
if (strs == null || strs.length == 0) return new ArrayList<>();
Map<String, List<String>> map = new HashMap<>();
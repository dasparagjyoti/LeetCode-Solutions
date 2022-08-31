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
for (String s : strs) {
char[] ca = new char[26];
for (char c : s.toCharArray()) ca[c - 'a']++;
String keyStr = String.valueOf(ca);
if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
map.get(keyStr).add(s);
}
return new ArrayList<>(map.values());
}
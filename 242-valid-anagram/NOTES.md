The idea is simple. It creates a size 26 int arrays as buckets for each letter in alphabet. It increments the bucket value with String s and decrement with string t. So if they are anagrams, all buckets should remain with initial value which is zero. So just checking that and return
​
class Solution {
public boolean isAnagram(String s, String t) {
char[] sCharArr = s.toCharArray();
char[] tCharArr = t.toCharArray();
​
Arrays.sort(sCharArr);
Arrays.sort(tCharArr);
return Arrays.equals(tCharArr, sCharArr);
}
}
​
O(N * log(N) + (M * log(M))), where N and M are the lengths of the two input strings.
​
Since we are sorting the strings, the time complexity will be O(N * log(N) + (M * log(M))).
​
Space Complexity
O(1).
​
**Approach 1-**
​
public class Solution {
public boolean isAnagram(String s, String t) {
int[] alphabet = new int[26];
for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
for (int i : alphabet) if (i != 0) return false;
return true;
}
}
​
TC O(n+m), SC O(26)
​
________________________________________________________________________________________________
**Approach 2:-USING HASHMAP**
class Solution {
public boolean isAnagram(String s, String t) {
HashMap<Character,Integer> smap=new HashMap<>();
int sl=s.length();
int tl=t.length();
if(sl!=tl){return false;}
for(int i=0;i<sl;i++){
smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
}
for(char c:smap.keySet()){
if(smap.get(c)!=0){return false;}
}
return true;
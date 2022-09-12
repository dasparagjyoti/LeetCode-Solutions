**Approach 1**
_____________________
class Solution {
public int firstUniqChar(String s) {
int[] count = new int[26];
int n = s.length();
// build char count bucket : <charIndex, count>
for (int i = 0; i < n; i++) {
int index = s.charAt(i) - 'a';
count[index]++;
}
// find the index
for (int i = 0; i < n; i++) {
int index = s.charAt(i) - 'a';
if (count[index] == 1) {
return i;
}
}
return -1;
}
}
​
________________________________________________________________________________________________
**Approach 2:-Using HashMap**
​
class Solution {
public int firstUniqChar(String s) {
HashMap<Character, Integer> count = new HashMap<Character, Integer>();
int n = s.length();
// build hash map : character and how often it appears
for (int i = 0; i < n; i++) {
char c = s.charAt(i);
count.put(c, count.getOrDefault(c, 0) + 1);
}
// find the index
for (int i = 0; i < n; i++) {
if (count.get(s.charAt(i)) == 1)
return i;
}
return -1;
}
}
​
Complexity Analysis
Time complexity : O(N) since we go through the string of length N two times.
Space complexity : O(1) because English alphabet contains 26 letters.
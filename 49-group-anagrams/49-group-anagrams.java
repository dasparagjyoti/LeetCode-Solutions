import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] characters = s.toCharArray();
            Arrays.sort(characters);//logn
            String sorted =  new String(characters);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            
            }
            map.get(sorted).add(s);
        }
        groupAnagrams.addAll(map.values());
         return groupAnagrams;
    }
   
}
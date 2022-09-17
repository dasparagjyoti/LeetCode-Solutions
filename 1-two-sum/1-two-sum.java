import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = hash.get(target-nums[i]); 
                return result;
            }
            hash.put(nums[i],i);
        }
        return result;
    }
}
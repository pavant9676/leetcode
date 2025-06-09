class Solution {
    public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> result =new HashSet<>();    
        for(int i: nums){
            if(result.contains(i)){
              return true;
             }
            else{
                result.add(i);
            }
            
        }
            
        return false;
    }
}
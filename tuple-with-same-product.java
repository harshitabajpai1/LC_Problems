class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> products =new HashMap<>();
        int answer=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prod=nums[i]*nums[j];
                answer+=products.getOrDefault(prod,0);
                products.put(prod, products.getOrDefault(prod, 0)+1);
            }
        }
        return answer*8;
        
    }
}

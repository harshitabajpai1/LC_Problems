class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        int low = 1;
        int high = max;
        int answer=0;
        while(low<=high){
            int mid= low + (high-low)/2;
            if(canEat(piles,h,mid)){
                 answer = mid;
                high = mid-1;
            }
            else low = mid + 1;

        }return answer;

    }
    private boolean canEat(int[] piles, int h, int speed){
        int total=0;
        for( int i=0;i<piles.length;i++){
            total+=piles[i]/speed;
            if(piles[i]%speed != 0) total++;
            if(total>h) return false;
        }
        return true;

    }
}

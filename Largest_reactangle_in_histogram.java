class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] smaller_on_right = new int[n];
        int[] smaller_on_left = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i=n-1;i>=0;i--) {
            while (!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                st.pop();
            }
            smaller_on_right[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        st.clear();

        for (int i=0;i<n;i++) {
            while (!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                st.pop();
            }
            smaller_on_left[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,(smaller_on_right[i]-smaller_on_left[i]-1)*heights[i]);
        }
        return max;
    }
        
}

        
    

class Solution {
    public int maxArea(int[] height) {

        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            
            int area = (height[left] > height[right]) ? height[right] * (right - left) : height[left] * (right - left);

            if(area > max) {
                max = area;
            }

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

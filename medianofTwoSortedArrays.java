class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i + nums1.length] = nums2[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] < nums[j]) {

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        if(nums.length%2 == 0) {
            return (double) (nums[nums.length / 2] + nums[(nums.length / 2) - 1])/2;
        } else {
            return (double) nums[(nums.length / 2)];
        }
    }
}

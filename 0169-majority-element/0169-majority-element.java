import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums); // Sorting the array
        int count = 1;
        int major = 0;
        int el = nums[0]; // Initialize with first element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > major) {
                    major = count;
                    el = nums[i - 1];
                }
                count = 1; // Reset count for new element
            }
        }

        // Final check for the last element sequence
        if (count > major) {
            el = nums[nums.length - 1];
        }

        return el;
    }
}

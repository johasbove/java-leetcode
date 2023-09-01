class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        // we'll take the set's upper limit into account when searching
        int high = nums.length - 1;
        int index = -1;

        index = searchSubset(low, high, nums, target);

        return index;
    }

    public int searchSubset(int low, int high, int[] nums, int target) {
        int mid = low + (high - low) / 2;

        // we still need to check nums[low] when high == low, so we can't add it as a condition here
        if (high < low) {
            return -1;
        }

        if (nums[mid] == target) {
            return mid;
        }

        if (target < nums[mid]) {
            // we'll take the set's upper limit into account when searching
            high = mid - 1;
        } else if (target > nums[mid]) {
            low = mid + 1;
        }

        return searchSubset(low, high, nums, target);
    }
}

// ***************************************************************************************

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        // we're starting outside of the array. We won't take high into account when searching
        int high = nums.length;
        int index = -1;

        index = searchSubset(low, high, nums, target);

        return index;
    }

    public int searchSubset(int low, int high, int[] nums, int target) {
        int mid = low + (high - low) / 2;

        // when high == low, nums[low] and nums[high] was already checked
        // nums[high] is always unintersting, doesn't give information
        if (high <= low) {
            return -1;
        }

        if (nums[mid] == target) {
            return mid;
        }

        if (target < nums[mid]) {
            high = mid;
        } else if (target > nums[mid]) {
            low = mid + 1;
        }

        return searchSubset(low, high, nums, target);
    }
}

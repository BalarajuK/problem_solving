import java.util.*;

/**
 * 2563. Count the Number of Fair Pairs
 * Leetcode : <a href="https://leetcode.com/problems/count-the-number-of-fair-pairs/description/?envType=daily-question&envId=2025-04-19">...</a>
 */
public class CountNumberOfFairPairs {

    public static void main(String[] args) {
        System.out.println(new CountNumberOfFairPairs().countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println(new CountNumberOfFairPairs().countFairPairs(new int[]{0, 0, 0, 0, 0, 0}, 0, 0));
    }

    public long countFairPairs(int[] nums, int lower, int upper) {


        Arrays.sort(nums);

        int count = 0;
        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            int l = lowerBound(nums, i + 1, j, lower - nums[i]);
            int r = upperBound(nums, i + 1, j, upper - nums[i]);
            count += r - l + 1;
        }
        return count;
    }

    private int lowerBound(int[] nums, int i, int j, int t) {
        int res = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (t > nums[mid]) {
                i = mid + 1;
            } else if (t == nums[mid]) {
                res = mid;
                j = mid - 1;
            } else {
                j = mid - 1;
            }
        }
        return res != -1 ? res : i;
    }

    private int upperBound(int[] nums, int i, int j, int t) {
        int res = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (t > nums[mid]) {
                i = mid + 1;
            } else if (t == nums[mid]) {
                res = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res != -1 ? res : j;
    }


}

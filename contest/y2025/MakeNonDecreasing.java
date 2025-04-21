package contest.y2025;

public class MakeNonDecreasing {
    public static void main(String[] args) {
        System.out.println(new MakeNonDecreasing().maximumPossibleSize(new int[]{4, 2, 5, 3, 5}));
        System.out.println(new MakeNonDecreasing().maximumPossibleSize(new int[]{1, 2, 3}));
        System.out.println(new MakeNonDecreasing().maximumPossibleSize(new int[]{4, 2, 3}));
    }

    public int maximumPossibleSize(int[] nums) {

        int current = nums[0];
        int size = 1;
        int i = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] < current) {
                i++;
            }
            if (i < nums.length) {
                size++;
                current = nums[i];
            }
            i++;
        }
        return size;
    }
}

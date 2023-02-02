import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> sumDiff = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sumDiff.containsKey(nums[i])) {
                result[0] = sumDiff.get(nums[i]);
                result[1] = i;
                return result;
            }
            int diff = target - nums[i];
            sumDiff.put(diff, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        Solution sol = new Solution();
        int[] result = sol.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
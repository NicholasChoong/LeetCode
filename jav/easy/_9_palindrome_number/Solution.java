package jav.easy._9_palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)
            return false;
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNum || x == revertedNum / 10;
    }

    public static void main(String[] args) {
        int x = 100;
        Solution sol = new Solution();
        boolean result = sol.isPalindrome(x);
        System.out.println(result);
    }
}
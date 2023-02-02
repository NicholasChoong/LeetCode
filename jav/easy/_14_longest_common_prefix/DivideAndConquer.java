package jav.easy._14_longest_common_prefix;

public class DivideAndConquer {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    // Recursive
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            System.out.println("Left: " + lcpLeft + ", Right: " + lcpRight);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    // Vertical Scanning
    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        var input = new String[] { "flower", "flow", "flight" };
        // var input = new String[] { "reflower", "flow", "flight" };
        // var input = new String[] { "aa", "ab" };
        // var input = new String[] { "a", "a" };
        // var input = new String[] { "flower", "flower", "flower" };
        DivideAndConquer sol = new DivideAndConquer();
        var result = sol.longestCommonPrefix(input);
        System.out.println(result);
    }
}

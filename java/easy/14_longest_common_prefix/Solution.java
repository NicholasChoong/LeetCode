import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String shortest = Arrays.asList(strs).stream()
                .sorted((e2, e1) -> e1.length() > e2.length() ? -1 : 1)
                .findFirst().get();
        for (int i = 0; i < shortest.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (shortest.charAt(i) != strs[j].charAt(i))
                    return shortest.substring(0, i);
            }
        }
        return shortest;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        int shotestSize = strs[0].length();
        int wordsSize = strs.length;
        for (int i = 0; i < shotestSize; i++) {
            if (strs[0].charAt(i) != strs[wordsSize - 1].charAt(i))
                return strs[0].substring(0, i);
        }
        return strs[0];
    }

    public String longestCommonPrefix_HorizontalScanning(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix_VerticalScanning(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                System.out.println("i: " + i + " j: " + j);
                System.out.println("LengthBool: " + (i == strs[j].length()));
                System.out.println("CharBool: " + (strs[j].charAt(i) != c));
                // i == strs[j].length() checks if index i is out of bound of word strs[j]
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        // var input = new String[] { "flower", "flow", "flight" };
        // var input = new String[] { "reflower", "flow", "flight" };
        // var input = new String[] { "aa", "ab" };
        // var input = new String[] { "a", "a" };
        var input = new String[] { "flower", "flower", "flower" };
        Solution sol = new Solution();
        var result = sol.longestCommonPrefix_VerticalScanning(input);
        System.out.println(result);
    }
}
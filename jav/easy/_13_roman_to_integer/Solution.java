package jav.easy._13_roman_to_integer;

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romansMap = new HashMap<>();
        romansMap.put('I', 1);
        romansMap.put('V', 5);
        romansMap.put('X', 10);
        romansMap.put('L', 50);
        romansMap.put('C', 100);
        romansMap.put('D', 500);
        romansMap.put('M', 1000);
        s = s.replace("IV", "IIII")
                .replace("IX", "VIIII")
                .replace("XL", "XXXX")
                .replace("XC", "LXXXX")
                .replace("CD", "CCCC")
                .replace("CM", "DCCCC");
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += romansMap.get(s.charAt(i));
        }
        return total;
    }

    public int romanToInt1(String s) {
        HashMap<Character, Integer> romansMap = new HashMap<>();
        romansMap.put('I', 1);
        romansMap.put('V', 5);
        romansMap.put('X', 10);
        romansMap.put('L', 50);
        romansMap.put('C', 100);
        romansMap.put('D', 500);
        romansMap.put('M', 1000);
        int total = 0;
        int size = s.length() - 1;
        for (int i = 0; i <= size; i++) {
            if (i < size && romansMap.get(s.charAt(i)) >= romansMap.get(s.charAt(i + 1)))
                total += romansMap.get(s.charAt(i));
            else if (i < size && romansMap.get(s.charAt(i)) < romansMap.get(s.charAt(i + 1)))
                total -= romansMap.get(s.charAt(i));
            else
                total += romansMap.get(s.charAt(i));
        }
        return total;
    }

    public int getRomanValue(char s) {
        switch (s) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    public int romanToInt2(String s) {
        int total = 0;
        int size = s.length() - 1;
        for (int i = 0; i < size; i++) {
            int current = this.getRomanValue(s.charAt(i));
            int prev = this.getRomanValue(s.charAt(i + 1));
            if (current >= prev)
                total += current;
            else
                total -= current;
        }
        return total + this.getRomanValue(s.charAt(size));
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        // String s = "III";
        Solution sol = new Solution();
        int result = sol.romanToInt2(s);
        System.out.println(result);
    }
}
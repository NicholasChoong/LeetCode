package jav.easy._20_valid_parentheses;

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> brackets = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Stack<Character> openBrackets = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (brackets.containsKey(bracket)) {
                if (openBrackets.isEmpty() || brackets.get(bracket) != openBrackets.pop())
                    return false;
            } else
                openBrackets.push(bracket);
        }
        return openBrackets.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> openBrackets = new Stack<>();
        for (char bracket : s.toCharArray()) {
            switch (bracket) {
                case '(':
                    openBrackets.push(')');
                    break;
                case '{':
                    openBrackets.push('}');
                    break;
                case '[':
                    openBrackets.push(']');
                    break;
                default:
                    if (openBrackets.isEmpty() || bracket != openBrackets.pop())
                        return false;
                    break;
            }
        }
        return openBrackets.isEmpty();
    }

    public static void main(String[] args) {
        // var input = "()[]{}";
        // var input = "(";
        // var input = ")";
        var input = "([)]";
        Solution sol = new Solution();
        var result = sol.isValid1(input);
        System.out.println(result);
    }
}

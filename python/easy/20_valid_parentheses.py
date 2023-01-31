class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {")": "(", "]": "[", "}": "{"}
        open_bracket_stack = []
        for bracket in s:
            if bracket in brackets:
                open_bracket = open_bracket_stack.pop() if open_bracket_stack else ""
                if brackets[bracket] != open_bracket:
                    return False
            else:
                open_bracket_stack.append(bracket)
        return not open_bracket_stack


if __name__ == "__main__":
    sol = Solution()
    strs = "()"
    # strs = "()[]{}"
    # strs = "(]"
    # strs = "([)]"
    # strs = "("
    # strs = ")"
    # strs = "]"
    # strs = "}"
    print(sol.isValid(strs))

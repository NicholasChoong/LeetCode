class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""
        common = ""
        prev_index = -1
        shortest = min(strs, key=len)
        # Verical Scanning
        for i, letter in enumerate(shortest):
            if i - 1 != prev_index:
                break
            if all(letter in word[i] for word in strs):
                common += letter
                prev_index = i
        return common

    def longestCommonPrefixSorted(self, strs: list[str]) -> str:
        if not strs:
            return ""
        sorted_words = strs
        sorted_words.sort()
        for i in range(len(sorted_words[0])):
            if sorted_words[0][i] != sorted_words[-1][i]:
                return sorted_words[0][:i]
        return sorted_words[0]

    def longestCommonPrefixMinMax(self, strs: list[str]) -> str:
        if not strs:
            return ""
        smallest_word = min(strs)
        largest_word = max(strs)
        for i in range(len(smallest_word)):
            if smallest_word[i] != largest_word[i]:
                return smallest_word[:i]
        return smallest_word

    def longestCommonPrefix2(self, strs: list[str]) -> str:
        if not strs:
            return ""
        shortest = min(strs, key=len)
        for i in range(len(shortest)):
            if any(shortest[i] != word[i] for word in strs):
                return shortest[:i]
        return shortest

    def longestCommonPrefix2_same_as_above(self, strs: list[str]) -> str:
        if not strs:
            return ""
        shortest = min(strs, key=len)
        return next(
            (
                shortest[:i]
                for i in range(len(shortest))
                if any(shortest[i] != word[i] for word in strs)
            ),
            shortest,
        )


if __name__ == "__main__":
    sol = Solution()
    strs = ["flower", "flow", "flight"]
    # strs = ["cir", "car"]
    # strs = ["reflower", "flow", "flight"]
    # strs = ["aa", "ab"]
    # strs = ["a"]
    # strs = ["ab", "a"]
    # strs = ["flower", "flower", "flower", "flower"]
    print(sol.longestCommonPrefixMinMax(strs))

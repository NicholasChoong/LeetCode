class Solution:
    def romanToInt(self, s: str) -> int:
        roman_dict = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }
        sum = 0
        size = len(s) - 1
        for i, letter in enumerate(s):
            if i != 0 and (
                ((letter == "V" or letter == "X") and s[i - 1] == "I")
                or ((letter == "L" or letter == "C") and s[i - 1] == "X")
                or ((letter == "D" or letter == "M") and s[i - 1] == "C")
            ):
                continue
            if i < size:
                if letter == "I" and (s[i + 1] == "V" or s[i + 1] == "X"):
                    sum += roman_dict[s[i + 1]] - roman_dict[letter]
                elif letter == "X" and (s[i + 1] == "L" or s[i + 1] == "C"):
                    sum += roman_dict[s[i + 1]] - roman_dict[letter]
                elif letter == "C" and (s[i + 1] == "D" or s[i + 1] == "M"):
                    sum += roman_dict[s[i + 1]] - roman_dict[letter]
                else:
                    sum += roman_dict[letter]
            else:
                sum += roman_dict[letter]
        return sum

    def romanToInt_same_as_above(self, s: str) -> int:
        roman_dict = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }
        sum = 0
        size = len(s) - 1
        for i, letter in enumerate(s):
            if i != 0 and (
                letter in ["V", "X"]
                and s[i - 1] == "I"
                or letter in ["L", "C"]
                and s[i - 1] == "X"
                or letter in ["D", "M"]
                and s[i - 1] == "C"
            ):
                continue
            if i < size:
                if letter == "I" and s[i + 1] in ["V", "X"]:
                    sum += roman_dict[s[i + 1]] - roman_dict[letter]
                elif letter == "X" and s[i + 1] in ["L", "C"]:
                    sum += roman_dict[s[i + 1]] - roman_dict[letter]
                elif letter == "C" and s[i + 1] in ["D", "M"]:
                    sum += roman_dict[s[i + 1]] - roman_dict[letter]
                else:
                    sum += roman_dict[letter]
            else:
                sum += roman_dict[letter]
        return sum

    def romanToIntLeetCode(self, s: str) -> int:
        values = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
            "IV": 4,
            "IX": 9,
            "XL": 40,
            "XC": 90,
            "CD": 400,
            "CM": 900,
        }
        total = 0
        i = 0
        size = len(s)
        while i < size:
            # This is the subtractive case.
            if i < size - 1 and s[i : i + 2] in values:
                total += values[s[i : i + 2]]
                i += 2
            else:
                total += values[s[i]]
                i += 1
        return total

    def romanToInt1(self, s: str) -> int:
        roman_dict = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }
        s = (
            s.replace("IV", "IIII")
            .replace("IX", "VIIII")
            .replace("XL", "XXXX")
            .replace("XC", "LXXXX")
            .replace("CD", "CCCC")
            .replace("CM", "DCCCC")
        )
        return sum(map(lambda x: roman_dict[x], s))

    def romanToInt2(self, s: str) -> int:
        roman_dict = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }
        total = 0
        size = len(s) - 1
        for i in range(size):
            current = roman_dict[s[i]]
            prev = roman_dict[s[i + 1]]
            if current >= prev:
                total += current
            else:
                total -= current
        return total + roman_dict[s[-1]]


if __name__ == "__main__":
    sol = Solution()
    s = "MCMXCIV"
    print(sol.romanToInt2(s))

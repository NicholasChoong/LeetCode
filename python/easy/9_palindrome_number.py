class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        num = str(x)
        lenght = len(num)
        for i in range(lenght // 2):
            if num[i] != num[lenght - 1 - i]:
                return False
        return True

    def isPalindrome_same_as_above(self, x: int) -> bool:
        if x < 0:
            return False
        num = str(x)
        lenght = len(num)
        return all(num[i] == num[lenght - 1 - i] for i in range(lenght // 2))

    def isPalindrome2(self, x: int) -> bool:
        if x < 0:
            return False
        num = str(x)
        return num == num[::-1]

    def isPalindromeLeet(self, x: int) -> bool:
        if x < 0 or x % 10 == 0 and x != 0:
            return False
        revertedNumber = 0
        while x > revertedNumber:
            revertedNumber = revertedNumber * 10 + x % 10
            x //= 10
            #      even                    odd
        return x in [revertedNumber, revertedNumber // 10]


if __name__ == "__main__":
    sol = Solution()
    x = 12121
    print(sol.isPalindrome2(x))

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        sum: dict[int, int] = {}
        for i, num in enumerate(nums):
            if num in sum:
                return [sum[num], i]
            diff = target - num
            sum[diff] = i
        return []


if __name__ == "__main__":
    twoSum = Solution()
    nums = [3, 3]
    target = 6
    print(twoSum.twoSum(nums, target))

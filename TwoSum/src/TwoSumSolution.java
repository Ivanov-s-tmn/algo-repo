/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

______________________________________________________________________________________________________________________

Дан массив целых чисел и целое целевое значение, нужно вернуть индексы двух элементов массива, которые в сумме дают это целевое значение

Можно предположить, что каждое входное значение может иметь только одно решение и нельзя использовать один и тот же элемент для суммы дважды

Можно возвращать индексы в любом порядке
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {

    //Простое решение через вложенные циклы, сложность O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int firstIndex;
        int secondIndex;
        for (int i = 0; i < nums.length; i++) {
            int guess = target - nums[i];
            firstIndex = i;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[j] == guess) {
                    secondIndex = j;
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }
        return new int[]{};
    }

    //решение через хешмапу, скорость алгоритма O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int guess = target - nums[i];
            if (numToIndex.containsKey(guess)) {
                return new int[]{i, numToIndex.get(guess)};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println();
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7}, 3)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6)));

    }
}



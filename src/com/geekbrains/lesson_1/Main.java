package com.geekbrains.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] integers = {1, 3, 4, 5, 6, 7};

        swapElement(integers, 1, 3);
        List<Integer> integerslist = listFromMassive(integers);
        for (Integer num : integerslist) {
            System.out.println(num);
        }

    }

    static <T> void swapElement(T[] nums, int a, int b) {
        T obj = nums[a];
        nums[a] = nums[b];
        nums[b] = obj;
    }

    static <T> List<T> listFromMassive(T[] nums) {
        List<T> listNums = new ArrayList<>(Arrays.asList(nums));
        return listNums;
    }

}

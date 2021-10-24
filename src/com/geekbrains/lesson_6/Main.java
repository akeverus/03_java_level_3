package com.geekbrains.lesson_6;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] oldElements = new int[]{1,2,3,4,5,6,7,8,9,10};
        for (int i : returnElementsAfterFour(oldElements)) {
            System.out.println(i);
        }
    }

    public static int[] returnElementsAfterFour(int[] elements) {
        if (IntStream.of(elements).anyMatch(x -> x == 4)) {

            int size = elements.length;
            int indexFour = 0;

            for (int i = size - 1; i >= 0 ; i--) {
                if(elements[i] == 4) {
                    indexFour = i;
                    break;
                }
            }

            int newLength = size - (indexFour + 1);
            int[] newElements = new int[newLength];
            System.arraycopy(elements, indexFour + 1, newElements, 0, newLength);
            return newElements;
        } else {
            throw new RuntimeException();
        }
    }

    public static boolean checkArrayOneFour(int[] elements) {
        boolean containsWrong = IntStream.of(elements).filter(i -> i != 1).filter(i -> i != 4).count() != 0;
        boolean containsFirst = IntStream.of(elements).filter(i -> i == 1).count() != 0;
        boolean containsSecond = IntStream.of(elements).filter(i -> i == 4).count() != 0;
        return !containsWrong && containsFirst && containsSecond;
    }
}



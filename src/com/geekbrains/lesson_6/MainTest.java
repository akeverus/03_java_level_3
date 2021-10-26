package com.geekbrains.lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainTest {

    public static Stream<Arguments> returnElementsAfterFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] {1, 7}));
        out.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 4}, new int[] {}));
        out.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 1, 7 }, new int[] {2, 3, 1, 7}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("returnElementsAfterFour")
    public void testReturnElementsAfterFour(int[] array, int[] result) {
        Assertions.assertArrayEquals(Main.returnElementsAfterFour(array), result);
    }

    public static Stream<Arguments> checkArrayOneFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[] {1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[] {4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[] {1, 4, 4, 1, 1, 4, 3}, false));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("checkArrayOneFour")
    public void testCheckArrayOneFour(int[] array, boolean isCheck) {
        Assertions.assertEquals(Main.checkArrayOneFour(array), isCheck);
    }

}
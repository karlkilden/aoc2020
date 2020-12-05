package com.kildeen.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1 {

    private int[] expenses;

    public Day1(int... expenses) {
        this.expenses = expenses;
    }

    public int get() {

        return IntStream
                .range(0, expenses.length)
                .mapToObj(i -> sumsTo2020(i)).filter(i -> i.isPresent())
                .findFirst().get().getAsInt();
    }

    private OptionalInt sumsTo2020(int index) {
        return IntStream
                .range(0, expenses.length)
                .filter(i -> i != index)
                .filter(i -> expenses[index] + expenses[i] == 2020)
                .map(i -> expenses[index] * expenses[i])
                .findAny();
    }

    public static int[] parseInput(String input) {
        return Arrays.asList(input.split("\n")).stream().mapToInt(Integer::parseInt).toArray();
    }

}

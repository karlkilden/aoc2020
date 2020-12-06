package com.kildeen.aoc;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
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

    private OptionalInt sumsTo20202(int index, int secondIndex) {
        return IntStream
                .range(0, expenses.length)
                .filter(i -> i != index)
                .filter(i -> expenses[index] + expenses[secondIndex] + expenses[i]== 2020)
                .map(i -> expenses[index] * expenses[i])
                .findAny();
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


    public int getPart2Random() {
        while (true) {
            int index1 = ThreadLocalRandom.current().nextInt(0, expenses.length-1);
            int index2 = ThreadLocalRandom.current().nextInt(0, expenses.length-1);
            int index3 = ThreadLocalRandom.current().nextInt(0, expenses.length-1);

            if(index1 != index2 && index1 != index3 && index2 != index3) {
                int val1 = expenses[index1];
                int val2 = expenses[index2];
                int val3 = expenses[index3];
                if (val1+val2+val3 == 2020) {
                    return val1*val2*val3;
                }
            }
        }
    }

    //oops not gonna work
    public int getPart2() {
        return Arrays.stream(IntStream
                .range(0, expenses.length)
                .mapToObj(i -> threeDistinctExpenses(i)).filter(array -> array[0]+array[1]+array[2] == 2020).findFirst().get()).reduce(1, (a, b) -> a * b);

    }


    private int[] threeDistinctExpenses(int index) {
        return IntStream
                .range(0, expenses.length)
                .filter(i -> i > index)
                .mapToObj(i -> new int[]{expenses[index], expenses[i], expenses[findThirdDistinctExpense(index,i)]}).findFirst().get();
    }

    private int findThirdDistinctExpense(int index, int otherIndex) {
        return IntStream
                .range(0, expenses.length)
                .filter(i -> i > otherIndex).findFirst().getAsInt();
    }
}

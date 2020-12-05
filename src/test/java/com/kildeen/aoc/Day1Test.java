package com.kildeen.aoc;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {


    @Test
    void multiplies_2019_and_1() {
        assertThat(new Day1(2019, 1).get()).isEqualTo(2019);
    }

    @Test
    void multiplies_1010_twice() {
        assertThat(new Day1(1010, 1010).get()).isEqualTo(1010*1010);
    }

    @Test
    void multiplies_1010_twice_with_falses_sent_in() {
        assertThat(new Day1(1010, 4, 111, 222, 0, -1, 444, 110000, 1010).get()).isEqualTo(1010*1010);
    }

    @Test
    void parse_input() {
        assertThat(new Day1().parseInput("1886\n" +
                "1824\n" +
                "1902\n")).containsExactly(1886,1824,1902);
    }

    @Test
    void and_the_answer_is() {
      System.out.println(new Day1(Day1.parseInput(Input.INPUT_DAY_1)).get());
    }
}
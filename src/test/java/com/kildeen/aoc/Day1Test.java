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
    void multiplies_1010_twice__with_other_values_sent_in() {
        assertThat(new Day1(1010, 4, 111, 222, 0, -1, 444, 110000, 1010).get()).isEqualTo(1010*1010);
    }

    @Test
    void parse_input() {
        assertThat(new Day1().parseInput("1886\n" +
                "1824\n" +
                "1902\n")).containsExactly(1886,1824,1902);
    }

    @Test
    void part2_505_505_1010_should_be_257575250() {
        assertThat(new Day1(505, 505, 1010).getPart2()).isEqualTo(505 *505* 1010);
    }

    @Test
    void part2_979_366_675_should_be_241861950() {
        assertThat(new Day1(979, 366, 675).getPart2()).isEqualTo(979 *366* 675);
    }

    @Test
    void part2_979_366_675_should_be_241861950_with_other_values_sent_in() {
        assertThat(new Day1(33,49,979, 9999, 366, 675,1,2,3,4,999,440,33401).getPart2()).isEqualTo(979 *366* 675);
    }

    @Test
    void part2_979_366_675_should_be_241861950_with_other_values_sent_in_using_random() {
        assertThat(new Day1(33,49,979, 9999, 366, 675,1,2,3,4,999,440,33401).getPart2Random()).isEqualTo(979 *366* 675);
    }

    @Test
    void and_the_answer_is() {
      System.out.println(new Day1(Day1.parseInput(Input.INPUT_DAY_1)).get());
    }

    @Test
    void and_the_answer_to_part_2_is_using_random() {
        System.out.println(new Day1(Day1.parseInput(Input.INPUT_DAY_1)).getPart2Random());
    }

    @Test
    void and_the_answer_to_part_2() {
        System.out.println(new Day1(Day1.parseInput(Input.INPUT_DAY_1)).getPart2());
    }
}
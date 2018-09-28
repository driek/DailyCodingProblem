package eu.suteki.daily_coding_problem;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */
public class Task20180928 implements Task {

    /**
     *  Unfortunately using division.
     */
    @Override
    public void handle() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        final int totalProduct = numbers.stream().reduce(1, (a, b) -> a*b);
        numbers.stream().map(i -> totalProduct / i).forEach(System.out::println);
    }
}

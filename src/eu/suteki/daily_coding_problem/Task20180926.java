package eu.suteki.daily_coding_problem;

import java.util.TreeSet;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
public class Task20180926 implements Task {
    @Override
    public void handle() {
        Integer[] list = {10, 15, 3, 7};
        for (int i = 0; i <= 20; i++) {
            doCheckAndPrintResult(list, i);
        }
    }

    /**
     * Check whether two numbers in the list have a sum equal to the parameter given.
     * I.e. numbers: [10, 15, 3, 7], sum: 17 => true, but sum: 16 =. 16 as there are no two numbers with a sum of 16.
     * @param numbers
     * @param sum
     */
    public boolean hasTwoNumbersWithSumOf(Integer[] numbers, Integer sum) {
        // Use an TreeSet so the number will be kept sorted for the lookup.
        TreeSet<Integer> pairs = new TreeSet<>();
        for (Integer i : numbers) {
            if (pairs.contains(i)) {
                return true;
            }
            // Instead of summing up when going through the list,
            // keep track of which other number will result in the checked sum.
            pairs.add(sum - i);
        }
        return false;
    }

    /**
     * Run the solution of the Task and print its result.
     * @param numbers
     * @param sum
     */
    public void doCheckAndPrintResult(Integer[] numbers, Integer sum) {
        System.out.println("The list contains "
                + (hasTwoNumbersWithSumOf(numbers, sum) ? "" : "not ")
                + "two numbers with the sum of "
                + sum
        );
    }
}

package com.pedro.stringcalculator;

/**
 * Main class of this application. StringCalculator is an application created to analyze one string, extract the
 * numeric values and return an integer that represents the sum of the numeric values. Some interesting conditions
 * are described in the application documentation.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class StringCalculator {

    /*
     * Constants
     */

    private final String ONE_DIGIT_OR_MORE_REG_EX = "\\d+";

    /*
     * Public methods
     */

    /**
     * Parse an string and sum all the numeric values removing the non numeric characters.
     *
     * @param numbers to analyze and sum.
     * @return the sum value with some restrictions described in the project documentation.
     */
    public int add(final String numbers) {
        int result = 0;
        if (!numbers.isEmpty()) {
            if (onlyContainsOneNumber(numbers)) {
                result = Integer.parseInt(numbers);
            }
        }
        return result;
    }

    private boolean onlyContainsOneNumber(final String numbers) {
        return numbers.matches(ONE_DIGIT_OR_MORE_REG_EX);
    }

    /*
     * Auxiliary methods
     */

}

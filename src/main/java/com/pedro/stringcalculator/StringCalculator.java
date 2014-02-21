package com.pedro.stringcalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        List<Integer> numberList = extractNumberList(numbers);
        return sumNumbers(numberList);
    }



    /*
     * Auxiliary methods
     */

    private List<Integer> extractNumberList(String numbers) {
        List<Integer> result = new LinkedList<Integer>();
        if (!numbers.isEmpty()) {
            result = getNumbersUsingRegEx(numbers);
        }
        return result;
    }

    private List<Integer> getNumbersUsingRegEx(String string) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        Pattern p = Pattern.compile(ONE_DIGIT_OR_MORE_REG_EX);
        Matcher m = p.matcher(string);
        while (m.find()) {
            int number = Integer.parseInt(m.group());
            numbers.add(number);
        }
        return numbers;
    }

    private int sumNumbers(List<Integer> numberList) {
        int sum = 0;
        for (Integer num : numberList) {
            sum += num;
        }
        return sum;
    }

}

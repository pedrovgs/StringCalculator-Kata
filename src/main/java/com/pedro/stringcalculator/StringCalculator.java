package com.pedro.stringcalculator;

import com.pedro.stringcalculator.exception.NegativeNumbersNotSupportedException;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class of this application. StringCalculator is an application created to analyze one string, extract the
 * numeric values and return an integer that represents the sum of the numeric values. Some interesting conditions
 * are described in the application documentation.
 * <p/>
 * This are the use cases implemented in this application:
 * <p/>
 * If the application doesn't receive any number should return zero.
 * If the application receive only one number should return the same number. Same behaviour expected with numbers of different digits.
 * If the application receive some numbers separated with one character will return the sum of all of them.
 * The application supports new line character separators.
 * The application supports more than one separator separator.
 * The application supports more than one separator at the same time.
 * <p/>
 * If the application receipts one or some negative numbers will it will throw a NegativeNumbersNotSupportedException.
 * If the application receipts on number grater than 1000 this number will have to be discarded in the sum.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class StringCalculator {

    /*
     * Constants
     */

    private static final String ONE_DIGIT_OR_MORE_REG_EX = "-?\\d+";
    private static final Pattern numberPattern = Pattern.compile(ONE_DIGIT_OR_MORE_REG_EX);
    private static final Integer EXCLUDED_NUMBER = 1000;

    /*
     * Public methods
     */

    /**
     * Parse an string and sum all the numeric values removing the non numeric characters.
     *
     * @param numbers to analyze and sum.
     * @return the sum value with some restrictions described in the project documentation.
     */
    public int add(final String numbers) throws NegativeNumbersNotSupportedException {
        List<Integer> numberList = extractNumberList(numbers);
        checkIfThereAreNegativeNumbers(numberList);
        return sumNumbers(numberList);
    }


    /*
     * Auxiliary methods
     */

    private void checkIfThereAreNegativeNumbers(List<Integer> numberList) throws NegativeNumbersNotSupportedException {
        List<Integer> negativeNumbers = new LinkedList<Integer>();
        for (Integer num : numberList) {
            if (num < 0) {
                negativeNumbers.add(num);
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new NegativeNumbersNotSupportedException(negativeNumbers);
        }
    }

    private List<Integer> extractNumberList(String numbers) {
        List<Integer> result = new LinkedList<Integer>();
        if (!numbers.isEmpty()) {
            result = getNumbersUsingRegEx(numbers);
        }
        return result;
    }

    private List<Integer> getNumbersUsingRegEx(String string) {
        Matcher matcher = numberPattern.matcher(string);
        return extractNumbersFromMatcher(matcher);
    }

    private LinkedList<Integer> extractNumbersFromMatcher(Matcher matcher) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if (shouldAddNumber(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private boolean shouldAddNumber(int number) {
        return number < EXCLUDED_NUMBER;
    }


    private int sumNumbers(List<Integer> numberList) {
        int sum = 0;
        for (Integer num : numberList) {
            sum += num;
        }
        return sum;
    }

}

package com.pedro.stringcalculator;

import com.pedro.stringcalculator.exception.NegativeNumbersNotSupportedException;
import com.pedro.stringcalculator.exception.ValidatorException;

import java.util.LinkedList;
import java.util.List;


/**
 * Validator created to detect negative numbers. If this validator detects a negative number will throw a
 * NegativeNumbersNotSupportedException.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class NegativeNumberValidator implements ListNumberValidator {

    /*
     * Validator methods
     */

    @Override
    public void validate(final List<Integer> numbers) throws ValidatorException {
        List<Integer> negativeNumbers = getNegativeNumbers(numbers);
        if (negativeNumbers.size() > 0) {
            throw new NegativeNumbersNotSupportedException(negativeNumbers);
        }
    }

    private List<Integer> getNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new LinkedList<Integer>();
        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            }
        }
        return negativeNumbers;
    }

    /*
     * Auxiliary methods
     */

}

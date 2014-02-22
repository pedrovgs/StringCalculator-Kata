package com.pedro.stringcalculator.exception;

import java.util.List;

/**
 * Exception created to be thrown when the application is used with negative numbers.
 * <p/>
 * This exception contains information about the negative numbers that throws the exception.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NegativeNumbersNotSupportedException extends ValidatorException {

    /*
     * Constants
     */

    private static final String EXCEPTION_NAME = "NegativeNumbersNotSupportedException";

    /*
     * Attributes
     */

    private List<Integer> negativeNumbers;

    /*
     * Constructor
     */

    public NegativeNumbersNotSupportedException(List<Integer> negativeNumbers) {
        this.negativeNumbers = negativeNumbers;
    }

    /*
     * Public methods
     */

    public static String getExceptionName() {
        return EXCEPTION_NAME;
    }

    /*
     * Override methods
     */

    @Override
    public String getMessage() {
        return EXCEPTION_NAME + negativeNumbers.toString();
    }
}

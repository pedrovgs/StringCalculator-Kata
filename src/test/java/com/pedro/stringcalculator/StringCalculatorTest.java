package com.pedro.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test created to check the correct behaviour of the StringCalculator application.
 * <p/>
 * The string calculator class should get a string with some numbers inside and calculate the sum of different values.
 * <p/>
 * This test suit contains some integration tests that describes the application behaviour.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class StringCalculatorTest {

    /*
     * Constants
     */

    private static final String EMPTY_SET_OF_NUMBERS = "";

    /*
     * Test data
     */

    private StringCalculator stringCalculator;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    /*
     * Test methods
     */

    @Test
    public void shouldReturnZeroIfTheArgumentIsEmpty() {
        int result = stringCalculator.add(EMPTY_SET_OF_NUMBERS);
        assertEquals(0, result);
    }

}

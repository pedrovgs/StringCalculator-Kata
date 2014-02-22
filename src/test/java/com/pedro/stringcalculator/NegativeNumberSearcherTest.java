package com.pedro.stringcalculator;

import com.pedro.stringcalculator.exception.NegativeNumbersNotSupportedException;
import com.pedro.stringcalculator.exception.ValidatorException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Tess created to check the correctness of NegativeNumberSearcher.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NegativeNumberSearcherTest {

    /*
     * Constants
     */
    private static final int POSITIVE_VALUE = 100;
    private static final int ZERO = 0;
    private static final int NEGATIVE_VALUE = -11;

    /*
     * Test data
     */

    private NegativeNumberSearcher validator;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() {
        initializeRule();
    }

    /*
     * Test methods
     */

    @Test
    public void shouldValidatePositiveNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(POSITIVE_VALUE);
        validator.validate(positiveNumbers);
    }

    @Test
    public void shouldValidateZero() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(ZERO);
        validator.validate(positiveNumbers);
    }


    @Test(expected = NegativeNumbersNotSupportedException.class)
    public void shouldNotValidateNegativeNumbers() throws ValidatorException {
        List<Integer> positiveNumbers = generateIntegerList(NEGATIVE_VALUE);
        validator.validate(positiveNumbers);
    }

    /*
     * Auxiliary methods
     */

    private void initializeRule() {
        validator = new NegativeNumberSearcher();
    }

    private List<Integer> generateIntegerList(int num) {
        List<Integer> nums = new LinkedList<Integer>();
        nums.add(num);
        return nums;
    }
}

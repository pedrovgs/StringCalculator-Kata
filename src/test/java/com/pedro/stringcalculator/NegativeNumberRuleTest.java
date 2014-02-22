package com.pedro.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tess created to check the correctness of LessThanValidationRule.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NegativeNumberRuleTest {

    /*
     * Constants
     */
    private static final int POSITIVE_VALUE = 100;
    private static final int ZERO = 0;
    private static final int NEGATIVE_VALUE = -11;

    /*
     * Test data
     */

    private NegativeNumberValidationRule rule;

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
    public void shouldValidatePositiveNumbers() {
        assertTrue(rule.isValid(POSITIVE_VALUE));
    }

    @Test
    public void shouldValidateZero() {
        assertTrue(rule.isValid(ZERO));
    }

    @Test
    public void shouldNotValidateNegativeNumbers() {
        assertFalse(rule.isValid(NEGATIVE_VALUE));
    }

    /*
     * Auxiliary methods
     */

    private void initializeRule() {
        rule = new NegativeNumberValidationRule();
    }
}

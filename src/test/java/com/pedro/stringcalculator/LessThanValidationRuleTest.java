package com.pedro.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tess created to check the correctness of LessThanValidationRule
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class LessThanValidationRuleTest {

    /*
     * Constants
     */
    private static final int TOP_VALUE = 100;
    private static final int LESS_THAN_TOP_VALUE = 11;

    /*
     * Test data
     */

    private LessThanValidationRule rule;

    /*
     * Before and after methods
     */

    @Before
    public void setUp(){
        initializeRule();
    }

    /*
     * Test methods
     */

    @Test
    public void shouldValidateANumberLessThanTopValue(){
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    @Test
    public void shouldNotValidateANumberEqualsToTheTopValue(){
        assertFalse(rule.isValid(TOP_VALUE));
    }

    @Test
    public void shouldNotValidateANumberGratherThanTopValue(){
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    /*
     * Auxiliary methods
     */

    private void initializeRule() {
        rule = new LessThanValidationRule(TOP_VALUE);
    }
}

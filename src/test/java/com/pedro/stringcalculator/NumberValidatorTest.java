package com.pedro.stringcalculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * @author pedro.
 */
public class NumberValidatorTest {

    /*
     * Test data
     */

    private NumberValidator numberValidator;

    /*
     * Mocks
     */

    @Mock
    private NumberValidator.ValidationRule mockedValidationRule1;
    @Mock
    private NumberValidator.ValidationRule mockedValidationRule2;

    /*
     * Before and after methods
     */

    @Before
    public void setUp() throws Exception {
        initializeMocks();
        initializeNumberValidator();
    }

    /*
     * Test methods
     */

    @Test
    public void shouldNotRemoveAnyNumber() {
        when(mockedValidationRule1.isValid(anyInt())).thenReturn(true);
        when(mockedValidationRule2.isValid(anyInt())).thenReturn(true);

        List<Integer> numbers = generateNumbersList(1, 2, 3, 4);

        List<Integer> result = numberValidator.removeNotValidNumbers(numbers);

        assertEquals(numbers, result);
    }

    @Test
    public void shouldRemoveTwoAndFour() {
        when(mockedValidationRule1.isValid(1)).thenReturn(true);
        when(mockedValidationRule2.isValid(3)).thenReturn(true);
        when(mockedValidationRule1.isValid(2)).thenReturn(false);
        when(mockedValidationRule2.isValid(4)).thenReturn(false);


        List<Integer> numbers = generateNumbersList(1, 2, 3, 4);

        List<Integer> result = numberValidator.removeNotValidNumbers(numbers);

        numbers.remove(2);
        numbers.remove(4);

        assertEquals(numbers, result);
    }


    /*
     * Auxiliary methods
     */

    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    private void initializeNumberValidator() {
        Collection<NumberValidator.ValidationRule> rules = generateValidationRuleCollection();
        numberValidator = new NumberValidator(rules);
    }

    private Collection<NumberValidator.ValidationRule> generateValidationRuleCollection() {
        Collection<NumberValidator.ValidationRule> rules = new LinkedList<NumberValidator.ValidationRule>();
        rules.add(mockedValidationRule1);
        rules.add(mockedValidationRule2);
        return rules;
    }

    private List<Integer> generateNumbersList(Integer... numbers) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : numbers) {
            result.add(num);
        }
        return result;
    }

}

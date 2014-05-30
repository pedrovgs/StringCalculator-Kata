/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * Test created to check the correctness of NumberValidator
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NumberValidatorTest {

    private NumberValidator numberValidator;

    @Mock
    private NumberValidator.ValidationRule mockedValidationRule1;
    @Mock
    private NumberValidator.ValidationRule mockedValidationRule2;

    private NumberValidator.ValidationRule fakeValidationRuleDiscardTwo = new NumberValidator.ValidationRule() {
        @Override
        public boolean isValid(Integer number) {
            return !number.equals(2);
        }
    };

    private NumberValidator.ValidationRule fakeValidationRuleDiscardFour = new NumberValidator.ValidationRule() {
        @Override
        public boolean isValid(Integer number) {
            return !number.equals(4);
        }
    };

    @Before
    public void setUp() throws Exception {
        initializeMocks();
        initializeNumberValidator();
    }

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
        initializeNumberValidatorWithFakes();

        List<Integer> numbers = generateNumbersList(1, 2, 3, 4);

        List<Integer> result = numberValidator.removeNotValidNumbers(numbers);

        numbers.remove(new Integer(2));
        numbers.remove(new Integer(4));

        assertEquals(numbers, result);
    }

    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    private void initializeNumberValidator() {
        Collection<NumberValidator.ValidationRule> rules = generateValidationRuleCollection();
        numberValidator = new NumberValidator(rules);
    }

    private void initializeNumberValidatorWithFakes() {
        Collection<NumberValidator.ValidationRule> rules = new LinkedList<NumberValidator.ValidationRule>();
        rules.add(fakeValidationRuleDiscardTwo);
        rules.add(fakeValidationRuleDiscardFour);
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

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

    private static final int POSITIVE_VALUE = 100;
    private static final int ZERO = 0;
    private static final int NEGATIVE_VALUE = -11;

    private NegativeNumberSearcher validator;

    @Before
    public void setUp() {
        initializeRule();
    }

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

    private void initializeRule() {
        validator = new NegativeNumberSearcher();
    }

    private List<Integer> generateIntegerList(int num) {
        List<Integer> nums = new LinkedList<Integer>();
        nums.add(num);
        return nums;
    }
}

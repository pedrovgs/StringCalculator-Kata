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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tess created to check the correctness of LessThanValidationRule
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class LessThanValidationRuleTest {

    private static final int TOP_VALUE = 100;
    private static final int LESS_THAN_TOP_VALUE = 11;

    private LessThanValidationRule rule;

    @Before
    public void setUp() {
        initializeRule();
    }

    @Test
    public void shouldValidateANumberLessThanTopValue() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    @Test
    public void shouldNotValidateANumberEqualsToTheTopValue() {
        assertFalse(rule.isValid(TOP_VALUE));
    }

    @Test
    public void shouldNotValidateANumberGratherThanTopValue() {
        assertTrue(rule.isValid(LESS_THAN_TOP_VALUE));
    }

    private void initializeRule() {
        rule = new LessThanValidationRule(TOP_VALUE);
    }
}

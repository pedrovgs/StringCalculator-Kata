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

import com.pedro.stringcalculator.exception.ValidatorException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Main class of this application. StringCalculator is an application created to analyze one string, extract the
 * numeric values and return an integer that represents the sum of the numeric values. Some interesting conditions
 * are described in the application documentation.
 * <p/>
 * This are the use cases implemented in this application:
 * <p/>
 * If the application doesn't receive any number should return zero.
 * If the application receive only one number should return the same number. Same behaviour expected with numbers of different digits.
 * If the application receive some numbers separated with one character will return the sum of all of them.
 * The application supports new line character separators.
 * The application supports more than one separator separator.
 * The application supports more than one separator at the same time.
 * <p/>
 * If the application receipts one or some negative numbers will it will throw a NegativeNumbersNotSupportedException.
 * If the application receipts on number grater than 1000 this number will have to be discarded in the sum.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class StringCalculator {

    private static final int VALIDATION_TOP_NUMBER = 1000;

    private NumberExtractor numberExtractor;
    private ForbiddenNumberSearcher negativeNumberSearcher;
    private NumberValidator numberValidator;

    public StringCalculator() {
        initializeNumberExtractor();
        initializeNegativeNumberValidator();
        initializeNumbersValidator();
    }

    /**
     * Parse an string and sum all the numeric values removing the non numeric characters.
     *
     * @param numbers to analyze and sum.
     * @return the sum value with some restrictions described in the project documentation.
     */
    public int add(final String numbers) throws ValidatorException {
        List<Integer> numbersList = extractNumbers(numbers);
        checkIfThereAreNegativeNumbers(numbersList);
        numbersList = validateNumbers(numbersList);
        return sumNumbers(numbersList);
    }

    private void initializeNumbersValidator() {
        NumberValidator.ValidationRule rule = new LessThanValidationRule(VALIDATION_TOP_NUMBER);
        Collection<NumberValidator.ValidationRule> rules = new LinkedList<NumberValidator.ValidationRule>();
        rules.add(rule);
        this.numberValidator = new NumberValidator(rules);
    }

    private void initializeNegativeNumberValidator() {
        this.negativeNumberSearcher = new NegativeNumberSearcher();
    }

    private void initializeNumberExtractor() {
        this.numberExtractor = new NumberExtractor();
    }


    private List<Integer> extractNumbers(final String numbers) {
        return numberExtractor.extract(numbers);
    }

    private void checkIfThereAreNegativeNumbers(final List<Integer> numbersList) throws ValidatorException {
        negativeNumberSearcher.validate(numbersList);
    }

    private List<Integer> validateNumbers(final List<Integer> numbersList) {
        return numberValidator.removeNotValidNumbers(numbersList);
    }

    private int sumNumbers(List<Integer> numberList) {
        int sum = 0;
        for (Integer num : numberList) {
            sum += num;
        }
        return sum;
    }

}

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

import java.util.LinkedList;
import java.util.List;


/**
 * Validator created to detect negative numbers. If this validator detects a negative number will throw a
 * NegativeNumbersNotSupportedException.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class NegativeNumberSearcher implements ForbiddenNumberSearcher {

    @Override
    public void validate(final List<Integer> numbers) throws ValidatorException {
        List<Integer> negativeNumbers = getNegativeNumbers(numbers);
        if (negativeNumbers.size() > 0) {
            throw new NegativeNumbersNotSupportedException(negativeNumbers);
        }
    }

    private List<Integer> getNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new LinkedList<Integer>();
        for (Integer num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            }
        }
        return negativeNumbers;
    }

}

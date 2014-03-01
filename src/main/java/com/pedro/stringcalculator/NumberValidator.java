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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Class created to evaluate witch are valid numbers inside a List<Integer>. This implementation it's based on a
 * ValidationRule collection that will be executed each time a List<Integer> be validated.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class NumberValidator {

    /*
     * Attributes
     */

    private Collection<ValidationRule> rules;

    /*
     * Constructor
     */

    NumberValidator(Collection<ValidationRule> rules) {
        this.rules = rules;
    }

    /*
     * Public methods
     */

    /**
     * For each element inside the numbers parameter this method will evaluate if it's valid to add it or not to the
     * result collection.
     *
     * @param numbers to analyze.
     * @return a List<Integer> without the invalid numbers
     */
    public List<Integer> removeNotValidNumbers(List<Integer> numbers) {
        List<Integer> result = new LinkedList<Integer>();
        for (Integer num : numbers) {
            if (isValid(num)) {
                result.add(num);
            }
        }
        return result;
    }


    /*
     * Auxiliary methods
     */

    private boolean isValid(Integer num) {
        boolean res = true;
        for (ValidationRule rule : rules) {
            if (!rule.isValid(num)) {
                res = false;
                break;
            }
        }
        return res;
    }

    /*
     Inner collaborators
     */

    /**
     * Little interface created to represent a validation rule.
     */
    interface ValidationRule {

        boolean isValid(Integer number);

    }

}

package com.pedro.stringcalculator;

import java.util.List;

import java.util.Collection;

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
        return null;
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

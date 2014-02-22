package com.pedro.stringcalculator;

/**
 * ValidationRule created to discard all the numbers grater than or equals to the value passed in the constructor.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class LessThanValidationRule implements NumberValidator.ValidationRule {

    /*
     * Attributes
     */
    private final int value;

    /*
     * Constructor
     */

    LessThanValidationRule(int value) {
        this.value = value;
    }

    @Override
    public boolean isValid(Integer number) {
        return number < value;
    }

}

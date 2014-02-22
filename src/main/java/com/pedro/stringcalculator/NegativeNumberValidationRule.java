package com.pedro.stringcalculator;

/**
 * Validation rule created to detect negative numbers. If this rule evaluate a negative number will throw a
 * NegativeNumbersNotSupportedException.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NegativeNumberValidationRule implements NumberValidator.ValidationRule{
    @Override
    public boolean isValid(Integer number) {
        return false;
    }
}

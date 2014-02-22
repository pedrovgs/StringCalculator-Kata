package com.pedro.stringcalculator;


import com.pedro.stringcalculator.exception.ValidatorException;

import java.util.List;

/**
 * Interface created to represent a validator that evaluates a list of integers.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
interface ListNumberValidator {

    public void validate(List<Integer> numbers) throws ValidatorException;
}

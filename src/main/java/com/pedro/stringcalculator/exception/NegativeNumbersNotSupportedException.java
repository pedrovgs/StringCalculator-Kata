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
package com.pedro.stringcalculator.exception;

import java.util.List;

/**
 * Exception created to be thrown when the application is used with negative numbers.
 * <p/>
 * This exception contains information about the negative numbers that throws the exception.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class NegativeNumbersNotSupportedException extends ValidatorException {

    private static final String EXCEPTION_NAME = "NegativeNumbersNotSupportedException";

    private List<Integer> negativeNumbers;

    public NegativeNumbersNotSupportedException(List<Integer> negativeNumbers) {
        this.negativeNumbers = negativeNumbers;
    }

    public static String getExceptionName() {
        return EXCEPTION_NAME;
    }

    @Override
    public String getMessage() {
        return EXCEPTION_NAME + negativeNumbers.toString();
    }
}

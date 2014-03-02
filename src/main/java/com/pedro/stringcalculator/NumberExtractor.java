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

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class created to work as a number extractor. This class will receive a string with some numbers inside and will
 * extract it in a number collection.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
class NumberExtractor {

    /*
     * Constants
     */

    private static final String ONE_DIGIT_OR_MORE_REG_EX = "-?\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(ONE_DIGIT_OR_MORE_REG_EX);

    /*
     * Public methods
     */

    /**
     * Analyze the string passed as parameter searching numbers and return a list with all of them
     *
     * @param stringToAnalyze can contains different separators and numbers with more than one digit.
     * @return a List<Integer> with the numbers found
     */
    public List<Integer> extract(final String stringToAnalyze) {
        List<Integer> result = new LinkedList<Integer>();
        if (stringToAnalyze != null && !stringToAnalyze.isEmpty()) {
            result = getNumbersUsingRegEx(stringToAnalyze);
        }
        return result;
    }

    /*
     * Auxiliary methods
     */

    private List<Integer> getNumbersUsingRegEx(String string) {
        Matcher matcher = NUMBER_PATTERN.matcher(string);
        return extractNumbersFromMatcher(matcher);
    }

    private List<Integer> extractNumbersFromMatcher(Matcher matcher) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numbers.add(number);
        }
        return numbers;
    }


}

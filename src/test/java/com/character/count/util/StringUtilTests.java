package com.character.count.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTests {
    @Test
    void whenGiveParams_thenReturnCorrectResult() {
        int count = StringUtils.assumeQuantityInString("some_text", 't');
        Assertions.assertEquals(2, count);
    }

    @Test
    void whenGiveMissingCharacter_thenReturnZero() {
        int count = StringUtils.assumeQuantityInString("some_text", 'g');
    }
}

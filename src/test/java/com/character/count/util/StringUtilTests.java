package com.character.count.util;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringUtilTests {
    void whenGiveParams_thenReturnCorrectResult() {
        int count = StringUtils.assumeQuantityInString("some_text", 't');
        Assertions.assertEquals(2, count);
    }
}

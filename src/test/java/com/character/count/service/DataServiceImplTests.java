package com.character.count.service;

import com.character.count.model.CharacterQuantityInString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataServiceImplTests {
    private static DataServiceImpl dataService;
    @BeforeAll
    static void init() {
        dataService = new DataServiceImpl();
    }

    @Test
    void whenGiveSomeData_thenResultListContainsAll() {
        CharacterQuantityInString characterQuantity1 = new CharacterQuantityInString("text", 't');
        CharacterQuantityInString characterQuantity2 = new CharacterQuantityInString("text", 'e');
        CharacterQuantityInString characterQuantity3 = new CharacterQuantityInString("text", 'x');

        List<CharacterQuantityInString> characterQuantityInStrings = dataService.processData("text");

        Assertions.assertTrue(characterQuantityInStrings.contains(characterQuantity1));
        Assertions.assertTrue(characterQuantityInStrings.contains(characterQuantity2));
        Assertions.assertTrue(characterQuantityInStrings.contains(characterQuantity3));
    }

    @Test
    void checkThatResultListContainsObjectWithCorrectQuantity() {
        List<CharacterQuantityInString> characterQuantityInStrings = dataService.processData("text");
        boolean result = false;

        for (CharacterQuantityInString characterQuantity: characterQuantityInStrings) {
            if (characterQuantity.getCharacter().equals('t') &&
                    characterQuantity.getQuantity() == 2) {
                result = true;
                break;
            }
        }
        Assertions.assertTrue(result);
    }
}

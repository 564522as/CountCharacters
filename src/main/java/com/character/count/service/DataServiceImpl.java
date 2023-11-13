package com.character.count.service;

import com.character.count.model.CharacterQuantityInString;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataServiceImpl implements DataService{

    @Override
    public List<CharacterQuantityInString> processData(String data) {
        List<CharacterQuantityInString> list = new ArrayList<>();
        Set<Character> characters = changeToSet(data.toCharArray());
        for (Character c: characters) {
            list.add(new CharacterQuantityInString(data, c));
        }
        return list;
    }

    private Set<Character> changeToSet(char[] array) {
        Set<Character> set = new HashSet<>();
        for (Character c: array) {
            set.add(c);
        }
        return set;
    }
}

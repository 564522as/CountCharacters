package com.character.count.service;

import com.character.count.model.CharacterQuantityInString;

import java.util.List;

public interface DataService {
    public List<CharacterQuantityInString> processData(String data);
}

package com.character.count.model;

import com.character.count.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class CharacterQuantityInString implements Comparable<CharacterQuantityInString> {
    @JsonIgnore
    private final String text;
    private final Character character;
    private final int quantity;

    public CharacterQuantityInString(String text, Character character) {
        this.text = text;
        this.character = character;
        this.quantity = StringUtils.assumeQuantityInString(text, character);
    }

    public String getText() {
        return text;
    }

    public Character getCharacter() {
        return character;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(CharacterQuantityInString o) {
        return Integer.compare(this.getQuantity(), o.getQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterQuantityInString that = (CharacterQuantityInString) o;
        return quantity == that.quantity && Objects.equals(text, that.text) && Objects.equals(character, that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, character, quantity);
    }
}

package com.character.count.util;

public class StringUtils {
    public static int assumeQuantityInString(String text, Character c) {
        return text.length() - text.replace(c.toString(), "").length();
    }
}

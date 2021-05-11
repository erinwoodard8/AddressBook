package com.tts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void addEntry() {
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher("202 555 0125");
        assertTrue(matcher.matches());
    }
}
package com.nexus.validations.implementations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NonNullOrBlankValidatorTest {

    private final NonNullOrBlankValidator validator = new NonNullOrBlankValidator();

    @Test
    void testValidString() {
        String validString = "Test";
        assertTrue(validator.isValid(validString, null));
    }

    @Test
    void testEmptyString() {
        String emptyString = "";
        assertFalse(validator.isValid(emptyString, null));
    }

    @Test
    void testNullString() {
        String nullString = null;
        assertFalse(validator.isValid(nullString, null));
    }

    @Test
    void testBlankString() {
        String blankString = "   ";
        assertFalse(validator.isValid(blankString, null));
    }
}

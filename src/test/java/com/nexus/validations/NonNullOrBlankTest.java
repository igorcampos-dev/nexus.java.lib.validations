package com.nexus.validations;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NonNullOrBlankTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private static class Example {
        @NonNullOrBlank
        private String value;

        void setValue(String value) {
            this.value = value;
        }
    }

    @Test
    void testValidString() {
        Example example = new Example();
        example.setValue("Hello, World!");

        Set<ConstraintViolation<Example>> violations = validator.validate(example);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullString() {
        Example example = new Example();
        example.setValue(null);

        Set<ConstraintViolation<Example>> violations = validator.validate(example);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyString() {
        Example example = new Example();
        example.setValue("");

        Set<ConstraintViolation<Example>> violations = validator.validate(example);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testWhitespaceString() {
        Example example = new Example();
        example.setValue("     ");

        Set<ConstraintViolation<Example>> violations = validator.validate(example);
        assertFalse(violations.isEmpty());
    }
}

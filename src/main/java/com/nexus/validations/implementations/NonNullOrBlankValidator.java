package com.nexus.validations.implementations;

import com.nexus.validations.NonNullOrBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonNullOrBlankValidator implements ConstraintValidator<NonNullOrBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.trim().isEmpty();
    }
}

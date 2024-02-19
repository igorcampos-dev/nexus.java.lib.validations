package com.nexus.validations.implementations;

import com.nexus.validations.ValidPassword;
import com.nexus.validations.exceptions.LargePasswordException;
import com.nexus.validations.exceptions.SmallPasswordException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private int minLength;
    private int maxLength;

    @Override
    public void initialize(ValidPassword constraint) {
        this.minLength = constraint.minLength();
        this.maxLength = constraint.maxLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        if (value.length() < minLength) {
            throw new SmallPasswordException("Senha pequena");
        }

        if (value.length() > maxLength) {
            throw new LargePasswordException("Senha grande");
        }
        return true;
    }
}

package com.nexus.validations.implementations;

import com.nexus.validations.ValidPassword;
import com.nexus.validations.exceptions.LargePasswordException;
import com.nexus.validations.exceptions.SmallPasswordException;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.lang.annotation.Annotation;
import static org.junit.jupiter.api.Assertions.*;

public class ValidPasswordValidatorTest {
    private ValidPasswordValidator validator;

    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new ValidPasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(this.getValidator().isValid("validPwd123", context));
    }

    @Test
    void testNullPassword() {
        assertFalse(this.getValidator().isValid(null, context));
    }

    @Test
    void testEmptyPassword() {
        assertFalse(this.getValidator().isValid("", context));
    }

    @Test
    void testSmallPasswordException(){
        assertThrows(SmallPasswordException.class, () -> this.getValidator().isValid("pwd", context));
    }

    @Test
    void testLargePasswordException(){
        assertThrows(LargePasswordException.class, () ->
                this.getValidator().isValid("longPwdLongPwdLongPwdLongPwd", context));
    }

    @Test
    void testShortPassword() {
        int minLength = 8;
        int maxLength = 20;
        validator.initialize(createValidPasswordAnnotation(minLength, maxLength));
        assertThrows(SmallPasswordException.class, () -> validator.isValid("pwd", context));
    }

    private ValidPassword createValidPasswordAnnotation(int minLength, int maxLength) {
        return new ValidPassword() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public int minLength() {
                return minLength;
            }

            @Override
            public int maxLength() {
                return maxLength;
            }

            @Override
            public String message() {
                return null;
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class[] payload() {
                return new Class[0];
            }

        };
    }


    ValidPasswordValidator getValidator(){
        int minLength = 8;
        int maxLength = 20;
        validator.initialize(createValidPasswordAnnotation(minLength, maxLength));
        return validator;
    }
}

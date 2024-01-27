package com.nexus.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import com.nexus.validations.implementations.NonNullOrBlankValidator;
import jakarta.validation.Payload;

@Constraint(validatedBy = NonNullOrBlankValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonNullOrBlank {
    String message() default "A string não pode ser nula ou vazia";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

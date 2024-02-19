package com.nexus.validations;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Senha inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int minLength() default 8;
    int maxLength() default 100;
}

/**
 * @author Igor de Campos Kopschinski
 * @version 1.0
 * <p>
 * Anotação para validar senhas.
 * <p>
 * Esta anotação é utilizada para validar senhas, garantindo que atendam a requisitos mínimos de comprimento.
 * Ela pode ser aplicada a campos de senha em classes de modelo ou DTO.
 * </p>
 *
 * @see com.nexus.validations.implementations.ValidPasswordValidator
 */

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

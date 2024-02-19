/**
 * @author Igor de Campos Kopschinski
 * @version 1.0
 * <p>
 * A notação {@code NonNullOrBlank} é utilizada para validar se uma ‘string’ não é nula e nem vazia.
 * Ela é aplicada a campos de texto em classes de Java para garantir que esses campos tenham valores significativos.
 * <p>
 * Uso:
 * A notação {@code NonNullOrBlank} pode ser aplicada a campos de texto em classes de Java para impor a restrição
 * de que esses campos não podem ser nulos ou vazios.
 * <p>
 * Atributos:
 * - {@code message}: Mensagem de erro a ser exibida se a validação falhar. O valor padrão é "A ‘string’ não pode ser nula ou vazia".
 * - {@code groups}: Grupos de validação
 * - {@code payload}: Carga útil associada à validação
 * <p>
 * Author: Igor de Campos Kopschinski
 *
 * @see com.nexus.validations.implementations.NonNullOrBlankValidator
 */

package com.nexus.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Payload;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonNullOrBlank {
    String message() default "A string não pode ser nula ou vazia";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

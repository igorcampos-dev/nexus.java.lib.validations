package com.nexus.validations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;
import com.nexus.validations.implementations.Base64CheckValidator;

/**
 * Notação para validar se uma string codificada em Base64 representa uma imagem válida.
 * Pode ser aplicada a campos de classe ou métodos.
 *
 * Utilização:
 * Para usar esta anotação, aplique-a ao campo de string ou método que contém a representação
 * codificada em Base64 de uma imagem. A validação será realizada utilizando a implementação em
 * {@link Base64CheckValidator}.
 * <p>
 * Exemplo:
 * {@code @Base64Check(message = "A representação em Base64 não é uma imagem válida")}
 * private String imagemBase64;
 *
 * @author Igor de Campos Kopschinski
 *
 * @version 1.0
 *
 * Mensagem Padrão:
 * A mensagem padrão exibida quando a validação falha é "Imagem inválida".
 * Esta mensagem pode ser personalizada ao aplicar a anotação.
 *
 * @see Base64CheckValidator
 */

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Base64Check {
    String message() default "Imagem inválida";
}

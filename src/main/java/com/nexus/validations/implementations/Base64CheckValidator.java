package com.nexus.validations.implementations;

import com.nexus.validations.Base64Check;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Base64CheckValidator implements ConstraintValidator<Base64Check, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(value);

            try (InputStream inputStream = new ByteArrayInputStream(decodedBytes)) {
                BufferedImage image = ImageIO.read(inputStream);
                if (image == null) {
                    throw new IOException("Falha na validação: Não é uma imagem válida.");
                }
                return true;
            }
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }
    }
}

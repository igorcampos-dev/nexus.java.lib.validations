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
        if (value == null) {
            return false;
        }
        byte[] decodedBytes = decodeInBytes(value);
        return validateImage(decodedBytes);
    }

    private byte[] decodeInBytes(String object) {
        return Base64.getDecoder().decode(object);
    }

    private boolean validateImage(byte[] bytesImage) {
        try (InputStream stream = new ByteArrayInputStream(bytesImage)) {
            BufferedImage image = ImageIO.read(stream);

            if (image == null) {
                throw new IOException("Falha na validação: Não é uma imagem válida.");
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

package com.louazri.webapplication.Validations;

import com.louazri.webapplication.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordStrengthValidator
        implements ConstraintValidator<PasswordValidator, String> {

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])" +         // at least 1 digit
                    "(?=.*[a-z])" +         // at least 1 lowercase
                    "(?=.*[A-Z])" +         // at least 1 uppercase
                    "(?=.*[@#$%^&+=!])" +   // at least 1 special char
                    "(?=\\S+$).{8,}$";      // no spaces, min 8 chars

    private final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;
        return pattern.matcher(password).matches();
    }
}


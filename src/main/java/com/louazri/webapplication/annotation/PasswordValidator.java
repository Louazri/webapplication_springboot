package com.louazri.webapplication.annotation;

import com.louazri.webapplication.Validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default
            "Password must contain at least 1 uppercase, 1 lowercase, 1 number and 1 special character";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

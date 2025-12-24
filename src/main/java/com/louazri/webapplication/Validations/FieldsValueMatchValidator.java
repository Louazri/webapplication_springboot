package com.louazri.webapplication.Validations;

import com.louazri.webapplication.annotation.FieldsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator
        implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        // 1️⃣ If either field is null → invalid
        if (fieldValue == null || fieldMatchValue == null) {
            return false;
        }

        // 2️⃣ If already encrypted (update case)
        if (fieldValue.toString().startsWith("$2a$")) {
            return true;
        }

        // 3️⃣ Compare both fields
        return fieldValue.equals(fieldMatchValue);
    }
}

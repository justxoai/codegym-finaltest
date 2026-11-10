package com.codegym.realestate.validation;

import com.codegym.realestate.constant.ValidationRules;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class SoDienThoaiValidator implements ConstraintValidator<SoDienThoaiHopLe, String> {

    private static final Pattern SO_DIEN_THOAI_PATTERN = Pattern.compile(ValidationRules.SO_DIEN_THOAI_REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !StringUtils.hasText(value) || SO_DIEN_THOAI_PATTERN.matcher(value).matches();
    }
}

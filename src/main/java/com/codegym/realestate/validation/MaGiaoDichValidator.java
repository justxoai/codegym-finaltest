package com.codegym.realestate.validation;

import com.codegym.realestate.constant.ValidationRules;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class MaGiaoDichValidator implements ConstraintValidator<MaGiaoDichHopLe, String> {

    private static final Pattern MA_GIAO_DICH_PATTERN = Pattern.compile(ValidationRules.MA_GIAO_DICH_REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !StringUtils.hasText(value) || MA_GIAO_DICH_PATTERN.matcher(value).matches();
    }
}

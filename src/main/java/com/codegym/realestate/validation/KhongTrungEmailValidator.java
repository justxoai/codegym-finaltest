package com.codegym.realestate.validation;

import com.codegym.realestate.service.KhachHangService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class KhongTrungEmailValidator implements ConstraintValidator<KhongTrungEmail, String> {

    private final KhachHangService khachHangService;

    public KhongTrungEmailValidator(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !StringUtils.hasText(value) || !khachHangService.daTonTaiEmail(value);
    }
}

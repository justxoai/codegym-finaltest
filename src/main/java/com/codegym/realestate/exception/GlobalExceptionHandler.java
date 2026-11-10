package com.codegym.realestate.exception;

import com.codegym.realestate.constant.ModelAttributes;
import com.codegym.realestate.constant.ViewNames;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFound(ResourceNotFoundException exception, Model model) {
        model.addAttribute(ModelAttributes.THONG_BAO_LOI, exception.getMessage());
        return ViewNames.KHONG_TIM_THAY;
    }
}

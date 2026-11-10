package com.codegym.realestate.controller;

import com.codegym.realestate.constant.Messages;
import com.codegym.realestate.constant.ModelAttributes;
import com.codegym.realestate.constant.Routes;
import com.codegym.realestate.constant.ViewNames;
import com.codegym.realestate.dto.KhachHangForm;
import com.codegym.realestate.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(Routes.KHACH_HANG)
public class KhachHangController {

    private final KhachHangService khachHangService;

    public KhachHangController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping(Routes.THEM_MOI)
    public String hienThiFormThemMoi(Model model) {
        model.addAttribute(ModelAttributes.KHACH_HANG_FORM, new KhachHangForm());
        return ViewNames.KHACH_HANG_THEM_MOI;
    }

    @PostMapping(Routes.THEM_MOI)
    public String themMoi(@Valid @ModelAttribute(ModelAttributes.KHACH_HANG_FORM) KhachHangForm form,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return ViewNames.KHACH_HANG_THEM_MOI;
        }
        khachHangService.themMoi(form);
        redirectAttributes.addFlashAttribute(ModelAttributes.THONG_BAO, Messages.THEM_KHACH_HANG_THANH_CONG);
        return Routes.REDIRECT_GIAO_DICH_THEM_MOI;
    }
}

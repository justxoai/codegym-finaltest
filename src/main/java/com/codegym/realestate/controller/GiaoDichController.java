package com.codegym.realestate.controller;

import com.codegym.realestate.constant.Messages;
import com.codegym.realestate.constant.ModelAttributes;
import com.codegym.realestate.constant.Routes;
import com.codegym.realestate.constant.ViewNames;
import com.codegym.realestate.dto.GiaoDichForm;
import com.codegym.realestate.dto.GiaoDichSearchCriteria;
import com.codegym.realestate.enums.LoaiDichVu;
import com.codegym.realestate.exception.DuplicateResourceException;
import com.codegym.realestate.service.GiaoDichService;
import com.codegym.realestate.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(Routes.GIAO_DICH)
public class GiaoDichController {

    private static final String FIELD_MA_GIAO_DICH = "maGiaoDich";
    private static final String ERROR_CODE_DUPLICATE = "Duplicate";

    private final GiaoDichService giaoDichService;
    private final KhachHangService khachHangService;

    public GiaoDichController(GiaoDichService giaoDichService, KhachHangService khachHangService) {
        this.giaoDichService = giaoDichService;
        this.khachHangService = khachHangService;
    }

    @ModelAttribute(ModelAttributes.DS_LOAI_DICH_VU)
    public LoaiDichVu[] danhSachLoaiDichVu() {
        return LoaiDichVu.values();
    }

    @GetMapping
    public String danhSach(@ModelAttribute(ModelAttributes.TIEU_CHI) GiaoDichSearchCriteria criteria, Model model) {
        model.addAttribute(ModelAttributes.DS_GIAO_DICH, giaoDichService.timKiem(criteria));
        return ViewNames.DANH_SACH;
    }

    @GetMapping(Routes.THEM_MOI)
    public String hienThiFormThemMoi(Model model) {
        model.addAttribute(ModelAttributes.GIAO_DICH_FORM, new GiaoDichForm());
        return formThemMoi(model);
    }

    @PostMapping(Routes.THEM_MOI)
    public String themMoi(@Valid @ModelAttribute(ModelAttributes.GIAO_DICH_FORM) GiaoDichForm form,
                          BindingResult bindingResult,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            try {
                giaoDichService.themMoi(form);
                redirectAttributes.addFlashAttribute(ModelAttributes.THONG_BAO, Messages.THEM_MOI_THANH_CONG);
                return Routes.REDIRECT_DANH_SACH;
            } catch (DuplicateResourceException exception) {
                bindingResult.rejectValue(FIELD_MA_GIAO_DICH, ERROR_CODE_DUPLICATE);
            }
        }
        return formThemMoi(model);
    }

    @GetMapping(Routes.CHI_TIET)
    public String chiTiet(@PathVariable String maGiaoDich, Model model) {
        model.addAttribute(ModelAttributes.GIAO_DICH, giaoDichService.layChiTiet(maGiaoDich));
        return ViewNames.CHI_TIET;
    }

    @PostMapping(Routes.XOA)
    public String xoa(@PathVariable String maGiaoDich, RedirectAttributes redirectAttributes) {
        giaoDichService.xoa(maGiaoDich);
        redirectAttributes.addFlashAttribute(ModelAttributes.THONG_BAO, Messages.XOA_THANH_CONG);
        return Routes.REDIRECT_DANH_SACH;
    }

    private String formThemMoi(Model model) {
        model.addAttribute(ModelAttributes.DS_KHACH_HANG, khachHangService.layDanhSach());
        return ViewNames.THEM_MOI;
    }
}

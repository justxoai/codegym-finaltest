package com.codegym.realestate.dto;

import com.codegym.realestate.constant.ValidationRules;
import com.codegym.realestate.validation.KhongTrungEmail;
import com.codegym.realestate.validation.KhongTrungSoDienThoai;
import com.codegym.realestate.validation.SoDienThoaiHopLe;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class KhachHangForm {

    @NotBlank
    @Size(max = ValidationRules.TEN_KHACH_HANG_TOI_DA)
    private String tenKhachHang;

    @NotBlank
    @SoDienThoaiHopLe
    @KhongTrungSoDienThoai
    private String soDienThoai;

    @NotBlank
    @Email
    @Size(max = ValidationRules.EMAIL_TOI_DA)
    @KhongTrungEmail
    private String email;

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

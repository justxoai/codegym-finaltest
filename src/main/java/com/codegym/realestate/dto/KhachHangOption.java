package com.codegym.realestate.dto;

public class KhachHangOption {

    private final Long maKhachHang;
    private final String tenKhachHang;

    public KhachHangOption(Long maKhachHang, String tenKhachHang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
    }

    public Long getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }
}

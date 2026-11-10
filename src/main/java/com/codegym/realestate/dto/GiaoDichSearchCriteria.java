package com.codegym.realestate.dto;

import com.codegym.realestate.enums.LoaiDichVu;

public class GiaoDichSearchCriteria {

    private String tenKhachHang;
    private LoaiDichVu loaiDichVu;

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }
}

package com.codegym.realestate.enums;

public enum LoaiDichVu {
    DAT("Đất"),
    NHA_DAT("Nhà và đất");

    private final String tenHienThi;

    LoaiDichVu(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public String getTenHienThi() {
        return tenHienThi;
    }
}

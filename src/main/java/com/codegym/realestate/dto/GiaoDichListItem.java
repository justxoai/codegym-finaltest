package com.codegym.realestate.dto;

import com.codegym.realestate.enums.LoaiDichVu;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GiaoDichListItem {

    private final String maGiaoDich;
    private final String tenKhachHang;
    private final LoaiDichVu loaiDichVu;
    private final LocalDate ngayGiaoDich;
    private final BigDecimal donGia;
    private final BigDecimal dienTich;

    public GiaoDichListItem(String maGiaoDich, String tenKhachHang, LoaiDichVu loaiDichVu,
                            LocalDate ngayGiaoDich, BigDecimal donGia, BigDecimal dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.tenKhachHang = tenKhachHang;
        this.loaiDichVu = loaiDichVu;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public BigDecimal getDienTich() {
        return dienTich;
    }
}

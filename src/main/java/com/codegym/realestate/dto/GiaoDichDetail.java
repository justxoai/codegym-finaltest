package com.codegym.realestate.dto;

import com.codegym.realestate.enums.LoaiDichVu;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GiaoDichDetail {

    private final String maGiaoDich;
    private final LoaiDichVu loaiDichVu;
    private final LocalDate ngayGiaoDich;
    private final BigDecimal donGia;
    private final BigDecimal dienTich;
    private final String tenKhachHang;
    private final String soDienThoai;
    private final String email;

    public GiaoDichDetail(String maGiaoDich, LoaiDichVu loaiDichVu, LocalDate ngayGiaoDich,
                          BigDecimal donGia, BigDecimal dienTich, String tenKhachHang,
                          String soDienThoai, String email) {
        this.maGiaoDich = maGiaoDich;
        this.loaiDichVu = loaiDichVu;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
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

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getEmail() {
        return email;
    }
}

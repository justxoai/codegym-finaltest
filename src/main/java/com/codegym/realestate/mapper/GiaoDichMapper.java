package com.codegym.realestate.mapper;

import com.codegym.realestate.dto.GiaoDichDetail;
import com.codegym.realestate.dto.GiaoDichForm;
import com.codegym.realestate.dto.GiaoDichListItem;
import com.codegym.realestate.entity.GiaoDich;
import com.codegym.realestate.entity.KhachHang;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GiaoDichMapper {

    public GiaoDichListItem toListItem(GiaoDich giaoDich) {
        return new GiaoDichListItem(
                giaoDich.getMaGiaoDich(),
                giaoDich.getKhachHang().getTenKhachHang(),
                giaoDich.getLoaiDichVu(),
                giaoDich.getNgayGiaoDich(),
                giaoDich.getDonGia(),
                chuanHoaDienTich(giaoDich.getDienTich())
        );
    }

    public GiaoDichDetail toDetail(GiaoDich giaoDich) {
        KhachHang khachHang = giaoDich.getKhachHang();
        return new GiaoDichDetail(
                giaoDich.getMaGiaoDich(),
                giaoDich.getLoaiDichVu(),
                giaoDich.getNgayGiaoDich(),
                giaoDich.getDonGia(),
                chuanHoaDienTich(giaoDich.getDienTich()),
                khachHang.getTenKhachHang(),
                khachHang.getSoDienThoai(),
                khachHang.getEmail()
        );
    }

    public GiaoDich toEntity(GiaoDichForm form, KhachHang khachHang) {
        GiaoDich giaoDich = new GiaoDich();
        giaoDich.setMaGiaoDich(form.getMaGiaoDich());
        giaoDich.setKhachHang(khachHang);
        giaoDich.setLoaiDichVu(form.getLoaiDichVu());
        giaoDich.setNgayGiaoDich(form.getNgayGiaoDich());
        giaoDich.setDonGia(form.getDonGia());
        giaoDich.setDienTich(form.getDienTich());
        return giaoDich;
    }

    private BigDecimal chuanHoaDienTich(BigDecimal dienTich) {
        return dienTich.stripTrailingZeros();
    }
}

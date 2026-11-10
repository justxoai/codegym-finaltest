package com.codegym.realestate.specification;

import com.codegym.realestate.dto.GiaoDichSearchCriteria;
import com.codegym.realestate.entity.GiaoDich;
import com.codegym.realestate.enums.LoaiDichVu;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class GiaoDichSpecification {

    private GiaoDichSpecification() {
    }

    public static Specification<GiaoDich> theoTieuChi(GiaoDichSearchCriteria criteria) {
        return Specification.where(tenKhachHangChua(criteria.getTenKhachHang()))
                .and(coLoaiDichVu(criteria.getLoaiDichVu()));
    }

    private static Specification<GiaoDich> tenKhachHangChua(String tenKhachHang) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(tenKhachHang)) {
                return builder.conjunction();
            }
            String keyword = "%" + tenKhachHang.trim().toLowerCase() + "%";
            return builder.like(builder.lower(root.join("khachHang").get("tenKhachHang")), keyword);
        };
    }

    private static Specification<GiaoDich> coLoaiDichVu(LoaiDichVu loaiDichVu) {
        return (root, query, builder) -> {
            if (loaiDichVu == null) {
                return builder.conjunction();
            }
            return builder.equal(root.get("loaiDichVu"), loaiDichVu);
        };
    }
}

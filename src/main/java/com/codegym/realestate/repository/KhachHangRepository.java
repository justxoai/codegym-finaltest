package com.codegym.realestate.repository;

import com.codegym.realestate.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

    List<KhachHang> findAllByOrderByTenKhachHangAsc();

    boolean existsBySoDienThoai(String soDienThoai);

    boolean existsByEmailIgnoreCase(String email);
}

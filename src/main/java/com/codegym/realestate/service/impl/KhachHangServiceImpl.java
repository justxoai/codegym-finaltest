package com.codegym.realestate.service.impl;

import com.codegym.realestate.dto.KhachHangForm;
import com.codegym.realestate.dto.KhachHangOption;
import com.codegym.realestate.mapper.KhachHangMapper;
import com.codegym.realestate.repository.KhachHangRepository;
import com.codegym.realestate.service.KhachHangService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;
    private final KhachHangMapper khachHangMapper;

    public KhachHangServiceImpl(KhachHangRepository khachHangRepository, KhachHangMapper khachHangMapper) {
        this.khachHangRepository = khachHangRepository;
        this.khachHangMapper = khachHangMapper;
    }

    @Override
    public List<KhachHangOption> layDanhSach() {
        return khachHangRepository.findAllByOrderByTenKhachHangAsc()
                .stream()
                .map(khachHangMapper::toOption)
                .toList();
    }

    @Override
    @Transactional
    public void themMoi(KhachHangForm form) {
        khachHangRepository.save(khachHangMapper.toEntity(form));
    }

    @Override
    public boolean daTonTaiSoDienThoai(String soDienThoai) {
        return khachHangRepository.existsBySoDienThoai(soDienThoai.trim());
    }

    @Override
    public boolean daTonTaiEmail(String email) {
        return khachHangRepository.existsByEmailIgnoreCase(email.trim());
    }
}

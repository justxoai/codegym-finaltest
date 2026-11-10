package com.codegym.realestate.service.impl;

import com.codegym.realestate.constant.Messages;
import com.codegym.realestate.dto.GiaoDichDetail;
import com.codegym.realestate.dto.GiaoDichForm;
import com.codegym.realestate.dto.GiaoDichListItem;
import com.codegym.realestate.dto.GiaoDichSearchCriteria;
import com.codegym.realestate.entity.GiaoDich;
import com.codegym.realestate.entity.KhachHang;
import com.codegym.realestate.exception.DuplicateResourceException;
import com.codegym.realestate.exception.ResourceNotFoundException;
import com.codegym.realestate.mapper.GiaoDichMapper;
import com.codegym.realestate.repository.GiaoDichRepository;
import com.codegym.realestate.repository.KhachHangRepository;
import com.codegym.realestate.service.GiaoDichService;
import com.codegym.realestate.specification.GiaoDichSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GiaoDichServiceImpl implements GiaoDichService {

    private static final Sort SAP_XEP_THEO_MA = Sort.by(Sort.Direction.ASC, "maGiaoDich");

    private final GiaoDichRepository giaoDichRepository;
    private final KhachHangRepository khachHangRepository;
    private final GiaoDichMapper giaoDichMapper;

    public GiaoDichServiceImpl(GiaoDichRepository giaoDichRepository,
                               KhachHangRepository khachHangRepository,
                               GiaoDichMapper giaoDichMapper) {
        this.giaoDichRepository = giaoDichRepository;
        this.khachHangRepository = khachHangRepository;
        this.giaoDichMapper = giaoDichMapper;
    }

    @Override
    public List<GiaoDichListItem> timKiem(GiaoDichSearchCriteria criteria) {
        return giaoDichRepository
                .findAll(GiaoDichSpecification.theoTieuChi(criteria), SAP_XEP_THEO_MA)
                .stream()
                .map(giaoDichMapper::toListItem)
                .toList();
    }

    @Override
    public GiaoDichDetail layChiTiet(String maGiaoDich) {
        GiaoDich giaoDich = giaoDichRepository.findById(maGiaoDich)
                .orElseThrow(() -> khongTimThayGiaoDich(maGiaoDich));
        return giaoDichMapper.toDetail(giaoDich);
    }

    @Override
    @Transactional
    public void themMoi(GiaoDichForm form) {
        if (giaoDichRepository.existsById(form.getMaGiaoDich())) {
            throw new DuplicateResourceException(String.format(Messages.GIAO_DICH_DA_TON_TAI, form.getMaGiaoDich()));
        }
        KhachHang khachHang = khachHangRepository.findById(form.getMaKhachHang())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(Messages.KHACH_HANG_KHONG_TON_TAI, form.getMaKhachHang())));
        giaoDichRepository.save(giaoDichMapper.toEntity(form, khachHang));
    }

    @Override
    @Transactional
    public void xoa(String maGiaoDich) {
        if (!giaoDichRepository.existsById(maGiaoDich)) {
            throw khongTimThayGiaoDich(maGiaoDich);
        }
        giaoDichRepository.deleteById(maGiaoDich);
    }

    private ResourceNotFoundException khongTimThayGiaoDich(String maGiaoDich) {
        return new ResourceNotFoundException(String.format(Messages.GIAO_DICH_KHONG_TON_TAI, maGiaoDich));
    }
}

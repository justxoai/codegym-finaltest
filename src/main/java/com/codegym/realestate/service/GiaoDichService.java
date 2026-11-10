package com.codegym.realestate.service;

import com.codegym.realestate.dto.GiaoDichDetail;
import com.codegym.realestate.dto.GiaoDichForm;
import com.codegym.realestate.dto.GiaoDichListItem;
import com.codegym.realestate.dto.GiaoDichSearchCriteria;

import java.util.List;

public interface GiaoDichService {

    List<GiaoDichListItem> timKiem(GiaoDichSearchCriteria criteria);

    GiaoDichDetail layChiTiet(String maGiaoDich);

    void themMoi(GiaoDichForm form);

    void xoa(String maGiaoDich);
}

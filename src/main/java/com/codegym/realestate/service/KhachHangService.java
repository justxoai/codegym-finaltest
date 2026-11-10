package com.codegym.realestate.service;

import com.codegym.realestate.dto.KhachHangForm;
import com.codegym.realestate.dto.KhachHangOption;

import java.util.List;

public interface KhachHangService {

    List<KhachHangOption> layDanhSach();

    void themMoi(KhachHangForm form);

    boolean daTonTaiSoDienThoai(String soDienThoai);

    boolean daTonTaiEmail(String email);
}

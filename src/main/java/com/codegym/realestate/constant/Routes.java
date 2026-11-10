package com.codegym.realestate.constant;

public final class Routes {

    public static final String GIAO_DICH = "/giao-dich";
    public static final String KHACH_HANG = "/khach-hang";
    public static final String THEM_MOI = "/them-moi";
    public static final String CHI_TIET = "/{maGiaoDich}";
    public static final String XOA = "/{maGiaoDich}/xoa";
    public static final String REDIRECT_DANH_SACH = "redirect:" + GIAO_DICH;
    public static final String REDIRECT_GIAO_DICH_THEM_MOI = "redirect:" + GIAO_DICH + THEM_MOI;

    private Routes() {
    }
}

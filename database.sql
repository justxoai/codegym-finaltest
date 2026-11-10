DROP DATABASE IF EXISTS real_estate_transaction;

CREATE DATABASE real_estate_transaction
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE real_estate_transaction;

SET NAMES utf8mb4;

CREATE TABLE khach_hang (
    ma_khach_hang BIGINT NOT NULL AUTO_INCREMENT,
    ten_khach_hang VARCHAR(100) NOT NULL,
    so_dien_thoai VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (ma_khach_hang),
    CONSTRAINT uk_khach_hang_so_dien_thoai UNIQUE (so_dien_thoai),
    CONSTRAINT uk_khach_hang_email UNIQUE (email)
);

CREATE TABLE giao_dich (
    ma_giao_dich VARCHAR(8) NOT NULL,
    ma_khach_hang BIGINT NOT NULL,
    ngay_giao_dich DATE NOT NULL,
    loai_dich_vu VARCHAR(20) NOT NULL,
    don_gia DECIMAL(15, 2) NOT NULL,
    dien_tich DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (ma_giao_dich),
    CONSTRAINT fk_giao_dich_khach_hang FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang (ma_khach_hang),
    CONSTRAINT chk_giao_dich_loai_dich_vu CHECK (loai_dich_vu IN ('DAT', 'NHA_DAT')),
    CONSTRAINT chk_giao_dich_don_gia CHECK (don_gia > 500000),
    CONSTRAINT chk_giao_dich_dien_tich CHECK (dien_tich > 20)
);

INSERT INTO khach_hang (ten_khach_hang, so_dien_thoai, email) VALUES
    ('Nguyễn Văn A', '0905973155', 'nguyenvana@gmail.com'),
    ('Nguyễn Văn B', '0905123456', 'nguyenvanb@gmail.com'),
    ('Nguyễn Văn C', '0935987654', 'nguyenvanc@gmail.com'),
    ('Trần Thị Mai', '0912345678', 'tranthimai@gmail.com'),
    ('Lê Minh Quân', '0987654321', 'leminhquan@gmail.com');

INSERT INTO giao_dich (ma_giao_dich, ma_khach_hang, ngay_giao_dich, loai_dich_vu, don_gia, dien_tich) VALUES
    ('MGD-0001', 1, '2020-12-12', 'NHA_DAT', 2000000, 100),
    ('MGD-0002', 2, '2020-12-12', 'DAT', 3000000, 200),
    ('MGD-0003', 3, '2020-12-12', 'NHA_DAT', 5000000, 100),
    ('MGD-0004', 4, '2021-03-20', 'DAT', 1800000, 150),
    ('MGD-0005', 5, '2021-06-05', 'NHA_DAT', 7500000, 85),
    ('MGD-0006', 1, '2021-09-18', 'DAT', 2500000, 120);

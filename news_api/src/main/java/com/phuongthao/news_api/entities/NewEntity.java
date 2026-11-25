package com.phuongthao.news_api.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "News")

public class NewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String tieuDe;

    @Column(columnDefinition = "LONGTEXT")
    private String noiDung;

    @Column
    private String hinhAnh;

    @Column
    private String nguonTin;

    @Column
    private LocalDateTime ngayDang = LocalDateTime.now();

    @Column
    private LocalDateTime ngayCapNhat = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column
    private NewsStatus trangThai;

    @Column
    private Long luotXem = 0L;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn (name = "categoryId", nullable = false)
    private CategoryEntity category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNguonTin() {
        return nguonTin;
    }

    public void setNguonTin(String nguonTin) {
        this.nguonTin = nguonTin;
    }

    public LocalDateTime getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDateTime ngayDang) {
        this.ngayDang = ngayDang;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }


    public LocalDateTime getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDateTime ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public NewsStatus getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(NewsStatus trangThai) {
        this.trangThai = trangThai;
    }

    public Long getLuotXem() {
        return luotXem;
    }

    public void setLuotXem(Long luotXem) {
        this.luotXem = luotXem;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

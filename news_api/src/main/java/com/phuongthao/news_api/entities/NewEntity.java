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

    @Column
    private String trangThai;

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
}

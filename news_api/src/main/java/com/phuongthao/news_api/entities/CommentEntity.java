package com.phuongthao.news_api.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String noiDung;

    @Column
    private LocalDateTime ngayDang = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column
    private CommentStatus trangThai = CommentStatus.VISIBLE;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private CommentEntity parent;

    @ManyToOne
    @JoinColumn (name = "userId")
    private UserEntity users;

    @ManyToOne
    @JoinColumn (name = "newId")
    private NewEntity news;


    public Long getCommentId() {
        return id;
    }

    public void setCommentId(Long id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDateTime getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDateTime ngayDang) {
        this.ngayDang = ngayDang;
    }

    public CommentStatus getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(CommentStatus trangThai) {
        this.trangThai = trangThai;
    }

    public CommentEntity getParent() {
        return parent;
    }

    public void setParent(CommentEntity parent) {
        this.parent = parent;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public NewEntity getNews() {
        return news;
    }

    public void setNews(NewEntity news) {
        this.news = news;
    }
}

package com.example.vietha1.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quangcao {

    @SerializedName("IdQuangCao")
    @Expose
    private String idQuangCao;
    @SerializedName("Hinhanh")
    @Expose
    private String hinhanh;
    @SerializedName("Noidung")
    @Expose
    private String noidung;
    @SerializedName("IdLichSu")
    @Expose
    private String idLichSu;
    @SerializedName("TenLichsu")
    @Expose
    private String tenLichsu;
    @SerializedName("HinhLichsu")
    @Expose
    private String hinhLichsu;

    public String getIdQuangCao() {
        return idQuangCao;
    }

    public void setIdQuangCao(String idQuangCao) {
        this.idQuangCao = idQuangCao;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getIdLichSu() {
        return idLichSu;
    }

    public void setIdLichSu(String idLichSu) {
        this.idLichSu = idLichSu;
    }

    public String getTenLichsu() {
        return tenLichsu;
    }

    public void setTenLichsu(String tenLichsu) {
        this.tenLichsu = tenLichsu;
    }

    public String getHinhLichsu() {
        return hinhLichsu;
    }

    public void setHinhLichsu(String hinhLichsu) {
        this.hinhLichsu = hinhLichsu;
    }


}
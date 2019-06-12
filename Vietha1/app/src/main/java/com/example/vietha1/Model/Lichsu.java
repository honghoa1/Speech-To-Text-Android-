package com.example.vietha1.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Lichsu implements Serializable {

        @SerializedName("IdLichSu")
        @Expose
        private String idLichSu;
        @SerializedName("TenLichsu")
        @Expose
        private String tenLichsu;
        @SerializedName("HinhLichsu")
        @Expose
        private String hinhLichsu;
        @SerializedName("MoTa")
        @Expose
        private String moTa;

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

        public String getMoTa() {
            return moTa;
        }

        public void setMoTa(String moTa) {
            this.moTa = moTa;
        }

    }


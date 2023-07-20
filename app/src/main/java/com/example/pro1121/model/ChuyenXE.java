package com.example.pro1121.model;

import java.io.Serializable;

public class ChuyenXE implements Serializable {
    int id;
    String idchuyenxe,diemden,diemdi,gio,soxe, gia;


    public ChuyenXE() {
    }

    public ChuyenXE(int id, String diemdi, String diemden, String gio, String soxe, String gia) {
        this.id = id;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.gio = gio;
        this.soxe = soxe;
        this.gia=gia;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdchuyenxe() {
        return idchuyenxe;
    }

    public void setIdchuyenxe(String idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getSoxe() {
        return soxe;
    }

    public void setSoxe(String soxe) {
        this.soxe = soxe;
    }
}

package com.example.pro1121.model;

import java.io.Serializable;

public class VeXeDat implements Serializable {
    int id;
    String idvexedat,diemdendat,diemdidat,giodidat,giochuyendi,soxeve,tienve,soluongve,vitri;

    public VeXeDat() {
    }

    public VeXeDat(int id, String diemdendat, String diemdidat, String giodidat, String giochuyendi, String soxeve, String tienve, String soluongve, String vitri) {
        this.id = id;
        this.diemdendat = diemdendat;
        this.diemdidat = diemdidat;
        this.giodidat = giodidat;
        this.giochuyendi = giochuyendi;
        this.soxeve = soxeve;
        this.tienve = tienve;
        this.soluongve = soluongve;
        this.vitri = vitri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdvexedat() {
        return idvexedat;
    }

    public void setIdvexedat(String idvexedat) {
        this.idvexedat = idvexedat;
    }

    public String getDiemdendat() {
        return diemdendat;
    }

    public void setDiemdendat(String diemdendat) {
        this.diemdendat = diemdendat;
    }

    public String getDiemdidat() {
        return diemdidat;
    }

    public void setDiemdidat(String diemdidat) {
        this.diemdidat = diemdidat;
    }

    public String getGiodidat() {
        return giodidat;
    }

    public void setGiodidat(String giodidat) {
        this.giodidat = giodidat;
    }

    public String getGiochuyendi() {
        return giochuyendi;
    }

    public void setGiochuyendi(String giochuyendi) {
        this.giochuyendi = giochuyendi;
    }

    public String getSoxeve() {
        return soxeve;
    }

    public void setSoxeve(String soxeve) {
        this.soxeve = soxeve;
    }

    public String getTienve() {
        return tienve;
    }

    public void setTienve(String tienve) {
        this.tienve = tienve;
    }

    public String getSoluongve() {
        return soluongve;
    }

    public void setSoluongve(String soluongve) {
        this.soluongve = soluongve;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
}

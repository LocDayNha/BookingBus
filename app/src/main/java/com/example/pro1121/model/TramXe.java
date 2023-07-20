package com.example.pro1121.model;

public class TramXe {
    private  int id;

    private String idTramXe,tenTram,viTri;

    public TramXe() {
    }

    public TramXe(int id,String tenTram, String viTri) {
        this.id = id;
        this.tenTram = tenTram;
        this.viTri = viTri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdTramXe() {
        return idTramXe;
    }

    public void setIdTramXe(String idTramXe) {
        this.idTramXe = idTramXe;
    }

    public String getTenTram() {
        return tenTram;
    }

    public void setTenTram(String tenTram) {
        this.tenTram = tenTram;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}

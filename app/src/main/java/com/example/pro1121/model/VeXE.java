package com.example.pro1121.model;

public class VeXE {


    int id;

    String idvexe;
    static String vitri;
    String gia;
    String soluong;

    public VeXE(int id, String idvexe, String vitri, String gia, String soluong) {
        this.id = id;
        this.idvexe = idvexe;
        this.vitri = vitri;
        this.gia = gia;
        this.soluong = soluong;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdvexe() {
        return idvexe;
    }

    public void setIdvexe(String idvexe) {
        this.idvexe = idvexe;
    }

    public static String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }


    public VeXE(int id, String vitri, String gia, String soluong) {
        this.id = id;
        this.vitri = vitri;
        this.gia = gia;
        this.soluong = soluong;
    }

}

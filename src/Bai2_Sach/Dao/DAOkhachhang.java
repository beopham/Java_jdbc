package Bai2_Sach.Dao;

import Bai2_Sach.Model.KhachHang;

import java.util.ArrayList;

public class DAOkhachhang implements DAOinterface <KhachHang>{
    public static DAOkhachhang getInstance()
    {
        return  new DAOkhachhang();
    }
    @Override
    public int insert(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int update(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int delete(KhachHang khachHang) {
        return 0;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        return null;
    }

    @Override
    public KhachHang selectbyid(KhachHang khachHang) {
        return null;
    }

    @Override
    public ArrayList<KhachHang> selectComdition(String condition) {
        return null;
    }
}

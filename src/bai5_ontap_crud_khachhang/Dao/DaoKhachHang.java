package bai5_ontap_crud_khachhang.Dao;

import bai5_ontap_crud_khachhang.Database.JDBCUtil;
import bai5_ontap_crud_khachhang.Model.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class DaoKhachHang implements DaoInterface <KhachHang> {
    public static DaoKhachHang getInstance()
    {
        return  new DaoKhachHang();
    }
    @Override
    public int Insert(KhachHang khachHang) {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO sach.khachhang (id_kh, hoten, ngaysinh, diachi)" +
                    " VALUES (?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,khachHang.getId());
            pst.setString(2,khachHang.getHoten());
            pst.setDate(3, new java.sql.Date(khachHang.getNgaysinh().getTime()));
            pst.setString(4,khachHang.getDiachi());
            ketqua = pst.executeUpdate();
            if(ketqua==1)
            {
                System.out.println("Thêm thành công");
            }
            else
            {
                System.out.println("k thêm đc");
            }
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int Update(KhachHang khachHang) {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="UPDATE `khachhang`" +
                    " SET `id_kh` = ?, " +
                    "`hoten` = ?," +
                    " `ngaysinh` = ?, " +
                    "`diachi` = ? " +
                    " WHERE (`id_kh` = ?)";

            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1,khachHang.getId());
            pst.setString(2,khachHang.getHoten());
            pst.setDate(3, new java.sql.Date(khachHang.getNgaysinh().getTime()));
            pst.setString(4,khachHang.getDiachi());
            pst.setString(5,khachHang.getId());
            ketqua= pst.executeUpdate();

            if(ketqua ==1)
            {
                System.out.println("cập nhập thành công");
            }else
            {
                System.out.println("k cập nhập  đc");
            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int Delete(String t) {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE FROM khachhang " +
                    " WHERE (`id_kh` = ?)";

            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1,t);
            ketqua= pst.executeUpdate();

            if(ketqua ==1)
            {
                System.out.println("xóa thành công");
            }else
            {
                System.out.println("k xóa đc");
            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<KhachHang> SelectaLL() {
        ArrayList<KhachHang> kh =new ArrayList<>();
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="SELECT * FROM khachhang";
            PreparedStatement pst= con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while (rs.next())
            {
                String id_kh=rs.getString("id_kh");
                String hoten=rs.getString("hoten");
                Date ngaysinh=rs.getDate("ngaysinh");
                String diachi=rs.getString("diachi");
                KhachHang khachHang=new KhachHang(id_kh,hoten,ngaysinh,diachi);
                kh.add(khachHang);
            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
        return kh;
    }

    @Override
    public KhachHang SelectByid(String t) {
        KhachHang kh=null;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="SELECT * FROM khachhang WHERE (`id_kh` = ?)";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet rs= pst.executeQuery();
            while (rs.next())
            {
                String id_kh=rs.getString("id_kh");
                String hoten=rs.getString("hoten");
                Date ngaysinh=rs.getDate("ngaysinh");
                String diachi=rs.getString("diachi");
                kh=new KhachHang(id_kh,hoten,ngaysinh,diachi);

            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return kh;
    }

    @Override
    public int DeletaAll() {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE FROM khachhang " ;

            PreparedStatement pst= con.prepareStatement(sql);
            ketqua= pst.executeUpdate();

            if(ketqua ==1)
            {
                System.out.println("xóa thành công");
            }else
            {
                System.out.println("k xóa đc");
            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ketqua;
    }
}

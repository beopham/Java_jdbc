package Bai4_KhachHang_CodeChuan.Dao;


import Bai4_KhachHang_CodeChuan.Model.KhachHang;
import Bai4_KhachHang_CodeChuan.Database.JDBCUtil;
import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;

public class DaoKhachHang implements DaoInterface<KhachHang> {
    // 🔹 Singleton instance
    private static DaoKhachHang instance;

    // 🔹 Hàm lấy instance duy nhất
    public static DaoKhachHang getInstance() {
        if (instance == null) {
            instance = new DaoKhachHang();
        }
        return instance;
    }

    // 🔹 private constructor để ngăn tạo đối tượng trực tiếp
    private DaoKhachHang() {}
    @Override
    public int Insert(KhachHang khachHang) {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO sach.khachhang (id_kh, hoten, ngaysinh, diachi)" +
                    " VALUES (?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1,khachHang.getId());
            pst.setString(2,khachHang.getHoten());
            pst.setDate(3, new java.sql.Date(khachHang.getNgaysinh().getTime()));
            pst.setString(4,khachHang.getDiachi());
            ketqua= pst.executeUpdate();

            if(ketqua ==1)
            {
                System.out.println("thêm thành công");
            }else
            {
                System.out.println("k thêm đc");
            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }catch (SQLException e)
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

            JDBCUtil.closeConnection(con);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public int deleteById(String t) {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE FROM `sach`.`khachhang` WHERE (`id_kh` = ?)";
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
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketqua=new ArrayList<>();
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="select * from `khachhang` ";
            PreparedStatement pst= con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while (rs.next())
            {
              String id_kh=rs.getString("id_kh");
              String hoten=rs.getString("hoten");
              Date  ngaysinh=rs.getDate("ngaysinh");
              String diachi=rs.getString("diachi");
              KhachHang kh=new KhachHang(id_kh,hoten,ngaysinh,diachi);
              ketqua.add(kh);
            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ketqua;

    }

    @Override
    public KhachHang SelectByid(String t) {
        KhachHang kh=null;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="select * from `khachhang` where id_kh =?";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet rs= pst.executeQuery();
            while (rs.next())
            {
                String id_kh=rs.getString("id_kh");
                String hoten=rs.getString("hoten");
                Date  ngaysinh=rs.getDate("ngaysinh");
                String diachi=rs.getString("diachi");
                kh=new KhachHang(id_kh,hoten,ngaysinh,diachi);

            }
            pst.close();
            JDBCUtil.closeConnection(con);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return kh;
    }

    @Override
    public int DeleteALL() {
        int ketqua=0;
        try {
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE FROM `sach`.`khachhang`";
            PreparedStatement pst= con.prepareStatement(sql);

            ketqua= pst.executeUpdate();

            pst.close();
            JDBCUtil.closeConnection(con);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ketqua;
    }
}

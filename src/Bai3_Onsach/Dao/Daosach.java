package Bai3_Onsach.Dao;
import Bai3_Onsach.Database.JDBCUtil;
import Bai3_Onsach.Model.Sach;

import java.sql.*;
import java.util.ArrayList;

public class Daosach implements DAOinterface<Sach> {
    public static Daosach getInstance()
    {
        return  new Daosach();
    }
    @Override
    public int insert(Sach sach) {
        int ketqua=0;
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO sach (id, tensach, giaban, namxuatban) " +
                     "VALUES (? ,? ,? ,?)";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1, sach.getId());
            pst.setString(2, sach.getTensach());
            pst.setInt(3,sach.getGiaban());
            pst.setInt(4,sach.getNamxuatban());
            ketqua=pst.executeUpdate();
            if(ketqua ==1)
            {
                System.out.println("thêm thành công");
            }else
            {
                System.out.println("k thêm đc");
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
    public int update(Sach sach) {
        int ketqua=0;
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql = "UPDATE sach " + // Dấu cách ở cuối
                    "SET `tensach` = ?, " + // Bắt đầu bằng SET và có dấu cách
                    "`giaban` = ?, " +
                    "`namxuatban` = ? " +
                    "WHERE `id` = ?";
// Lưu ý: Cột `id` thường KHÔNG được cập nhật (nếu là khóa chính),
// và nó chỉ cần xuất hiện trong mệnh đề WHERE, trừ khi bạn muốn thay đổi khóa chính.
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1, sach.getTensach());
            pst.setInt(2,sach.getGiaban());
            pst.setInt(3,sach.getNamxuatban());
            pst.setString(4, sach.getId());
            ketqua=pst.executeUpdate();
            if(ketqua ==1)
            {
                System.out.println("thêm thành công");
            }else
            {
                System.out.println("k thêm đc");
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
    public int delete(Sach sach) {
        int ketqua=0;
        try
        {
            Connection con= JDBCUtil.getConnection();
            String sql = "DELETE FROM `sach`" +
                        "WHERE (`id` = ?)\n";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1, sach.getId());
            ketqua=pst.executeUpdate();
            if(ketqua ==1)
            {
                System.out.println("xóa thành công");
            }else
            {
                System.out.println("k thêm đc");
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
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketqua=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="Select * from sach";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while (rs.next())
            {

                String id=rs.getNString("id");
                String ten=rs.getString("tensach");
                int giaban=rs.getInt("giaban");
                int namxb=rs.getInt("namxuatban");
                Sach sach=new Sach(id,ten,giaban,namxb);
                ketqua.add(sach);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public Sach selectbyid(Sach sach) {
        Sach ketqua =null;
        try{
            Connection con=JDBCUtil.getConnection();
            Statement st= con.createStatement();
            String sql="Select * from sach wherw id = '" +sach.getId() +"'";
            ResultSet rs= st.executeQuery(sql);
            while (rs.next())
            {

                String id=rs.getNString("id");
                String ten=rs.getString("tensach");
                int giaban=rs.getInt("giaban");
                int namxb=rs.getInt("namxuatban");
                 ketqua=new Sach(id,ten,giaban,namxb);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<Sach> selectComdition(String condition) {
        return null;
    }
}

package Bai2_Sach.Dao;

import Bai2_Sach.Database.JDBCUtil;
import Bai2_Sach.Model.Sach;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOsach implements DAOinterface <Sach>{
    public static DAOsach getInstance()
    {
        return  new DAOsach();
    }
    @Override
    public int insert(Sach sach) {
        int check = 0;
        try {
            // Kết nối CSDL
            Connection con = JDBCUtil.getConnection();

            // Tạo đối tượng statement
            Statement st = con.createStatement();

            // ⚠️ Viết đúng tên bảng và tên cột trong MySQL
            // Giả sử trong DB của bạn là: id, tensach, giaban, namxuanban
            String sql = "INSERT INTO sach.sach (id, tensach, giaban, namxuatban) VALUES ("
                    + sach.getId() + ", '"
                    + sach.getTensach() + "', "
                    + sach.getGiaban() + ", "
                    + sach.getNamxuatban() + ")";

            // In ra để kiểm tra xem câu SQL thực tế là gì
            System.out.println("Câu SQL thực thi: " + sql);

            // Thực thi
            check = st.executeUpdate(sql);

            if (check > 0) {
                System.out.println("✅ Thêm thành công!");
            } else {
                System.out.println("❌ Thêm thất bại!");
            }

            // Đóng kết nối
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }


    @Override
    public int update(Sach sach) {
        return 0;
    }

    @Override
    public int delete(Sach sach) {
        return 0;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        return null;
    }

    @Override
    public Sach selectbyid(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectComdition(String condition) {
        return null;
    }
}

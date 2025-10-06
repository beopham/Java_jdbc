package Bai1_Connect_DB.Database;

import java.sql.Connection;
import java.sql.Statement;

public class Test_insert {
    public static void main(String[] args) {
        try {
            // bước 1 kết nối database
            Connection connection =Connect.getConnection();
            // bước 2 tạo đối tượng statement
            Statement st=connection.createStatement();
            // bước 3 // thực thi câu lệnh sql
            String sql="\n" +
                    "INSERT INTO `phamvannam`.`nhanvien` (`manv`, `hoten`, `ngaysinh`, `diachi`, `sdt`, `giotinh`, `mapb`, `luong`) " +
                    "VALUES ('NV034', 'Lê Công Vinh', '1998-10-30', '200 Nguyễn Duy Trinh, TP HCM', '0906542368', 'Nam', '5', '900000');\n";
            // thực thi thay đổi
            int check = st.executeUpdate(sql);
            if(check >0)
            {
                System.out.println("thêm thành công");
            }
            else
            {
                System.out.println("thất bại");
            }
            // bước 5 ngắt kết nối nha ok

            Connect.closeConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
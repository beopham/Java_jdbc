package Bai1_Connect_DB.Database;

import java.sql.Connection;
import java.sql.Statement;

public class Oninsert {
    public static void main(String[] args) {

        try {
            // bước 1 kết nối database
            Connection con =JDBCUtil.getConnection();
            // tạo đối tượng staetemnet
            Statement st= con.createStatement();
            // viết câu lệnh sql
            String sql="\n" +
                    "INSERT INTO `phamvannam`.`nhanvien` (`manv`, `hoten`, `ngaysinh`, `diachi`, `sdt`, `giotinh`, `mapb`, `luong`) " +
                    "VALUES ('NV036', 'Nguyễn Thanh Thảo', '1999-11-30', '452 Nguyễn Duy, TP HCM', '0563521023', 'Nữ', '3', '600000');\n";
            // thực thi câu lệnh
            int check=st.executeUpdate(sql);
             boolean found=false;
             if (check==1)
             {
                 found=true;
             }
             if(found)
             {
                 System.out.println("thêm thành công");
             }
             else
             {
                 System.out.println("k thêm đc");
             }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

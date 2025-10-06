package Bai1_Connect_DB.Database;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        // Gọi hàm getConnection
        Connection conn = Connect.getConnection();

        if (conn != null) {
            System.out.println("✅ Kết nối thành công!");
            // In thêm thông tin DB
            Connect.printInfo(conn);
            // Đóng kết nối
            Connect.closeConnection(conn);
        } else {
            System.out.println("❌ Kết nối thất bại!");
        }
    }
}

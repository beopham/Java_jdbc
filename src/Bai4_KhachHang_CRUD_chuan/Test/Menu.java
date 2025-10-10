package Bai4_KhachHang_CodeChuan.Test;

import Bai4_KhachHang_CodeChuan.Dao.DaoKhachHang;
import Bai4_KhachHang_CodeChuan.Model.KhachHang;
import java.sql.Date;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        DaoKhachHang dao= DaoKhachHang.getInstance();
        Scanner nhapso=new Scanner(System.in);
        Scanner nhapchu=new Scanner(System.in);
        while (true)
        {
            System.out.println("\n===== MENU QUẢN LÝ KHÁCH HÀNG =====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Cập nhật khách hàng");
            System.out.println("3. Xóa khách hàng theo ID");
            System.out.println("4. Hiển thị tất cả khách hàng");
            System.out.println("5. Tìm khách hàng theo ID");
            System.out.println("6. Xóa tất cả khách hàng");
            System.out.println("0. Thoát");
            System.out.print("👉 Nhập lựa chọn của bạn: ");
            int chon = nhapso.nextInt();
            if (chon==1)
            {
                System.out.print("Nhập ID khách hàng: ");
                String id = nhapchu.nextLine();
                System.out.print("Nhập họ tên: ");
                String hoten = nhapchu.nextLine();
                System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
                Date ngaysinh = Date.valueOf(nhapchu.nextLine());
                System.out.print("Nhập địa chỉ: ");
                String diachi = nhapchu.nextLine();

                KhachHang kh = new KhachHang(id, hoten, ngaysinh, diachi);
                dao.Insert(kh);
            } else if (chon==2) {

            }
        }

    }
}

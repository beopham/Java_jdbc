package Bai4_KhachHang_CRUD_chuan.Test;

import Bai4_KhachHang_CRUD_chuan.Dao.DaoKhachHang;
import Bai4_KhachHang_CRUD_chuan.Model.KhachHang;
import java.sql.Date;

import java.util.ArrayList;
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
            System.out.println("7. Thoát");
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
            }
            else if (chon==2)
            {
                // nhập id khách hàng cần cập nhập
                System.out.println("Nhập id khách hàng cần cập nhập ");
                String id_capnhap=nhapchu.nextLine();
                System.out.println("================");
                // lấy thông tin khách hàng theo id
                KhachHang kh=dao.SelectByid(id_capnhap);
                if (kh == null) {
                    System.out.println("❌ Không tìm thấy khách hàng có ID này.");
                    return;
                }

                System.out.println("Thông tin cũ của khách hàng");
                kh.danhsach();
                System.out.print("Nhập ID mới: ");
                String id = nhapchu.nextLine();
                nhapchu.nextLine();
                System.out.print("Nhập họ tên mới: ");
                String hoten = nhapchu.nextLine();
                System.out.print("Nhập ngày sinh mới (yyyy-mm-dd): ");
                Date ngaysinh = Date.valueOf(nhapchu.nextLine());
                System.out.print("Nhập địa chỉ mới: ");
                String diachi = nhapchu.nextLine();

                KhachHang khMoi = new KhachHang(id, hoten, ngaysinh, diachi);
                dao.Update(khMoi);

            }
            else if (chon==3)
            {
                System.out.println("nhập id khách hàng cần xóa");
                String id_xoa=nhapchu.nextLine();
                int xoa=dao.deleteById(id_xoa);
                if (xoa==1)
                {
                    System.out.println("xoa thành công");
                }
                else
                {
                    System.out.println("k xóa đc");
                }
            }
            else if (chon==4)
            {
                ArrayList<KhachHang> danhsach=dao.selectAll();
                for(KhachHang kh :danhsach)
                {
                    kh.danhsach();
                }
            }
            else if (chon==5)
            {
                System.out.println("nhập id khách hàng cần tìm kiếm");
                String id_timkiem=nhapchu.nextLine();
                KhachHang kh=dao.SelectByid(id_timkiem);
                if (kh != null) {
                    System.out.println("✅ Thông tin khách hàng:");
                    kh.danhsach();
                } else {
                    System.out.println("❌ Không tìm thấy khách hàng này.");
                }
            }
            else if (chon==6)
            {

                int xoa=dao.DeleteALL();
                System.out.println("đã xóa thành công");
            }
            else if (chon==7)
            {
                System.out.println("bạn đã thoát chương trình");
                break;
            }
        }

    }
}

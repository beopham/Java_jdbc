package CRUD_CHUAN_KH.Test;

import CRUD_CHUAN_KH.Dao.DaoKhachhang;
import CRUD_CHUAN_KH.Model.KhachHang;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Quanlikhachhang {
    public static void main(String[] args) {

        DaoKhachhang dao=DaoKhachhang.getInstance();
        Scanner nhapchu=new Scanner(System.in);
        Scanner nhapso=new Scanner(System.in);
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
            if(chon==1)
            {
                System.out.println("Nhập vào id khách hàng");
                String id_kh=nhapchu.nextLine();
                System.out.println("Nhập vào họ tên khách hàng");
                String hoten=nhapchu.nextLine();
                System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
                Date ngaysinh = Date.valueOf(nhapchu.nextLine());
                System.out.println("Nhập địa chỉ khách hàng");
                String diachi=nhapchu.nextLine();
                KhachHang kh=new KhachHang(id_kh,hoten,ngaysinh,diachi);
                dao.Insert(kh);
            }
            else if (chon==2)
            {
                System.out.println("Nhập vào id khách hàng");
                String id_tk=nhapchu.nextLine();
                KhachHang kh=dao.selectByid(id_tk);
                if(kh==null)
                {
                    System.out.println("khách hàng k tồn tại");
                }
                else
                {
                    System.out.println("Thông tin cũ của khách hàng");
                    kh.danhsach();
                    System.out.println("======================");
                    System.out.print("Nhập họ tên mới: ");
                    String hoten = nhapchu.nextLine();
                    System.out.print("Nhập ngày sinh mới (yyyy-mm-dd): ");
                    Date ngaysinh = Date.valueOf(nhapchu.nextLine());
                    System.out.print("Nhập địa chỉ mới: ");
                    String diachi = nhapchu.nextLine();
                    KhachHang khmoi=new KhachHang(hoten,ngaysinh,diachi);
                    dao.Update(khmoi);
                }

            }
            else if (chon==3)
            {
                System.out.println("Nhập vào id khách hàng");
                String id=nhapchu.nextLine();
                dao.Delete(id);
            }
            else if (chon==4)
            {

                ArrayList<KhachHang> kh=dao.selectAll();
                for (KhachHang kq : kh)
                {
                    kq.danhsach();
                }
            }
            else if (chon==5)
            {
                System.out.println("Nhập vào id khách hàng");
                String id=nhapchu.nextLine();
                KhachHang kh=dao.selectByid(id);
                if(kh==null)
                {
                    System.out.println("k có thông tin");
                }
                else
                {
                    kh.danhsach();
                }
            }
            else if (chon==6)
            {
               dao.DeleteAll();
            }
            else if (chon==7)
            {
                System.out.println("Bạn đã thoát");
                break;
            }

        }

    }
}

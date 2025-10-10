package Bai4_KhachHang_CodeChuan.Model;

import java.util.Date;

public class KhachHang {
    private String id;
    private String hoten;
    private Date ngaysinh;
    private String diachi;

    public KhachHang()
    {

    }

    public KhachHang(String id) {
        this.id = id;
    }

    public KhachHang(String id, String hoten, Date ngaysinh, String diachi) {
        this.id = id;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "id='" + id + '\'' +
                ", hoten='" + hoten + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}

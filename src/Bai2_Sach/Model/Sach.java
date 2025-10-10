package Bai2_Sach.Model;

public class Sach {
    private String id;
    private String tensach;
    private int giaban;
    private int namxuatban;

    public Sach()
    {

    }

    public Sach(String id, String tensach, int giaban, int namxuatban) {
        this.id = id;
        this.tensach = tensach;
        this.giaban = giaban;
        this.namxuatban = namxuatban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(int namxuatban) {
        this.namxuatban = namxuatban;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id='" + id + '\'' +
                ", tensach='" + tensach + '\'' +
                ", giaban=" + giaban +
                ", namxuatban=" + namxuatban +
                '}';
    }
}

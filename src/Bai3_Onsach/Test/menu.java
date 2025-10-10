package Bai3_Onsach.Test;

import Bai3_Onsach.Dao.Daosach;
import Bai3_Onsach.Model.Sach;

import java.util.ArrayList;

public class menu {
    public static void main(String[] args) {
        Daosach dao=Daosach.getInstance();
        ArrayList <Sach> List= dao.selectAll();
        for (Sach kq :List)
        {
            System.out.println(kq.toString());
        }
        Sach sach1=new Sach("3","bavie",200,300);

        dao.insert(sach1);
    }
}

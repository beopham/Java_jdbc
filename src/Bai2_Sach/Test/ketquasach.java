package Bai2_Sach.Test;

import Bai2_Sach.Dao.DAOsach;
import Bai2_Sach.Model.Sach;

public class ketquasach {
    public static void main(String[] args) {
        Sach sach1 = new Sach("2" ,"nobita" ,200,2006);
        DAOsach.getInstance().insert(sach1);
    }
}

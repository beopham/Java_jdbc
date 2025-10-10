package Bai4_KhachHang_CodeChuan.Dao;

import java.util.ArrayList;

public interface DaoInterface <T> {
      public int Insert(T t);
      public int Update(T t);
      public int  deleteById (String t);
      public ArrayList<T> selectAll();
      public T SelectByid(String t);
      public int DeleteALL();


}

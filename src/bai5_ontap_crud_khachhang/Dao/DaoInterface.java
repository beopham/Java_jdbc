package bai5_ontap_crud_khachhang.Dao;

import java.util.ArrayList;

public interface DaoInterface <T> {
    public int Insert(T t);
    public int Update(T t);
    public int Delete(String t);
    public ArrayList<T> SelectaLL();
    public T SelectByid(String t);
    public int DeletaAll();


}

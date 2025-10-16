package CRUD_CHUAN_KH.Dao;

import java.util.ArrayList;

public interface DaoInterface<T>{
    public int Insert (T t);
    public int Update (T t);
    public int Delete(String t);
    public ArrayList<T> selectAll();
    public T selectByid(String t);
    public int DeleteAll();
}

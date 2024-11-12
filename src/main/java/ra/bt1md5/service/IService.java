package ra.bt1md5.service;

import java.util.List;

public interface IService <T,E>{
    List<T> findAll();
    T findById(E id);
    void save(T t);
    void deleteById(E id);
}

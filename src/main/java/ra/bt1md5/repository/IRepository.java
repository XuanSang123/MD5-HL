package ra.bt1md5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.bt1md5.model.Product;

import java.util.List;

public interface IRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.name like %:name%")
    List<Product> getAllAndSearch(@Param("name") String name);


}

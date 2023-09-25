package com.gadaElectronics.repository;

import com.gadaElectronics.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    @Query("select p from Product p where name like concat('%', :str, '%')")
    public List<Product> searchProducts(@Param("str") String str);
}
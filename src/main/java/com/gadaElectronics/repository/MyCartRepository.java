package com.gadaElectronics.repository;

import com.gadaElectronics.entity.MyCartList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCartRepository extends JpaRepository<MyCartList,Integer> {
}

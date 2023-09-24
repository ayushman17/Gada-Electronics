package com.gadaElectronics.service;

import com.gadaElectronics.entity.MyCartList;
import com.gadaElectronics.repository.MyCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MyCartListService {
    @Autowired
    private MyCartRepository mycart;

    public void saveMyCart(MyCartList book) {
        mycart.save(book);
    }

    public List<MyCartList> getAllMyCart(){
        return mycart.findAll();
    }

    public void deleteById(int id) {
        mycart.deleteById( id);
    }

    public void clearCart() {
        mycart.deleteAll();
    }
}

package com.gadaElectronics.service;

import com.gadaElectronics.entity.Product;
import com.gadaElectronics.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pRepo;

    public void save(Product b) {
        pRepo.save(b);
    }

    public List<Product> getAllProduct() {
        return pRepo.findAll();
    }

    public Product getProductById(int id) {
        return pRepo.findById(id).get();
    }

    public void deleteById(int id) {
        pRepo.deleteById(id);
    }
}


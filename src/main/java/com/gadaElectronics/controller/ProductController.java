package com.gadaElectronics.controller;

import com.gadaElectronics.entity.MyCartList;
import com.gadaElectronics.entity.Product;
import com.gadaElectronics.service.MyCartListService;
import com.gadaElectronics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private MyCartListService myCartService;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/product_register")
    public String productRegister() {
        return "productRegister";
    }
    @GetMapping("/available_products")
    public ModelAndView getAllProduct() {
        List<Product> pList=service.getAllProduct();
        return new ModelAndView("productList","product",pList);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Product p) {
        service.save(p);
        return "redirect:/available_products";
    }
    @GetMapping("/my_cart")
    public String getMyBooks(Model model)
    {
        List<MyCartList>list=myCartService.getAllMyCart();
        model.addAttribute("product",list);

        double totalAmount = calculateTotalAmount(list);
        model.addAttribute("totalAmount", totalAmount);
        return "myCart";
    }
    private double calculateTotalAmount(List<MyCartList> cartItems) {
        double totalAmount = 0.0;
        for (MyCartList item : cartItems) {
            totalAmount += Double.parseDouble(item.getPrice());
        }
        //System.out.println(totalAmount);
        return totalAmount;

    }

    @RequestMapping("/mycart/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Product p=service.getProductById(id);
        MyCartList mb=new MyCartList(p.getId(),p.getName(),p.getCompany(),p.getPrice());
        myCartService.saveMyCart(mb);
        return "redirect:/my_cart";
    }
    @RequestMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id,Model model) {
        Product p=service.getProductById(id);
        model.addAttribute("product",p);
        return "productEdit";
    }
    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_products";
    }

}
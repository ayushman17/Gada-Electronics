package com.gadaElectronics.controller;

import com.gadaElectronics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    //    @PostMapping("/search")
//    public String search(@RequestParam(name = "query", required = false) String query, Model model) {
//        // Implement your search logic here.
//        // You can use the "query" parameter to perform a search in your data.
//
//        // For example, you can pass search results to the view:
//        // List<Product> searchResults = productService.searchProducts(query);
//        // model.addAttribute("results", searchResults);
//
//        return "searchResults"; // Create a Thymeleaf template for displaying search results.
//    }
    @Autowired
    ProductService productService;
    @PostMapping(value = "/search")
    public String searchProducts(@RequestParam("qry") String str, Model model) {
        model.addAttribute("products", productService.searchProducts(str));
        return "productList";
    }

}

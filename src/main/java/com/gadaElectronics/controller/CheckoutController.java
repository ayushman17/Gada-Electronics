package com.gadaElectronics.controller;

import com.gadaElectronics.entity.MyCartList;
import com.gadaElectronics.entity.Order;
import com.gadaElectronics.service.MyCartListService;
import com.gadaElectronics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CheckoutController {

    private final MyCartListService myCartService;
    private final OrderService orderService;

    @Autowired
    public CheckoutController(MyCartListService myCartService, OrderService orderService) {
        this.myCartService = myCartService;
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public String checkout(Model model) {
        List<MyCartList> cartItems = myCartService.getAllMyCart();
        double totalAmount = calculateTotalAmount(cartItems);

        Order order = new Order();
        order.setCartItems(cartItems);
        order.setTotalAmount(totalAmount);

        orderService.saveOrder(order);

        myCartService.clearCart();

        model.addAttribute("message", "Order placed successfully!");
        model.addAttribute("cartItems", cartItems);

        return "checkoutConfirmation";
    }

    private double calculateTotalAmount(List<MyCartList> cartItems) {
        double totalAmount = 0.0;
        for (MyCartList item : cartItems) {
            totalAmount += Double.parseDouble(item.getPrice());
        }
        return totalAmount;
    }
}

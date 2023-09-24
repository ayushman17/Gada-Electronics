package com.gadaElectronics.service;

import com.gadaElectronics.entity.Order;
import com.gadaElectronics.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MyCartListService myCartService;

    @Autowired
    public OrderService(OrderRepository orderRepository, MyCartListService myCartService) {
        this.orderRepository = orderRepository;
        this.myCartService = myCartService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void saveOrder(Order order) {
        orderRepository.save(order);
        myCartService.clearCart();
    }

    @Transactional
    public void clearCart() {
        myCartService.clearCart();
    }
}

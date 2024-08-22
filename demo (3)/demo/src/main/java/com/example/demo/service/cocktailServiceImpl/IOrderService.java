package com.example.demo.service.cocktailServiceImpl;

import com.example.demo.model.DTO.OrderCalculationDTO;

import java.util.List;

public interface IOrderService {

    OrderCalculationDTO calculateOrder(Long id, int cantidad);// Nuevo método para calcular órdenes
}

package com.example.demo.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCalculationDTO {

    private String nombre;
    private double precio;
    private double descuento;
    private double valorBruto;
    private double valorTotal;
}

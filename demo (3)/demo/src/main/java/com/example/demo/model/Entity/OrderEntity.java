package com.example.demo.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idorden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcocktail", nullable = false)
    private cocktailEntity cocktail;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double descuento;

    @Column(nullable = false)
    private int valorNeto;

    @Column(nullable = false)
    private int valorBruto;
}

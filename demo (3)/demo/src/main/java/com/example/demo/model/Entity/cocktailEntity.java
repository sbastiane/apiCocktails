package com.example.demo.model.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "cocktail")
public class cocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(length = 255)
    private String descrip;

    @Column(nullable = false)
    private Double tamaño; // En litros

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false)
    private Float gradodealcohol; // En porcentaje

    @Column(nullable = false, length = 50)
    private String paisorigen;

    @Column
    private LocalDate fechavencimiento;

    @Column(nullable = false)
    private Integer tiempopreparacion; // En minutos

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

}

package com.example.demo.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class cocktailDTO {

    private Long id;
    private String nombre;
    private Double precio;
    private String descrip;
    private Double tamaño; // En litros
    private String tipo;
    private Float gradodealcohol; // En porcentaje
    private String paisorigen;
    private LocalDate fechavencimiento;
    private Integer tiempopreparacion; // En minutos
    private byte[] imagen;
}

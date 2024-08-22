package com.example.demo.service.cocktailServiceImpl;

import com.example.demo.mapper.IMapper;
import com.example.demo.model.DTO.OrderCalculationDTO;
import com.example.demo.model.DTO.cocktailDTO;
import com.example.demo.model.Entity.OrderEntity;
import com.example.demo.model.Entity.cocktailEntity;
import com.example.demo.model.enums.tipo;
import com.example.demo.repositories.ICocktailRepository;
import com.example.demo.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private ICocktailRepository cocktailRepository;



    @Autowired
    private IMapper<cocktailEntity, cocktailDTO> cocktailMapper;



    @Override
    public OrderCalculationDTO calculateOrder(Long id, int cantidad) {
        Optional<cocktailEntity> optionalCocktailEntity = cocktailRepository.findById(id);
        if (optionalCocktailEntity.isPresent()) {
            cocktailEntity cocktail = optionalCocktailEntity.get();
            double precio = cocktail.getPrecio();
            double valorBruto = cantidad * precio;
            double descuento = 0;

            if (cocktail.getTipo().equals(tipo.PERECEDERO.toString()) && cocktail.getFechavencimiento() != null) {
                LocalDate fechaVencimiento = cocktail.getFechavencimiento();
                LocalDate hoy = LocalDate.now();
                long diasParaVencer = ChronoUnit.DAYS.between(hoy, fechaVencimiento);

                if (diasParaVencer == 3) {
                    descuento = valorBruto * 0.02;
                } else if (diasParaVencer == 2) {
                    descuento = valorBruto * 0.035;
                } else if (diasParaVencer == 1) {
                    descuento = valorBruto * 0.05;
                }
            }

            double valorTotal = valorBruto - descuento;

            return new OrderCalculationDTO(
                    cocktail.getNombre(),
                    precio,
                    descuento,
                    valorBruto,
                    valorTotal
            );
        }
        return null;
    }
}

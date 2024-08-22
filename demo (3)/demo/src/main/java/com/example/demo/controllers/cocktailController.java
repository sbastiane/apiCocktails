package com.example.demo.controllers;

import com.example.demo.model.DTO.OrderCalculationDTO;
import com.example.demo.service.cocktailServiceImpl.ICocktailService;
import com.example.demo.model.DTO.cocktailDTO;
import com.example.demo.service.cocktailServiceImpl.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails")
@CrossOrigin(origins = "http://localhost:8080")
public class cocktailController {

    @Autowired
    private ICocktailService cocktailService;

    @Autowired
    private IOrderService orderService;


    @GetMapping
    public List<cocktailDTO> getAllCocktails() {
        return cocktailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<cocktailDTO> getCocktailById(@PathVariable Long id) {
        cocktailDTO cocktailDTO = cocktailService.findById(id);
        if (cocktailDTO != null) {
            return ResponseEntity.ok(cocktailDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public cocktailDTO createCocktail(@RequestBody cocktailDTO cocktailDTO) {
        return cocktailService.save(cocktailDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<cocktailDTO> updateCocktail(@PathVariable Long id, @RequestBody cocktailDTO cocktailDTO) {
        cocktailDTO updatedCocktailDTO = cocktailService.update(id, cocktailDTO);
        if (updatedCocktailDTO != null) {
            return ResponseEntity.ok(updatedCocktailDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCocktail(@PathVariable Long id) {
        cocktailService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/calculate")
    public ResponseEntity<OrderCalculationDTO> calculateOrder(
            @RequestParam Long id,
            @RequestParam int cantidad) {
        OrderCalculationDTO orderCalculationDTO = orderService.calculateOrder(id, cantidad);
        if (orderCalculationDTO != null) {
            return ResponseEntity.ok(orderCalculationDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

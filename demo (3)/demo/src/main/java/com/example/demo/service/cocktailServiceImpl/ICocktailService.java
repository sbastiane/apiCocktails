package com.example.demo.service.cocktailServiceImpl;

import com.example.demo.model.DTO.cocktailDTO;

import java.util.List;
import java.util.Optional;

public interface ICocktailService {

    List<cocktailDTO> findAll();

    cocktailDTO findById(Long id);

    cocktailDTO save(cocktailDTO cocktailDTO);

    cocktailDTO update(Long id, cocktailDTO cocktailDTO);

    void delete(Long id);

}

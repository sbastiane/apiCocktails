package com.example.demo.service.cocktailServiceImpl;

import com.example.demo.service.cocktailServiceImpl.ICocktailService;
import com.example.demo.mapper.IMapper;
import com.example.demo.model.DTO.cocktailDTO;
import com.example.demo.model.Entity.cocktailEntity;
import com.example.demo.model.enums.tipo;
import com.example.demo.repositories.ICocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class cocktailService implements ICocktailService {

    @Autowired
    private ICocktailRepository cocktailRepository;

    @Autowired
    private IMapper<cocktailEntity, cocktailDTO> cocktailMapper;

    @Override
    public List<cocktailDTO> findAll() {
        return cocktailRepository.findAll().stream()
                .map(cocktailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public cocktailDTO findById(Long id) {
        Optional<cocktailEntity> cocktailEntity = cocktailRepository.findById(id);
        return cocktailEntity.map(cocktailMapper::entityToDto).orElse(null);
    }

    @Override
    public cocktailDTO save(cocktailDTO cocktailDTO) {
        cocktailEntity cocktailEntity = cocktailMapper.dtoToEntity(cocktailDTO);
        return cocktailMapper.entityToDto(cocktailRepository.save(cocktailEntity));
    }

    @Override
    public cocktailDTO update(Long id, cocktailDTO cocktailDTO) {
        Optional<cocktailEntity> optionalCocktailEntity = cocktailRepository.findById(id);
        if (optionalCocktailEntity.isPresent()) {
            cocktailEntity existingCocktail = optionalCocktailEntity.get();
            existingCocktail.setNombre(cocktailDTO.getNombre());
            existingCocktail.setPrecio(cocktailDTO.getPrecio());
            existingCocktail.setDescrip(cocktailDTO.getDescrip());
            existingCocktail.setTamaño(cocktailDTO.getTamaño());
            existingCocktail.setTipo(cocktailDTO.getTipo());
            existingCocktail.setGradodealcohol(cocktailDTO.getGradodealcohol());
            existingCocktail.setPaisorigen(cocktailDTO.getPaisorigen());
            existingCocktail.setFechavencimiento(cocktailDTO.getFechavencimiento());
            existingCocktail.setTiempopreparacion(cocktailDTO.getTiempopreparacion());
            existingCocktail.setImagen(cocktailDTO.getImagen());
            return cocktailMapper.entityToDto(cocktailRepository.save(existingCocktail));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        cocktailRepository.deleteById(id);
    }


    }


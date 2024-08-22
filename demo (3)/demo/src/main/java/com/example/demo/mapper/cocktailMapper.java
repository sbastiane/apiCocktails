package com.example.demo.mapper;

import com.example.demo.model.DTO.cocktailDTO;
import com.example.demo.model.Entity.cocktailEntity;
import org.springframework.stereotype.Component;


@Component
public class cocktailMapper  implements IMapper<cocktailEntity, cocktailDTO> {

    @Override
    public cocktailDTO entityToDto(cocktailEntity entity) {
        return new cocktailDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getDescrip(),
                entity.getTamaño(),
                entity.getTipo(),
                entity.getGradodealcohol(),
                entity.getPaisorigen(),
                entity.getFechavencimiento(),
                entity.getTiempopreparacion(),
                entity.getImagen()
        );
    }

    @Override
    public cocktailEntity dtoToEntity(cocktailDTO dto) {
        return new cocktailEntity(
                dto.getId(),
                dto.getNombre(),
                dto.getPrecio(),
                dto.getDescrip(),
                dto.getTamaño(),
                dto.getTipo(),
                dto.getGradodealcohol(),
                dto.getPaisorigen(),
                dto.getFechavencimiento(),
                dto.getTiempopreparacion(),
                dto.getImagen()
        );
    }
}
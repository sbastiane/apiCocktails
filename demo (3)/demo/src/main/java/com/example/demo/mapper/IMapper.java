package com.example.demo.mapper;

public interface IMapper <E, D> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

}

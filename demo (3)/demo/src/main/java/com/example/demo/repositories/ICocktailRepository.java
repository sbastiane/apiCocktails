package com.example.demo.repositories;

import com.example.demo.model.Entity.cocktailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICocktailRepository extends JpaRepository<cocktailEntity, Long> {


}
